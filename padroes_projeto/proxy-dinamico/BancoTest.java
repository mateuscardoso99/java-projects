package br.ufsm.csi.pp.exercicio2;

import java.lang.reflect.Field;

public class BancoTest {

    public static void main(String[] args) {
        //new BancoTest().tests();
    }

    private Banco banco;


    private class TestConcorrencia implements Runnable {

        private int numero;
        private TestConcorrencia(int numero) {
            this.numero = numero;
        }

        @Override
        public void run() {
            long milis = System.currentTimeMillis();
            for (int i = 0; i < 1000000; i++) {
                banco.criaConta(Banco.TipoConta.CC, 100.0, false, 200.0);
            }
            milis = System.currentTimeMillis() - milis;
            System.out.println("[Thread " + this.numero + "] Tempo gasto criacao: " + milis + "ms.");
            milis = System.currentTimeMillis();
            for (String codigo : banco.getContas().keySet()) {
                ContaBancaria contaBancaria = banco.getContas().get(codigo);
            }
            milis = System.currentTimeMillis() - milis;
            System.out.println("[Thread " + this.numero + "] Tempo gasto busca: " + milis + "ms.");
        }
    }

    public void test1() {
        for (int i = 1; i <= 10; i++) {
            new Thread(new TestConcorrencia(i)).start();
        }
    }


}
