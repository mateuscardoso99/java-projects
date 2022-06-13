package com.alura.forumspringapi.config.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alura.forumspringapi.modelo.Usuario;
import com.alura.forumspringapi.repository.UsuarioRepository;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

//interceptor, vai executar sempre quando uma request chegar, para verificar o token
//esse interceptor tem que ser registrado na classe security configurations

public class AutenticacaoTokenFilter extends OncePerRequestFilter{//classe de intercetor do spring, é preciso implementar o metodo dofilterinternal
    
    private TokenService tokenService;
    private UsuarioRepository usuarioRepository;

    /*
        Por que não é possível fazer injeção de dependências com a anotação @Autowired na 
        classe AutenticacaoViaTokenFilter?
        Porque ela não é um bean gerenciado pelo Spring
        O filtro foi instanciado manualmente por nós, na classe SecurityConfigurations e 
        portanto o Spring não consegue realizar injeção de dependências via @Autowired.
    */
    public AutenticacaoTokenFilter(TokenService tokenService, UsuarioRepository usuarioRepository){
        this.tokenService = tokenService;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
        throws ServletException, IOException {

        String token = recuperarToken(request);
        boolean valido = tokenService.isTokenValido(token);
        if (valido) {
            autenticarCliente(token);
        }

        filterChain.doFilter(request, response);
    }

    //verifica se existe o token na request
    private String recuperarToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token==null || token.isEmpty() || !token.startsWith("Bearer ")) {
            return null;
        }
        return token.substring(7,token.length());//retorna o tk sem a palavra bearer
    }

    private void autenticarCliente(String token) {
        Long idUsuario = tokenService.getIdUsuario(token);
        Usuario usuario = usuarioRepository.findById(idUsuario).get();
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken (usuario, null, usuario.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);//autenticando usuario
    }
}
