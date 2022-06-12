package com.alura.forumspringapi.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity //habilita modulo de segurança
@Configuration //quando o spring iniciar vai ler o que está nessa classe por causa dessa anotação
public class SecurityConfigurations extends WebSecurityConfigurerAdapter{
    
    @Autowired
    private AutenticacaoService autenticacaoService;
     
    //configurações de autenticação, parte de controle de acesso, login.
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(autenticacaoService).passwordEncoder(new BCryptPasswordEncoder());
        //dizendo qual é a classe responsável pela lógica de autenticação
        //e o algoritmo de hash da senha
    }

    //configurações de autorização. parte de URLs, quem pode acessar cada url, perfil de acesso
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
        .antMatchers(HttpMethod.GET,"/topicos").permitAll()
        .antMatchers(HttpMethod.GET,"/topicos/*").permitAll()
        .anyRequest().authenticated()
        .and().formLogin();

        /**
         * http.authorizeRequests() é o método que vamos precisar chamar para configurar 
         * quais requests vamos autorizar, e como vai ser essa autorização.
         * .antMatchers(). Nós vamos falar para ele qual url quero filtrar e o que é para fazer, 
         * se é para emitir ou bloquear.
         * deixar público o endpoint que lista todos os tópicos, ou seja, o "/topicos", 
         * e o que detalha um tópico em específico, o "/topicos/id". Os outros três, 
         * para cadastrar, alterar e excluir, quero restringir. Não é para ser público
         * pode liberar qualquer /topicos para qualquer método DELETE, POST , PUT mas isso
         * seria perigoso então especifica para qual método da rota será permitido o acesso no caso GET
         * .anyRequest().authenticated() na linha abaixo. Então, qualquer outra requisição 
         * tem que estar autenticado
         * .and().formLogin() o spring já tem um formulário e um controller padrão para receber 
         * solicitações de login
         */
    }

    // serve para fazermos configurações de recursos estáticos. 
    //São requisições para arquivo CSS, Javascript, imagens, etc. 
    //Não é nosso caso, já que estamos desenvolvendo só a parte do backend. 
    //O frontend fica na aplicação cliente. É separado. Mas se fosse uma aplicação em
    //que o frontend está integrado, iríamos ensinar para o Spring que as requisições 
    //devem ser ignoradas, que não é para interceptar na parte de segurança
    @Override
    public void configure(WebSecurity web) throws Exception {}
}
