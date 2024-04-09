package br.ufsm.csi.pp.aula2;

public class Gerente extends Funcionario {

    private String senha;
    private int numeroDeFuncionariosGerenciados;

    public Gerente(String nome, String cpf, float salario, String senha, int numeroDeFuncionariosGerenciados) {
        super(nome, cpf, salario);
        this.senha = senha;
        this.numeroDeFuncionariosGerenciados = numeroDeFuncionariosGerenciados;
    }

    @Override
    public float getBonificacao() {
        return super.getBonificacao() + 1000;
    }

    public static void main(String[] args) {
        Gerente gerente = new Gerente("fulano", "000.000.000-00", 10000f, "senha", 10);
        Funcionario funcionario = gerente;
        System.out.println("GERENTE: " + gerente.getBonificacao());
        System.out.println("FUNCIONARIO: " + funcionario.getBonificacao());
    }

}
