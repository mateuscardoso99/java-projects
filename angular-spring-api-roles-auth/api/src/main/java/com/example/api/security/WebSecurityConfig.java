// WebSecurityConfigurerAdapter é o cerne da nossa implementação de segurança. 
// Ele fornece configurações HttpSecurity para configurar cors, csrf, gerenciamento de sessão, 
// regras para recursos protegidos. Também podemos estender e personalizar a configuração padrão que 
// contém os elementos abaixo. 

//– A interface UserDetailsService tem um método para carregar User por nome de usuário e 
// retorna um objeto UserDetails que o Spring Security pode usar para autenticação e 
// validação. 

//– UserDetails contém as informações necessárias (como: nome de usuário, senha, autoridades) 
// para construir um objeto Autenticação. 

//– UsernamePasswordAuthenticationToken obtém {username, password} 
// da solicitação de login, o AuthenticationManager o usará para autenticar uma conta de login. 

// – AuthenticationManager tem um DaoAuthenticationProvider (com ajuda de UserDetailsService & 
// PasswordEncoder) para validar o objeto UsernamePasswordAuthenticationToken. Se for bem-sucedido, 
// AuthenticationManager retornará um objeto Authentication totalmente preenchido 
// (incluindo autoridades concedidas). 

//– OncePerRequestFilter faz uma única execução para cada solicitação 
// à nossa API. Ele fornece um método doFilterInternal() que implementaremos analisando e validando JWT, 
// carregando detalhes do usuário (usando UserDetailsService), verificando a 
// autorização (usando UsernamePasswordAuthenticationToken).

//– AuthenticationEntryPoint detectará erro 
// de autenticação. O repositório contém UserRepository e RoleRepository para trabalhar com o 
// banco de dados, será importado para o Controller. O controlador recebe e manipula a solicitação 
// depois que ela foi filtrada por OncePerRequestFilter. 

//– AuthController lida com solicitações de signup/login 

//– TestController tem acesso a métodos de recursos protegidos com validações baseadas 
// em função. Entenda a arquitetura profundamente e compreenda a visão geral com mais facilidade: 
// Spring Boot Architecture para JWT com Spring Security



///////////////////////////////


// @EnableWebSecurity permite que o Spring encontre e aplique automaticamente a classe ao Web 
//Security global. 

// – @EnableGlobalMethodSecurity fornece segurança AOP em métodos. Ele habilita @PreAuthorize, 
//@PostAuthorize, também suporta JSR-250. Você pode encontrar mais parâmetros na configuração
// em Method Security Expressions.

// – Substituímos o método configure(HttpSecurity http) da interface WebSecurityConfigurerAdapter. 
// Ele informa ao Spring Security como configuramos CORS e CSRF, quando queremos exigir
// que todos os usuários sejam autenticados ou não, qual filtro (AuthTokenFilter) e quando
// queremos que funcione (filtro antes de UsernamePasswordAuthenticationFilter), 
// qual Exception Handler é escolhido (AuthEntryPointJwt). 

// – O Spring Security carregará os detalhes do usuário para realizar autenticação e autorização. 
// Portanto, tem a interface UserDetailsService que precisamos implementar. 

// – A implementação de UserDetailsService será usada para configurar DaoAuthenticationProvider pelo 
// método AuthenticationManagerBuilder.userDetailsService(). 

// – Também precisamos de um PasswordEncoder para o DaoAuthenticationProvider. Se não especificarmos, 
// ele usará texto simples.


package com.example.api.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.example.api.security.jwt.AuthEntryPointJwt;
import com.example.api.security.jwt.AuthTokenFilter;
import com.example.api.security.services.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
    // securedEnabled = true,
    // jsr250Enabled = true,
    prePostEnabled = true)

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    private AuthEntryPointJwt unauthorizedHandler;

    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter() {
        return new AuthTokenFilter();
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
        .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
        .authorizeRequests().antMatchers("/api/auth/**").permitAll()
        .antMatchers("/api/test/**").permitAll()
        .anyRequest().authenticated();
        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}