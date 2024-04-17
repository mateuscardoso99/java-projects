package org.example;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import org.example.banco.Banco;
import org.example.banco.conta.Conta;
import org.example.banco.conta.ContaPoupanca;

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




/**
 * SINGLETON:
 * Às vezes, pode haver a necessidade de ter uma e somente uma instância de uma determinada classe durante o
 * tempo de vida de uma aplicação. – Por exemplo, podemos precisar de um único objeto de
 * conexão de banco de dados. – O padrão Singleton é útil em tais casos porque garante que existe uma e apenas uma instância de um objeto
 * particular. – Além disso, sugere que os objetos de cliente devem ser
 * capazes de acessar a única instância de forma consistente
 */

/*
 * FACTORY METHOD: 
 * Objetivo: Encapsular a escolha da classe concreta a ser utilizada na criação de objetos de um determinado tipo. 
 * Às vezes, um objeto só pode saber que ele precisa acessar uma classe de dentro de uma hierarquia de classe, mas não sabe exatamente qual classe entre o conjunto 
 * de subclasses da classe pai deve ser selecionada. 
 * A escolha de uma classe apropriada pode depender de fatores como:
 * - O estado da aplicação em execução;
 * - Configurações do aplicativo;
 * - Expansão de requisitos ou melhorias;
 */

/*
 * OBJECT POOL:
 * O objetivo é possibilitar o reaproveitamento de objetos
 * Imagine que podemos ter um custo alto para criação e/ou destruição de objetos
 * Desta forma implementar este padrão pode ser útil para organizar como os usuários compartilham instâncias 
 * É necessário considerar concorrência
 * Ex. de uso: pool de conexões com o banco de dados, pool de threads para processar requisições
 */



/*
 * Implemente a instanciação do Banco e Contas Bancárias através de FactoryMethod.
 * Implemente um Singleton (qualquer classe).
 * Implemente um Pool Genérico (classe concreta) de objetos a partir da interface:
    public interface Pool<T> {
        T acquire();
        void release(T t);
    }
    O pool deverá manter no mínimo 3 instâncias criadas e deverá
    instanciar no máximo 20. Caso algum cliente tente fazer acquire e o
    máximo já tenha sido atingido, deverá esperar até que algum outro
    cliente devolva outro objeto (problema dos produtores vs. Consumidores).
 */
public class Main {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        Banco banco = Banco.getInstance();

        //usando padrão de projeto factoryMethod
        //Conta c1 = banco.factoryMethod(1l, 1000d, false, 300d, TipoConta.CONTA_CORRENTE);
        //Conta c2 = banco.factoryMethod(2l, 300d, true, 1001d, TipoConta.POUPANCA);

        //banco.getContas().add(c1);
        //banco.getContas().add(c2);

        /*banco.extrato(1l);
        banco.extrato(2l);

        banco.transferir(1l, 56756l, 90d);

        banco.transferir(2l, 6789l, 350d);

        banco.extrato(12345l);
        banco.transferir(12345l, 6789l, 200d);

        banco.extrato(12345l);
        banco.extrato(6789l);*/

        //Pool Genérico: padrão de projeto: objectPool
        PoolGenerico<ContaPoupanca> poolGenerico = new PoolGenerico<>(ContaPoupanca.class);

        for(int i=0; i<30; i++){
            System.out.println("thread " + i + " iniciando");

            Thread t = new Thread(new Runnable() {

                @Override
                public void run() {
                    ContaPoupanca c = poolGenerico.acquire();

                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    poolGenerico.release(c);
                }
                
            });

            t.start();
        }

        /*Thread t20 = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("thread 20 iniciando");

                ContaPoupanca c = poolGenerico.acquire();

                System.out.println("thread 20 conseguiu um objeto do pool");

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                poolGenerico.release(c);
                System.out.println("thread 20 liberou objeto do pool");
            }
            
        });

        

        Thread t21 = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("thread 21 iniciando");

                ContaPoupanca c = poolGenerico.acquire();

                System.out.println("thread 21 conseguiu um objeto do pool");
            }
            
        });

        t20.start();
        t21.start();*/
    }
}