package com.alura.forumspringapi.config.security;

import java.util.Date;

import com.alura.forumspringapi.modelo.Usuario;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

    @Value("${forum.jwt.expiration}")
    private String expiration;

    @Value("${forum.jwt.secret}")
    private String secretKey;
    
    public String gerarToken(Authentication authentication){
        Usuario usuarioLogado = (Usuario) authentication.getPrincipal();//retorna usuario logado
        Date hoje = new Date();
        Date dataExpiracao = new Date(hoje.getTime() + Long.parseLong(expiration));

        return Jwts.builder()
            .setIssuer("API forum alura")//quem está gerando token
            .setSubject(usuarioLogado.getId().toString())//identificador do usuario
            .setIssuedAt(hoje)//data da geracao do tk
            .setExpiration(dataExpiracao)//ideal ser 30/1hora a expiração do tk
            .signWith(SignatureAlgorithm.HS256,secretKey)//algoritmo de hash
            .compact();
    }

    public boolean isTokenValido(String token){
        try {
            Jwts.parser().setSigningKey(this.secretKey).parseClaimsJws(token);
            return true;    
        } catch (Exception e) {
            return false;
        }
    }

    //pega o usuario que o token pertence pelo id do usuario que foi colocado no tk no
    // momento da criacao do tk (no setSubject())
    public Long getIdUsuario(String token) {
        Claims claims = Jwts.parser().setSigningKey(this.secretKey).parseClaimsJws(token).getBody();
        return Long.parseLong(claims.getSubject());
    }
}
