package com.alura.forumspringapi.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.alura.forumspringapi.modelo.Curso;
import com.alura.forumspringapi.modelo.Topico;
import com.alura.forumspringapi.repository.CursoRepository;

import org.hibernate.validator.constraints.Length;


//definindo quais campos vão chegar na requisição
public class TopicoForm {

	@NotNull @NotEmpty @Length(min = 5)
    private String titulo;

	@NotNull @NotEmpty @Length(min = 10)
    private String mensagem;

	@NotNull @NotEmpty
    private String nomeCurso;//melhor passar apenas o nome do curso e buscar depois do que o objeto inteiro

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

    public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

    public Topico converter(CursoRepository cursoRepository){
        //tem que receber a classe do repository por parametro porque não da pra
        //injetar com Autowired em uma classe java comum pois não é componente spring
        
        Curso curso = cursoRepository.findByNome(nomeCurso);
        return new Topico(titulo, mensagem, curso);
    }
}
