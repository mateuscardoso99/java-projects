package org.example.classes;

import java.util.Set;
import java.util.stream.Collectors;

import org.example.classes.Pecas.Peca;

public class Imovel {
    private String identificacao;
    private Double areaTotal;
    private String proprietario;
    private String endereco;
    private Set<Peca> pecas;
    private TipoUso tipoUso;

    public Imovel(String identificacao, String proprietario, String endereco, Set<Peca> pecas, TipoUso tipoUso) {
        this.identificacao = identificacao;
        this.proprietario = proprietario;
        this.endereco = endereco;
        this.pecas = pecas;
        this.tipoUso = tipoUso;
        this.calculaAreaTotal();
    }

    private void calculaAreaTotal(){
        this.areaTotal = this.pecas.stream().collect(Collectors.summingDouble(Peca::getArea));
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public Double getAreaTotal() {
        return areaTotal;
    }

    public void setAreaTotal(Double areaTotal) {
        this.areaTotal = areaTotal;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Set<Peca> getPecas() {
        return pecas;
    }

    public void setPecas(Set<Peca> pecas) {
        this.pecas = pecas;
    }

    public TipoUso getTipoUso() {
        return tipoUso;
    }

    public void setTipoUso(TipoUso tipoUso) {
        this.tipoUso = tipoUso;
    }

    
}
