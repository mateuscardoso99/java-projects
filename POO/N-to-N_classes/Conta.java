package model;

public class Conta {
    private String numero;
    private double saldo;

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
}
