package com.alura.forumspringapi.controller;

import javax.validation.Valid;

import com.alura.forumspringapi.config.security.TokenService;
import com.alura.forumspringapi.controller.dto.TokenDto;
import com.alura.forumspringapi.controller.form.LoginForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authManager;//pra injetar essa classe precisa fazer um override do metodo na classe SecurityConfigurations
    
    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<TokenDto> autenticar(@RequestBody @Valid LoginForm dados){
        UsernamePasswordAuthenticationToken dadosLogin = dados.converter();
        //precisa ser um objeto do tipo UsernamePasswordAuthenticationToken para autenticar

        try {
            Authentication authentication = authManager.authenticate(dadosLogin);
            String token = tokenService.gerarToken(authentication);//classe que gera o token jwt recebe o objeto com os dados do usuario

            return ResponseEntity.ok(new TokenDto(token, "Bearer"));
        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
