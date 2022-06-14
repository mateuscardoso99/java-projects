// package com.alura.forumspringapi.config.swagger;

// import java.util.Arrays;

// import com.alura.forumspringapi.modelo.Usuario;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// import springfox.documentation.builders.ParameterBuilder;
// import springfox.documentation.builders.PathSelectors;
// import springfox.documentation.builders.RequestHandlerSelectors;
// import springfox.documentation.schema.ModelRef;
// import springfox.documentation.spi.DocumentationType;
// import springfox.documentation.spring.web.plugins.Docket;

// @Configuration
// public class SweggerConfigurations {

//     @Bean
//     public Docket forumApi() {
//         return new Docket(DocumentationType.SWAGGER_2)
//             .select()
//             .apis(RequestHandlerSelectors.basePackage("com.alura.forumspringapi"))//path aonde o swager vai começar a ler pra gerar a documenteção
//             .paths(PathSelectors.ant("/**"))//pode restringir alguns endpoints para não gerar documentação deles se quiser
//             .build()
//             .ignoredParameterTypes(Usuario.class)//ignorar classe usuario para não mostrar parte da implementaao de senha
//             .globalOperationParameters(Arrays.asList(
//                 new ParameterBuilder()
//                 .name("Authorization")
//                 .description("Header para token JWT")
//                 .modelRef(new ModelRef("string"))
//                 .parameterType("header")
//                 .required(false)
//                 .build()));//habilitando espaço para adicionar token jwt na documentação do swagger
//     }
// }
