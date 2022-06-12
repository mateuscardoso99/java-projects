package com.alura.forumspringapi.controller.dto;

import java.time.LocalDateTime;

import com.alura.forumspringapi.modelo.Resposta;

public class RespostaDto {
    private Long id;
    private String mensagem;
    private LocalDateTime dataCriacao;
    private String nomeAutor;

    public RespostaDto(Resposta resposta) {
        this.id = resposta.getId();
        this.mensagem = resposta.getMensagem();
        this.dataCriacao = resposta.getDataCriacao();
        this.nomeAutor = resposta.getAutor().getNome();
    }
    //não precisa de setters pois no construtor já recebe todos os parametros
    public Long getId() {
		return id;
	}

    public String getMensagem() {
		return mensagem;
	}

    public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

    public String getAutor() {
		return nomeAutor;
	}
}
