public class Conta{
    public int numero;
    public double saldo;
    public Cliente titular;
    public Data dataAbertura = new Data();

    public boolean sacar(double valor){
        if(saldo < valor){
            return false;
        }
        else{
            saldo -= valor;
            return true;
        }
    }

    public void depositar(double valor){
        saldo += valor;
    }

    public boolean transferePara(Conta destino, double valor) {
        boolean	retirou	= this.sacar(valor);
        if(retirou == false){
            return false;
        }
        else{
            destino.depositar(valor);
            return true;
        }
    }

    public double calcularRendimento(){
        return this.saldo * 0.1;
    }

    public String recuperaDadosImpressao(){
        String dados = "\nTitular: "+this.titular.nome
                +"\nCPF: "+this.titular.cpf
                +"\nNumero: "+this.numero
                +"\nSaldo: "+this.saldo
                +"\nData Abertura: "+this.dataAbertura.formatada();
        return dados;
    }
}