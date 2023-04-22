package br.ufsm.poli.csi.so.threads;

import java.util.*;

public class ProdutoresConsumidoresMonitor {
    private static final int capacidade = 100;
    private List<Integer> buffer = new ArrayList<>();

    public static void main(String[] args) {
        new ProdutoresConsumidoresSemaforo();
    }

    public ProdutoresConsumidoresMonitor(){
        new Thread(new Produtor()).start();
        new Thread(new Consumidor()).start();
    }

    public class Produtor implements Runnable{
        private Random rnd = new Random(System.currentTimeMillis());

        @Override
        public void run() {
            while (true){
                synchronized (ProdutoresConsumidoresMonitor.class){//mesmo objeto dentro do syncronized
                    Integer inteiroProduzido = produzDados();
                    if(buffer.size() == capacidade) {
                        try {
                            wait();
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                    buffer.add(inteiroProduzido);
                    System.out.println("Produtor: produziu "+inteiroProduzido);
                    notify();
                }
            }
        }

        private Integer produzDados(){
            return rnd.nextInt();
        }
    }

    public class Consumidor implements Runnable{
        @Override
        public void run() {
            while (true){
                synchronized (ProdutoresConsumidoresMonitor.class) {
                    if (buffer.size() == 0) {
                        try{
                            wait();
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                    Integer inteiroConsumido = buffer.remove(0);
                    System.out.println("Consumidor: consumiu " + inteiroConsumido);
                    notify();
                }
            }
        }
    }
}
