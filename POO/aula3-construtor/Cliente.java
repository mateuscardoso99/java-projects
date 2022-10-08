package model;

public class Cliente {
    private String nome;
    private String endereco;

    public String getNome(){
        return this.nome;
    }

    public void setNome(String n){
        nome = n;
    }

    public String getEndereco(){
        return this.endereco;
    }

    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
}
