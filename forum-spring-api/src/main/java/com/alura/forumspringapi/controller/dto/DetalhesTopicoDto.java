package com.alura.forumspringapi.controller.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.alura.forumspringapi.modelo.StatusTopico;
import com.alura.forumspringapi.modelo.Topico;

//com DTO ganhasse flexibilidade pois pode-se escolher quias atributos enviar na resposta JSON, 
//e não fica preso aos atributos do model Topico, podendo escolher o que retornar
//no topicoDto alguns campos são retornados enquanto aqui são outros dependendo da necessidade

public class DetalhesTopicoDto {
    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;
    private String nomeAutor;
    private StatusTopico status;
    private List<RespostaDto> respostas;

    public DetalhesTopicoDto(Topico topico){
        this.id = topico.getId();
        this.titulo = topico.getTitulo();
        this.mensagem = topico.getMensagem();
        this.dataCriacao = topico.getDataCriacao();
        this.nomeAutor = topico.getAutor().getNome();
        this.status = topico.getStatus();
        this.respostas = new ArrayList<>();
        this.respostas.addAll(topico.getRespostas().stream().map(RespostaDto::new).collect(Collectors.toList()));
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

    public String getAutor(){
        return nomeAutor;
    }

    public StatusTopico getStatus(){
        return status;
    }

    public List<RespostaDto> getRespostas(){
        return respostas;
    }
}
