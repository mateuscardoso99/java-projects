package br.ufsm.poli.csi.so.threads;

import java.util.*;
import java.util.concurrent.Semaphore;

public class ProdutoresConsumidoresSemaforo {
    private static final int capacidade = 100;
    private List<Integer> buffer = new ArrayList<>();

    private Semaphore mutex = new Semaphore(1);
    private Semaphore vazio = new Semaphore(capacidade);
    private Semaphore cheio = new Semaphore(0);

    public static void main(String[] args) {
        new ProdutoresConsumidoresSemaforo();
    }

    public ProdutoresConsumidoresSemaforo(){
        new Thread(new Produtor()).start();
        new Thread(new Consumidor()).start();
    }

    public class Produtor implements Runnable{
        private Random rnd = new Random(System.currentTimeMillis());

        @Override
        public void run() {
            while (true){

                Integer inteiroProduzido = produzDados();

                try {
                    vazio.acquire(); //down
                    mutex.acquire(); //down
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

                //if(buffer.size() < capacidade){
                    buffer.add(inteiroProduzido);
                    System.out.println("Produtor: produziu "+inteiroProduzido);
               // }

                mutex.release(); //up
                cheio.release(); //up
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
//                if (buffer.size() > 0){
//                    Integer inteiroConsumido = buffer.remove(0);
//                    System.out.println("Consumidor: consumiu "+inteiroConsumido);
//                }
                try{
                    cheio.acquire();
                    mutex.acquire();

                }catch (InterruptedException e){
                    e.printStackTrace();
                }

                //if (buffer.size() > 0){
                    Integer inteiroConsumido = buffer.remove(0);
                    System.out.println("Consumidor: consumiu "+inteiroConsumido);
               // }

                mutex.release();
                vazio.release();
            }
        }
    }
}
