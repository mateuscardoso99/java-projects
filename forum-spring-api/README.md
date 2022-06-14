# projeto possui
- auth jwt
- crud com relacionamentos
- recurso de cache
- paginação
- monitoramento com spring boot actuator e spring boot admin

## documentação com API swagger
- Para documentar a nossa API Rest, podemos utilizar o Swagger, com o módulo SpringFox Swagger;
- Para utilizar o SpringFox Swagger na API, devemos adicionar suas dependências no arquivo pom.xml;
- Para habilitar o Swagger na API, devemos adicionar a anotação @EnableSwagger2 na classe ForumApplication;
- As configurações do Swagger devem ser feitas criando-se uma classe chamada SwaggerConfigurations e adicionando nela a anotação @Configuration;
- Para configurar quais endpoints e pacotes da API o Swagger deve gerar a documentação, devemos criar um método anotado com @Bean, que devolve um objeto do tipo Docket;
- Para acessar a documentação da API, devemos entrar no endereço http://localhost:8080/swagger-ui.html;
- Para liberar acesso ao Swagger no Spring Security, devemos chamar o seguinte método web.ignoring().antMatchers("/**.html", "/v2/api-docs", "/webjars/**", "/configuration/**", "/swagger-resources/**"), dentro do método void configure(WebSecurity web), que está na classe SecurityConfigurations.

# adicionar no pom.xml libs springfox (para gerar documentação e as telas):
    <dependency>
        <groupId>io.springfox</groupId>
        <artifactId>springfox-swagger-ui</artifactId>
        <version>2.9.2</version>
    </dependency>

    <dependency>
        <groupId>io.springfox</groupId>
        <artifactId>springfox-swagger-ui</artifactId>
        <version>2.9.2</version>
    </dependency>

# adicionar no arquivo ForumSpringApiAplication para habilitar o swagger:
- @EnableSwagger2

# criar classe de configuração

# ao rodar o projeto é gerado um html em localhost:8080/swagger-ui.html com a documentação