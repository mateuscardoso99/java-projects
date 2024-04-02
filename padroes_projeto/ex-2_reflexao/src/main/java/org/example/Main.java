package org.example;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.stream.Stream;

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
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException{
        Conta c1 = new Conta();
        c1.setSaldo(1000d);
        c1.setNumero(12345l);
        c1.setTipoConta(TipoConta.CONTA_CORRENTE);
        c1.setLimite(300d);

        Conta c2 = new Conta();
        c2.setSaldo(4000d);
        c2.setNumero(6789l);
        c2.setTipoConta(TipoConta.POUPANCA);
        c2.setLimite(1001d);

        Banco banco = new Banco();
        
        Class<?> classe = banco.getClass();
        System.out.println("Classe: "+classe.getName());

        System.out.println("ATRIBUTOS CLASSE BANCO\n");

        for(Field f : banco.getClass().getFields()){
            System.out.println(f.getName());//atributos privados não são acessíveis
        }

        System.out.println("MÉTODOS CLASSE BANCO\n");
        for(Method m : classe.getMethods()){
            System.out.println(m.getName());
        }

        Method metodoCriarConta = classe.getDeclaredMethod("criarConta", Conta.class);
        //System.out.println(metodoCriarConta.getName());
        metodoCriarConta.invoke(banco, c1);

        Method metodoGetContas = classe.getDeclaredMethod("getContas");

        Collection<Conta> e = (Collection<Conta>) metodoGetContas.invoke(banco);

        System.out.println("\nMÉTODOS DAS CONTAS DO BANCO");
        System.out.println("TOTAL DE CONTAS NO BANCO: " + e.getClass().getMethod("size").invoke(e));

        Stream<Conta> s = (Stream<Conta>) e.getClass().getMethod("stream").invoke(e);

        s.forEach(c -> System.out.println("NUMERO DAS CONTAS: "+c.getNumero()));
    }
}