package com.example.api.security.jwt;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;
import com.example.api.security.services.UserDetailsServiceImpl;



// Vamos definir um filtro que seja executado uma vez por solicitação. Então criamos a classe 
// AuthTokenFilter que estende OncePerRequestFilter e sobrescreve o método doFilterInternal().

/*
    O que fazemos dentro do doFilterInternal(): 
    – obter JWT dos Cookies HTTP 
    – se o pedido tiver JWT, valide-o, analise o nome de usuário dele 
    – do nome de usuário, obtenha UserDetails para criar um objeto de autenticação 
    – defina os UserDetails atuais no SecurityContext usando o método setAuthentication(authentication). 
    Depois disso, toda vez que você quiser obter UserDetails, basta usar SecurityContext assim: 
    
    UserDetails userDetails = (UserDetails) 
    SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
    // userDetails.getUsername() 
    // userDetails.getPassword() 
    // userDetails.getAuthorities()
*/


public class AuthTokenFilter extends OncePerRequestFilter {
    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    private static final Logger logger = LoggerFactory.getLogger(AuthTokenFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
        try {
            String jwt = parseJwt(request);
            if (jwt != null && jwtUtils.validateJwtToken(jwt)) {
                String username = jwtUtils.getUserNameFromJwtToken(jwt);
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                
                UsernamePasswordAuthenticationToken authentication = 
                    new UsernamePasswordAuthenticationToken(userDetails,
                                                            null,
                                                            userDetails.getAuthorities());
                
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (Exception e) {
            logger.error("Cannot set user authentication: {}", e);
        }
        filterChain.doFilter(request, response);
    }

    private String parseJwt(HttpServletRequest request) {
        String jwt = jwtUtils.getJwtFromCookies(request);
        return jwt;
    }
}