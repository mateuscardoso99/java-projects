package org.example;

public class Produto implements Order{
    private String nome;
    private Double preco;

    public Produto(String nome, Double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public Double calcularPreco() {
        return this.preco;
    }
}
