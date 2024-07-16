package com.example;

public class Reembolso {
    private String descricao;
    private Double valor;
    
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }
    @Override
    public String toString() {
        return "Reembolso [descricao=" + descricao + ", valor=" + valor + "]";
    }
}
