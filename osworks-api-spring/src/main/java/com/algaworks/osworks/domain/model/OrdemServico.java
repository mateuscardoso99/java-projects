package com.algaworks.osworks.domain.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.algaworks.osworks.api.model.Comentario;
import com.algaworks.osworks.domain.exception.NegocioException;
//import com.algaworks.osworks.domain.ValidationGroups;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
//import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;
import com.sun.istack.NotNull;

@Entity
public class OrdemServico {

	//@Valid
	//@ConvertGroup(from = Default.class, to = ValidationGroups.ClienteId.class)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@ManyToOne //relacionado N pra 1
	private Cliente cliente;
	
	//@NotBlank
	private String descricao;
	
	@NotNull
	private BigDecimal preco;
	
	@JsonProperty(access = Access.READ_ONLY)//read only faz com que não seja possível enviar o dado
	@Enumerated(EnumType.STRING)
	private StatusOrdemServico status;
	
	@JsonProperty(access = Access.READ_ONLY)
	private OffsetDateTime dataAbertura;
	
	@JsonProperty(access = Access.READ_ONLY)
	private OffsetDateTime dataFinalizacao;
	
	@OneToMany(mappedBy = "ordemServico")//relacionamento 1 pra N
	private List<Comentario> comentarios = new ArrayList<>();
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
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
	public StatusOrdemServico getStatus() {
		return status;
	}
	public void setStatus(StatusOrdemServico status) {
		this.status = status;
	}
	public OffsetDateTime getDataAbertura() {
		return dataAbertura;
	}
	public void setDataAbertura(OffsetDateTime dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	public OffsetDateTime getDataFinalizacao() {
		return dataFinalizacao;
	}
	public void setDataFinalizacao(OffsetDateTime dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}
	
	public List<Comentario> getComentarios() {
		return comentarios;
	}
	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrdemServico other = (OrdemServico) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	public boolean podeSerFinalizada() {
		return StatusOrdemServico.ABERTA.equals(getStatus());
	}
	
	public boolean naoPodeSerFinalizada() {
		return !podeSerFinalizada();
	}
	
	public void finalizar() {
		if(naoPodeSerFinalizada()) {
			throw new NegocioException("ordem de serviço não pode ser finalizada");
		}
		
		setStatus(StatusOrdemServico.FINALIZADA);
		setDataFinalizacao(OffsetDateTime.now());
	}
	
	
	
}
