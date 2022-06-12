package com.alura.forumspringapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

//nessa classe se habilita recursos que por padrão não vem habilitado

@SpringBootApplication
@EnableSpringDataWebSupport //habilita para pegar os dados do objeto de paginação recebido no método lista do topicoController e repassar pro jpa
@EnableCaching //habilitando cache, usar redis em produção ou outro gerenciador, No geral, utilizamos cache naquelas tabelas que nunca ou raramente são atualizadas
public class ForumSpringApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForumSpringApiApplication.class, args);
	}

}
