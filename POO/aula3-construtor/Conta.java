package model;

public class Conta {
    private String numero;
    private double saldo;
    private Cliente cliente;

    //impedindo de criar uma conta sem numero
    //ao criar um construtor, ele sobrescreve "anula" o construtor padrao criado pelo java
    public Conta(String numero){
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getSaldo(){
        return saldo;
    }

    public void setSaldo(double saldo){
        if(saldo < 0){
            System.out.println("valor invalido para saldo");
        }
        else {
            this.saldo = saldo;
        }
    }

    public Cliente getCliente(){
        return this.cliente;
    }

    public void setCliente(Cliente c){
        this.cliente = c;
    }
}
