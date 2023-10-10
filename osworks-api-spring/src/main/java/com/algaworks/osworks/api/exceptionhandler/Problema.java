package com.algaworks.osworks.api.exceptionhandler;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Problema {
//para a validação funcionar e preciso ter a dependencia jakarta bean validation, ou outra instalada
	private Integer status;
	private OffsetDateTime datahora;
	private String titulo;
	private List<Campo> campos;
	
	
	public static class Campo{
		private String nome;
		private String msg;
		
		
		public Campo(String nome, String msg) {
			super();
			this.nome = nome;
			this.msg = msg;
		}
		
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getMsg() {
			return msg;
		}
		public void setMsg(String msg) {
			this.msg = msg;
		}
		
		
	}
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public OffsetDateTime getDatahora() {
		return datahora;
	}
	public void setDatahora(OffsetDateTime datahora) {
		this.datahora = datahora;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public List<Campo> getCampos() {
		return campos;
	}
	public void setCampos(List<Campo> campos) {
		this.campos = campos;
	}
	
	
}
