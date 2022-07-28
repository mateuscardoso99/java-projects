package prova_poo_2018;

public class Main {
    public static void main(String[] args) {
        Conta c = new Conta(23391, "39443-2", 10000);
        Pessoa p = new Pessoa("joao", 30, c);

        p.setIdade(32);
        p.infoConta();

        p.getConta().deposito(5000);
        p.infoConta();

        p.getConta().saque(20000);
        p.infoConta();
        p.infoPessoa();
        
        System.out.println("rendimento após 6 meses: "+p.getConta().rendimento(6));
    }
}