import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
    //scanner global pra todos os metodos
    private static Scanner sc = new Scanner(System.in);

    //como metodo main eh static este tambem precisa ser
    //metodos static so acessam outros metodos e atributos static
    private static Conta escolher(Conta contaTransacao, List<Conta> contas, String op){
        int existe = 0;

        System.out.print("numero da conta para "+op+": ");
        String numeroConta = sc.next();

        for(Conta c : contas){
            if(c.getNumero().equals(numeroConta)){
                existe = 1;

                contaTransacao.setNumero(c.getNumero());
                contaTransacao.setSaldo(c.getSaldo());
            }
        }

        while(existe != 1){
            System.out.print("conta nao existe. numero da conta para "+op+": ");
            numeroConta = sc.next();

            for(Conta c: contas){
                if(c.getNumero().equals(numeroConta)){
                    existe = 1;

                    contaTransacao.setNumero(c.getNumero());
                    contaTransacao.setSaldo(c.getSaldo());
                }
            }
        }

        return contaTransacao;
    }

    public static void main(String[] args) {
        Conta c1 = new Conta();
        c1.setNumero("4645-63");
        c1.setSaldo(1000);

        Conta c2 = new Conta();
        c2.setNumero("4546-75");
        c2.setSaldo(500);

        System.out.print("conta 1: ");
        c1.extrato();

        System.out.print("conta 2: ");
        c2.extrato();

        c1.depositar(2000);
        System.out.print("conta 1: ");
        c1.extrato();

        c1.sacar(200);
        System.out.print("conta 1: ");
        c1.extrato();

        c1.transferePara(c2, 400);
        c1.transferePara(c2, 200000);

        System.out.print("conta 1: ");
        c1.extrato();

        System.out.print("conta 2: ");
        c2.extrato();

        int continuar = 1;

        List<Conta> contas = new ArrayList<>();
        contas.add(c1);
        contas.add(c2);

        Conta contaOrigem = new Conta();
        Conta contaDestino = new Conta();

        while(continuar != 0){
            System.out.print("valor da transferencia: ");
            double valor = sc.nextDouble();

            /*int existe = 0;

            System.out.print("valor da transferencia: ");
            double valor = sc.nextDouble();

            System.out.print("numero da conta para saque: ");
            String numeroSaque = sc.next();

            for(Conta c : contas){
                if(c.getNumero().equals(numeroSaque)){
                    existe = 1;

                    contaOrigem.setNumero(c.getNumero());
                    contaOrigem.setSaldo(c.getSaldo());
                }
            }

            while(existe != 1){
                System.out.print("conta nao existe. numero da conta para saque: ");
                numeroSaque = sc.next();

                for(Conta c: contas){
                    if(c.getNumero().equals(numeroSaque)){
                        existe = 1;

                        contaOrigem.setNumero(c.getNumero());
                        contaOrigem.setSaldo(c.getSaldo());
                    }
                }
            }

            existe = 0;

            System.out.print("numero da conta para deposito: ");
            String numeroDeposito = sc.next();

            for(Conta c : contas){
                if(c.getNumero().equals(numeroDeposito)){
                    existe = 1;

                    contaDestino.setNumero(c.getNumero());
                    contaDestino.setSaldo(c.getSaldo());
                }
            }

            while(existe != 1){
                System.out.print("conta nao existe. numero da conta para deposito: ");
                numeroDeposito = sc.next();

                for(Conta c: contas){
                    if(c.getNumero().equals(numeroDeposito)){
                        existe = 1;

                        contaDestino.setNumero(c.getNumero());
                        contaDestino.setSaldo(c.getSaldo());
                    }
                }
            }*/

            //passagem de parametro de objeto eh sempre por refencia
            escolher(contaOrigem, contas, "saque");
            escolher(contaDestino, contas, "deposito");

            contaOrigem.transferePara(contaDestino, valor);
            contaOrigem.extrato();
            contaDestino.extrato();

            System.out.println("0 pra encerrar");
            continuar = sc.nextInt();
        }

        sc.close();        
    }
}
