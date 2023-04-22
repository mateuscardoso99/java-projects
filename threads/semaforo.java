/**
 * Um semáforo controla o acesso a um recurso compartilhado por meio do uso de um contador.
 * Se o contador for maior que zero, o acesso é permitido. Se for zero, o acesso foi negado. 
 * O que o contador está contando são as permissões que permitem o acesso ao recurso compartilhado. 
 * Assim, para acessar o recurso, um thread deve receber uma permissão do semáforo
 * 
 * Conceitualmente, um semáforo mantém um conjunto de permissões. 
 * Cada acquire() bloqueia se necessário até que uma permissão esteja disponível e então a pegue. 
 * Cada release() adiciona uma permissão, potencialmente liberando um adquirente bloqueador
 * 
 * Em geral, para usar um semáforo, a thread que deseja acessar o recurso compartilhado tenta adquirir uma licença (acquire).
 * Se a contagem do semáforo for maior que zero (new Semaphore(1) por exemplo), a thread obtém uma permissão, o que faz com que a contagem do semáforo diminua (new Semaphore(0) por exemplo).
 * Caso contrário, o tópico será bloqueado até que uma licença possa ser adquirida.
 * Quando a thread não precisa mais de acesso ao recurso compartilhado, ela libera a permissão (release), o que faz com que a contagem do semáforo seja incrementada (new Semaphore(1) denovo por exemplo).
 * Se houver outro segmento esperando por uma licença, então esse segmento irá adquirir uma licença naquele momento.
 */


import java.util.concurrent.Semaphore;

/** Copyright (c), AnkitMittal JavaMadeSoEasy.com */ 
class Main{
    
    public static void main(String[] args) {
        Semaphore semaphoreProducer=new Semaphore(1);//parametro '1' significa que somente uma thread pode acessar a area critica por vez
        Semaphore semaphoreConsumer=new Semaphore(0);//parametro '0' significa que nenhuma thread tem permissao pra acessar a area critica
        //pro semaphoreConsumer poder acessar a area critica precisa fazer release e depois aquire pra adquirir uma permissao
        //depois de acessar a area critica deve fazer release pra liberar o semaforo pra outra Thread acessar a area critica
           
        System.out.println("semaphoreProducer permit=1 | semaphoreConsumer permit=0");
           
        Producer producer=new Producer(semaphoreProducer,semaphoreConsumer);
        Consumer consumer=new Consumer(semaphoreConsumer,semaphoreProducer);
      
        Thread producerThread = new Thread(producer, "ProducerThread");
        Thread consumerThread = new Thread(consumer, "ConsumerThread");
 
        producerThread.start();
        consumerThread.start();
    }
}
 
 
 
 
/**
 * O semáforo produtor é criado com permissão = 1. Assim, esse produtor pode obter a licença para produzir.
 * O semáforo consumidor é criado com permit = 0. Assim, esse consumidor poderia aguardar a autorização para consumir. [porque inicialmente o produtor não produziu nenhum produto]
 * O produtor obtém permissão chamando semaphoreProducer.acquire() e começa a produzir, depois de produzi-lo chama semaphoreConsumer.release(). Assim, esse consumidor pode obter a licença para consumir.
 * O consumidor obtém permissão chamando semaphoreConsumer.acquire() e começa a consumir, depois de consumir chama semaphoreProducer.release(). Assim, esse produtor pode obter a licença para produzir.
 */
class Producer implements Runnable{
    
    Semaphore semaphoreProducer;
    Semaphore semaphoreConsumer;
    
    public Producer(Semaphore semaphoreProducer,Semaphore semaphoreConsumer) {
        this.semaphoreProducer=semaphoreProducer;
        this.semaphoreConsumer=semaphoreConsumer;
    }
 
    public void run() {
        for(int i=1;i<=5;i++){
            try {
                //semaforo produtor adquire uma permissao, como semaphoreProducer foi criado com new Semaphore(1) entao soh precisar usar usar acquire() pra solicitar a permissao
                semaphoreProducer.acquire();
                //acessa a area critica
                System.out.println("Produced : "+i);
                //semaforo consumidor libera uma permissao, como semaphoreConsumer foi criado com new Semaphore(0) nao adianta dar acquire() pois sera negado, precisa antes dar release() pra liberar uma vaga no semaforo e entao sim dar acquire()
                semaphoreConsumer.release();
                        
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }          
    }
}
 

class Consumer implements Runnable{
 
    Semaphore semaphoreConsumer;
    Semaphore semaphoreProducer;
    
    public Consumer(Semaphore semaphoreConsumer,Semaphore semaphoreProducer) {
        this.semaphoreConsumer=semaphoreConsumer;
        this.semaphoreProducer=semaphoreProducer;
    }
 
    public void run() {   
        for(int i=1;i<=5;i++){
            try {
                semaphoreConsumer.acquire();
                System.out.println("Consumed : "+i);
                semaphoreProducer.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }   
}
