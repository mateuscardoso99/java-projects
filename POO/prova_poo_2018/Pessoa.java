package prova_poo_2018;

public class Pessoa {
    private String nome;
    private int idade;
    private Conta conta;

    public Pessoa(String nome, int idade, Conta conta){
        this.nome = nome;
        this.idade = idade;
        this.conta = conta;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public int getIdade(){
        return this.idade;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }

    public Conta getConta(){
        return this.conta;
    }

    public void setConta(Conta c){
        this.conta = c;
    }

    public void infoPessoa(){
        System.out.println("nome: "+this.getNome());
        System.out.println("idade: "+this.getIdade());
    }

    public void infoConta(){
        System.out.println("numero: "+this.getConta().getNumero());
        System.out.println("agencia: "+this.getConta().getAgencia());
        System.out.println("saldo: "+this.getConta().getSaldo());
    }
}
