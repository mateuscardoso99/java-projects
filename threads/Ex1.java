/**
 * Na computação, o problema do produtor-consumidor (também conhecido como problema do buffer limitado) é um exemplo 
 * clássico de um problema de sincronização de vários processos. O problema descreve dois processos, o produtor e o consumidor, 
 * que compartilham um buffer comum de tamanho fixo usado como uma fila. 
 * O trabalho do produtor é gerar dados, colocá-los no buffer e começar de novo.
 * Ao mesmo tempo, o consumidor está consumindo os dados (ou seja, removendo-os do buffer), um pedaço de cada vez.
 * 
 * Problema 
 * Para garantir que o produtor não tente adicionar dados ao buffer se ele estiver cheio e que o consumidor não tente 
 * remover dados de um buffer vazio.
 * 
 * Solução 
 * O produtor deve entrar em suspensão ou descartar os dados se o buffer estiver cheio. Na próxima vez que o consumidor 
 * remover um item do buffer, ele notificará o produtor, que começará a preencher o buffer novamente. 
 * Da mesma forma, o consumidor pode dormir se descobrir que o buffer está vazio. Na próxima vez que o produtor colocar 
 * dados no buffer, ele acordará o consumidor adormecido. 
 * Uma solução inadequada pode resultar em um impasse onde ambos os processos estão esperando para serem ativados.
 */

 /**
  * Na classe Teste (uma classe que possui métodos de produção e consumo), uma lista encadeada de trabalhos e uma 
  * capacidade da lista são adicionadas para verificar se o produtor não produz se a lista estiver cheia.
  */
import java.util.LinkedList;

public class Ex1 {
    public static void main(String[] args) throws InterruptedException {
        final Teste pc = new Teste();

        //Cria thread do produtor
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run()
            {
                try {
                    pc.produce();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
 
        //Cria thread do consumidor
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run()
            {
                try {
                    pc.consume();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Inicia as duas threads
        t1.start();
        t2.start();

        // t1 termina antes de t2
        t1.join();
        t2.join();
    }
}


// Esta classe tem uma lista, produtor (adiciona itens à lista // e consumidor (remove itens).
class Teste{
    LinkedList<Integer> list = new LinkedList<>();// Cria uma lista compartilhada por produtor e consumidor // O tamanho da lista é 2.
    int capacity = 2; //uma capacidade variável – para verificar se a lista está cheia ou não

    //Função chamada pela thread produtor
    public void produce() throws InterruptedException{
        int value = 0;

        while(true){
            /**
             * synchronized: bloco sincronizado para que apenas uma thread produtora ou consumidora seja executada por vez.
             * Sincronização em java é a capacidade de controlar o acesso de vários threads a qualquer recurso compartilhado. 
             * No conceito Multithreading, vários threads tentam acessar os recursos compartilhados por vez para produzir 
             * resultados inconsistentes. A sincronização é necessária para uma comunicação confiável entre as threads.
             */

            synchronized(this){

                // thread do produtor vai esperar enquanto lista estiver cheia, quando esvaziar sai do while e passa a produzir denovo
                //quando o a outra thread esvaziar a lista o while retornará false e sairá do while
                while(list.size() == capacity){
                    wait();// hamar wait() força o thread atual a esperar até que algum outro thread invoque notify() ou notifyAll() no mesmo objeto
                }

                System.out.println("Producer produced-"+ value);
                list.add(value++);//insere valores na lista compartilhada
                notify();//notifica o thread do consumidor que agora pode começar a consumir, ou seja, vai sair do while dele e começar a consumir
                Thread.sleep(800);//pra que as coisas acontecam mais devagar só pra entender
            }
        }
    }

    //Função chamada pela thread consumidor
    public void consume() throws InterruptedException{
        while (true) {
            synchronized (this){

                // thread do consumidor vai esperar enquanto lista estiver vazia, quando estiver cheia sai do while e passa a consumir denovo
                while (list.size() == 0)
                    wait();
 
                // consome o primeiro elemento da lista
                int val = list.removeFirst();
                System.out.println("Consumer consumed-"+ val);

                // Ativar thread do produtor
                notify();//Usamos o método notify() para ativar threads que estão aguardando acesso ao monitor desse objeto
                Thread.sleep(800);
            }
        }
    }
}
