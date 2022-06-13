package com.alura.forumspringapi.config.security;

import com.alura.forumspringapi.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity //habilita modulo de segurança
@Configuration //quando o spring iniciar vai ler o que está nessa classe por causa dessa anotação
public class SecurityConfigurations extends WebSecurityConfigurerAdapter{
    
    @Autowired
    private AutenticacaoService autenticacaoService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;


    /**
     * A classe AuthenticationManager deve ser utilizada apenas na lógica de autenticação 
     * via username/password, para a geração do token.
     * precisa do override aqui para usar no autenticacao controller
     */

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception{
        return super.authenticationManager();
    }
     
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
        .antMatchers(HttpMethod.POST,"/auth").permitAll()
        .anyRequest().authenticated()
        //.and().formLogin() //como é uma api não terá sessão e esse metodo cria uma sessão, um form de login e um controller prontos, então será preciso criar um controller de autenticação
        .and().csrf().disable() //por ser uma api ela não é vulneravel a ataques csrf, por é desativado para não verificar o cookie csrf também
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) //autenticação será por token e não stateless então o servidor não vai guardar na sua memoria os dados da sessão do usuario
        .and().addFilterBefore(new AutenticacaoTokenFilter(tokenService, usuarioRepository), UsernamePasswordAuthenticationFilter.class);
        //dizendo qual é a classe de filtro e o tipo do token

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
