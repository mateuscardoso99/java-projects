package com.example.api.security.jwt;
import java.util.Date;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;
import org.springframework.web.util.WebUtils;
import com.example.api.security.services.UserDetailsImpl;
import io.jsonwebtoken.*;

/*
    Esta classe tem 3 funções principais: 
    - getJwtFromCookies: obtenha JWT de Cookies pelo nome do Cookie 
    - generateJwtCookie: gera um Cookie contendo JWT de nome de usuário, data, expiração, secret
    - getCleanJwtCookie: retorna Cookie com valor nulo (usado para Cookie limpo) 
    - getUserNameFromJwtToken: obtenha o nome de usuário do JWT 
    - validateJwtToken: validar um JWT com um secret
*/

// Lembre-se de que adicionamos as propriedades 
//bezkoder.app.jwtSecret, 
//bezkoder.app.jwtExpirationMs e 
//bezkoder.app.jwtCookieName no arquivo application.properties.


@Component
public class JwtUtils {
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    @Value("${bezkoder.app.jwtSecret}")
    private String jwtSecret;

    @Value("${bezkoder.app.jwtExpirationMs}")
    private int jwtExpirationMs;

    @Value("${bezkoder.app.jwtCookieName}")
    private String jwtCookie;

    public String getJwtFromCookies(HttpServletRequest request) {
        Cookie cookie = WebUtils.getCookie(request, jwtCookie);
        if (cookie != null) {
            return cookie.getValue();
        } else {
            return null;
        }
    }

    /**
     * Um Cookie HttpOnly é uma tag adicionada a um cookie do navegador que impede que scripts do 
     * lado do cliente acessem dados. Ele fornece um portão que impede que o cookie especializado 
     * seja acessado por qualquer coisa que não seja o servidor. Usar a tag HttpOnly ao gerar um 
     * cookie ajuda a mitigar o risco de scripts do lado do cliente acessarem o cookie protegido, 
     * tornando esses cookies mais seguros.
     */
    
    public ResponseCookie generateJwtCookie(UserDetailsImpl userPrincipal) {
        String jwt = generateTokenFromUsername(userPrincipal.getUsername());
        ResponseCookie cookie = ResponseCookie.from(jwtCookie, jwt).path("/api").maxAge(24 * 60 * 60).httpOnly(true).build();
        return cookie;
    }

    public ResponseCookie getCleanJwtCookie() {
        ResponseCookie cookie = ResponseCookie.from(jwtCookie, null).path("/api").build();
        return cookie;
    }

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            logger.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage());
        }
        return false;
    }
    
    public String generateTokenFromUsername(String username) {
        return Jwts.builder()
            .setSubject(username)
            .setIssuedAt(new Date())
            .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
            .signWith(SignatureAlgorithm.HS512, jwtSecret)
            .compact();
    }
}