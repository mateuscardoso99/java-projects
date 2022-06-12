package com.alura.forumspringapi.config.security;

import java.util.Optional;

import com.alura.forumspringapi.modelo.Usuario;
import com.alura.forumspringapi.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService implements UserDetailsService{//implements UserDetailsService indica ao Spring Security que essa é a classe service que executa a lógica de autenticação
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    //implementando método da interface de serviço de autenticação UserDetailsService 

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Optional<Usuario> usuario = usuarioRepository.findByEmail(username);
        if (usuario.isPresent()) {
            return usuario.get();
            //se achar o usuário ele retorna o usuário e o spring faz a validação de senha
            //senão retorna um erro
        }
        throw new UsernameNotFoundException("Dados inválidos");
    }
}
