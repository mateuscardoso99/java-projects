public class Conta {
    private String numero;
    private double saldo;

    public String getNumero(){
        return numero;
    }

    public void setNumero(String numero){
        this.numero = numero;
    }
    
    public double getSaldo(){
        return saldo;
    }

    public void setSaldo(double saldo){
        if(saldo < 0){
            System.out.println("saldo invalido");
        }
        else{
            this.saldo = saldo;
        }
    }

    public void depositar(double valor){
        saldo += valor;
    }

    public boolean sacar(double valor){
        if(saldo < valor){
            System.out.println("saldo insuficiente para realizar o saque");
            return false;
        }
        else{
            saldo -= valor;
            return true;
        }
    }

    //contadestino sera a referencia de memoria do objeto conta que foi passado
    //se passar c2, vai nesse objeto e deposita nele, se for c1 faz o mesmo nele
    public void transferePara(Conta contaDestino, double valor){
        if(this.sacar(valor)){
            contaDestino.depositar(valor);
        }
    }

    public void extrato(){
        System.out.println("numero: "+numero+", saldo: "+saldo);
    }
}
