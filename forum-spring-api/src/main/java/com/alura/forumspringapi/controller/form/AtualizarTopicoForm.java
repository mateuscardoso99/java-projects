package com.alura.forumspringapi.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.alura.forumspringapi.modelo.Topico;
import com.alura.forumspringapi.repository.TopicoRepository;

import org.hibernate.validator.constraints.Length;

public class AtualizarTopicoForm {
    @NotNull @NotEmpty @Length(min = 5)
    private String titulo;

    @NotNull @NotEmpty @Length(min = 10)
    private String mensagem;

    public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

    public Topico atualizar(Long id, TopicoRepository topicoRepository){
        //tem que receber a classe do repository por parametro porque não da pra
        //injetar com Autowired em uma classe java comum pois não é componente spring
        Topico topico = topicoRepository.getReferenceById(id);
        topico.setTitulo(this.titulo);
        topico.setMensagem(this.mensagem);
        return topico;
    }
}
