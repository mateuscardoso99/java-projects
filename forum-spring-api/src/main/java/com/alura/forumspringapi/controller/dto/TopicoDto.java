package com.alura.forumspringapi.controller.dto;

import java.time.LocalDateTime;
import com.alura.forumspringapi.modelo.Topico;

import org.springframework.data.domain.Page;

//com DTO ganhasse flexibilidade pois pode-se escolher quias atributos enviar na resposta JSON, 
//e não fica preso aos atributos do model Topico, podendo escolher o que retornar

public class TopicoDto {
    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;

    public TopicoDto(Topico topico){
        this.id = topico.getId();
        this.titulo = topico.getTitulo();
        this.mensagem = topico.getMensagem();
        this.dataCriacao = topico.getDataCriacao();
    }

    public Long getId(){
        return id;
    }

    public String getTitulo(){
        return titulo;
    }

    public String getMensagem(){
        return mensagem;
    }

    public LocalDateTime getDataCriacao(){
        return dataCriacao;
    }

    public static Page<TopicoDto> converter(Page<Topico> topicos){
        return topicos.map(TopicoDto::new);//transforma cada topicos do tipo Page em um objeto TopicoDto
    }
    //return topicos.stream().map(TopicoDto::new).collect(Collectors.toList());
    //stream(): itera sobre uma coleção de objetos e, a cada elemento, realizar alguma ação, seja ela de filtragem, mapeamento, transformação
}
