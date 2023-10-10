package com.algaworks.osworks.api.model;

import java.math.BigDecimal;

import com.sun.istack.NotNull;

public class OrdemServicoEntrada {

	//@NotBlank
	private String descricao;
	
	@NotNull
	private BigDecimal preco;
	
	@NotNull
	private ClienteIdEntrada cliente;
	
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	public ClienteIdEntrada getCliente() {
		return cliente;
	}
	public void setCliente(ClienteIdEntrada cliente) {
		this.cliente = cliente;
	}
	
	
}
