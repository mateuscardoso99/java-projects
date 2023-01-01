/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.springmvc.config;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 *
 * @author mateus
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig{
    
    @Bean
    public UserDetailsService getUserDetailsService() {
        return new UserDetailsServiceImpl();
    }

    @Bean
    public BCryptPasswordEncoder getPasswordEncoder() {
	return new BCryptPasswordEncoder();
    }
    
    @Bean
    public DaoAuthenticationProvider getDaoAuthProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
	daoAuthenticationProvider.setUserDetailsService(getUserDetailsService());
	daoAuthenticationProvider.setPasswordEncoder(getPasswordEncoder());

	return daoAuthenticationProvider;
    }

        
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        /*
        http.authorizeRequests()
            .antMatchers("/products/**")
            .permitAll()
            .and()
            .authorizeRequests()
            .antMatchers("/customers/**")
            .hasRole("ADMIN")
            .anyRequest()
            .authenticated()

            authorizeRequests():  Este método diz ao Spring para usar as seguintes regras ao autorizar requisições.
            antMatchers(“/products/**”):  Especifica os padrões de URL aos quais a configuração de segurança se aplica. 
            Estamos encadeando-o com uma ação permitAll(). Se uma requisição contiver “ /products” em seu caminho, 
            ela poderá ir para o controlador sem precisar de autenticacao.
            Podemos adicionar mais regras à nossa configuração usando o método and()

            Para iniciar uma nova regra, podemos novamente usar o método authorizeRequests().
            antMatchers(“/customers/**”).hasRole(“ADMIN”):  Se a URL contiver “ /customers”  no caminho,
            verificamos se o usuário que fez a requisição possui a função ADMIN.
            Se o usuário não estiver autenticado, isso levará a um erro “401 Unauthorized”.
            Se o usuário não tiver a função correta, isso levará a um erro “403 Proibido”
            anyRequest() define uma cadeia de regras para qualquer solicitação que não corresponda às regras anteriores.
            No nosso caso, tais solicitações serão repassadas desde que sejam autenticadas.

            outro exemplo: .antMatchers("/**").permitAll() qualquer url nao precisa estar autenticado
        */
       
        http.authorizeHttpRequests((req) -> req
            .requestMatchers("/admin/**").hasRole("ADMIN")
            .requestMatchers("/user/**").hasRole("USER")
        )
        .authorizeHttpRequests((req) -> {
            try {
                req.requestMatchers("/h2-console/**").permitAll().and().csrf().disable();
            } catch (Exception ex) {
                Logger.getLogger(SecurityConfig.class.getName()).log(Level.SEVERE, null, ex);
            }
        })
        .authorizeHttpRequests().anyRequest().permitAll()
        .and().headers().frameOptions().sameOrigin().disable()
        .formLogin((form) -> {
            try {
                form.loginPage("/signin")
                    .loginProcessingUrl("/login")
                    .defaultSuccessUrl("/user/")
                    .permitAll()
                    .failureUrl("/signin?error")
                    .and().csrf().disable();
                
                //LOGIN E FEITO AUTOMATICAMENTE APENAS COM ESSAS CONFIGURACOES, NAO PRECISA CRIAR FUNCAO, ENDPOINT ETC..
            } catch (Exception ex) {
                Logger.getLogger(SecurityConfig.class.getName()).log(Level.SEVERE, null, ex);
            }
        })
        .logout().logoutSuccessUrl("/signin?logout");
        
        return http.build();
    }
    
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring()
                .requestMatchers("/css/**",
                        "/js/**",
                        "/img/**",
                        "/lib/**",
                        "/favicon.ico"
                );
    }
}
