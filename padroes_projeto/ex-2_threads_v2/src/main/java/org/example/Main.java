package org.example;

import org.example.banco.Banco;
import org.example.banco.conta.Conta;
import org.example.banco.conta.TipoConta;

/*
– Crie uma classe banco que armazene um conjunto de contas e forneça
métodos que permitam que sejam feitos criações de conta, exclusão
de contas, saques (uma conta corrente só pode fazer saques desde
que o valor não exceda o limite de saque -limite + saldo-), depósitos,
emissão de saldo e extrato e transferência entre contas.
– Uma conta possui um número, um saldo, um status que informa se ela
é especial ou não, um limite e um conjunto de movimentações.
Uma movimentação possui uma descrição, um valor e uma informação se
ela é uma movimentação de crédito, débito ou de rendimento
financeiro.
– Além disto as contas podem ser do tipo: Poupança, Conta-corrente,
Fundos de Renda Fixa ou Fundos de Renda Variável.
Dentre estes apenas os rendimentos de renda fixa e variável são tributados pelo IR,
nestes casos deverá existir um método que calcula o valor do imposto
devido com base no rendimento financeiro do mês e a alíquota de
27,5%
 */
public class Main {
    public static void main(String[] args) {
        Conta c1 = new Conta();
        c1.setSaldo(1000d);
        c1.setNumero(12345l);
        c1.setTipoConta(TipoConta.CONTA_CORRENTE);
        c1.setLimite(700d);
        
        Conta c2 = new Conta();
        c2.setSaldo(4000d);
        c2.setNumero(6789l);
        c2.setTipoConta(TipoConta.POUPANCA);
        c2.setLimite(1001d);
        
        Banco banco = new Banco();
        banco.criarConta(c1);
        banco.criarConta(c2);

        banco.transferir(12345l, 6789l, 90d);
        
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run(){
                System.out.println("T1-----");
                banco.extrato(12345l);
                banco.extrato(6789l);
        
                banco.transferir(12345l, 6789l, 90d);
                banco.transferir(12345l, 6789l, 350d);
        
                banco.extrato(12345l);
                banco.transferir(12345l, 6789l, 200d);
        
                banco.extrato(12345l);
                banco.extrato(6789l);
                System.out.println("T1 FIM--");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run(){
                System.out.println("T2-----");
                banco.extrato(12345l);
                banco.extrato(6789l);
        
                banco.transferir(12345l, 6789l, 190d);
        
                banco.transferir(12345l, 6789l, 200d);
                
                banco.extrato(12345l);
                banco.transferir(12345l, 6789l, 100d);
        
                banco.extrato(12345l);
                banco.extrato(6789l);
                System.out.println("T2 FIM---");
            }
        });
        t2.start();
        t1.start();
    }
}