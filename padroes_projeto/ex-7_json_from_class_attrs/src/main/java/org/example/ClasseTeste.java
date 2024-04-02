package org.example;

public class ClasseTeste {
    private String nome;
    private Integer idade;
    private String endereco;
    private double idColuna;
    private Integer[] numeros;
    private List<Integer> numeros2;

    @JSON
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    @JSON
    public Integer getIdade() {
        return idade;
    }
    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    @JSON
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @JSON
    public double getIdColuna() {
        return idColuna;
    }
    public void setIdColuna(double idColuna) {
        this.idColuna = idColuna;
    }

    @JSON
    public Integer[] getNumeros() {
        return numeros;
    }
    public void setNumeros(Integer[] numeros) {
        this.numeros = numeros;
    }

    @JSON
    public List<Integer> getNumeros2() {
        return numeros2;
    }
    public void setNumeros2(List<Integer> numeros2) {
        this.numeros2 = numeros2;
    }
}
