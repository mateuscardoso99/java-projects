package br.ufsm.csi.pp.aula2;

public class Funcionario {

    private String nome;
    private String cpf;
    private float salario;

    public Funcionario(String nome, String cpf, float salario) {
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
    }

    public float getBonificacao() {
        return this.salario * 0.1f;
    }

}
