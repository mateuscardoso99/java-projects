package estrutura1;
import java.util.Scanner;

public class Conta {

    public static double saldo;

    //dentro de metodos estaticos so propriedades estaticas podem ser acessadas
    public static double depositar(double valor){
        Conta.saldo += valor;
        return Conta.saldo;
    }

    public static double sacar(double valor){
        Conta.saldo -= valor;
        return Conta.saldo;
    }

    public static void main(String[] args){
        /*
        * – Crie uma conta.
        * – Inicie o saldo da conta com 100.
        * – Faça um saque de 60.
        * – Faça um depósito de 20.
        * – Faça um saque de 80.
        * – Faça um saque de 30.
        * – Faça um depósito de 30.
        * – Faça um saque de 70.
        * – Mostre o saldo da conta.
        */

        //double saldo = 100;
        Conta.saldo = 100;

        Scanner sc = new Scanner(System.in);

        double saque, deposito;

        //saque
        System.out.print("saque: ");
        saque = Double.parseDouble(sc.nextLine());

        while(saque > Conta.saldo){
            System.out.print("saldo insuficiente, saque: ");
            saque = Double.parseDouble(sc.nextLine());
        }

        Conta.sacar(saque);


        //deposito
        System.out.print("depósito: ");
        deposito = sc.nextDouble();
        Conta.depositar(deposito);


        //saque
        System.out.print("saque: ");
        saque = sc.nextDouble();

        while(saque > Conta.saldo){
            System.out.print("saldo insuficiente, saque: ");
            saque = sc.nextDouble();
        }

        Conta.sacar(saque);


        //saque
        System.out.print("saque: ");
        saque = sc.nextDouble();

        while(saque > Conta.saldo){
            System.out.print("saldo insuficiente, saque: ");
            saque = sc.nextDouble();
        }

        Conta.sacar(saque);


        //deposito
        System.out.print("depósito: ");
        deposito = sc.nextDouble();
        Conta.depositar(deposito);


        //saque
        System.out.print("46747 saque: ");
        saque = sc.nextDouble();

        while(saque > Conta.saldo){
            System.out.print("saldo insuficiente, saque: ");
            saque = sc.nextDouble();
        }

        Conta.sacar(saque);
        sc.close();

        System.out.printf("saldo: %.2f",Conta.saldo);

    }
}
