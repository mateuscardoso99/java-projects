package prova_poo_2018;

public class Conta {
    private int numero;
    private String agencia;
    private double saldo;

    public Conta(int numero, String ag, double saldo){
        this.agencia = ag;
        this.numero = numero;
        this.saldo = saldo;
    }

    public int getNumero(){
        return this.numero;
    }

    public void setNumero(int num){
        this.numero = num;
    }

    public String getAgencia(){
        return this.agencia;
    }

    public void setAgencia(String ag){
        this.agencia = ag;
    }

    public double getSaldo(){
        return this.saldo;
    }

    public void setSaldo(double s){
        this.saldo = s;
    }

    public void saque(double valor){
        if(valor > this.saldo){
            System.out.println("saldo insuficiente para saque.");
        }
        else{
            this.saldo-=valor;
        }
    }

    public void deposito(double valor){
        this.saldo+=valor;
    }

    public double rendimento(int meses){
        return this.saldo*0.05*meses;
    }
}
