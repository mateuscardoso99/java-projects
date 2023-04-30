package br.ufsm.poli.csi.so.threads;

import java.util.Objects;
import java.util.concurrent.Semaphore;

/*
monitor é um mecanismo para controlar o acesso simultâneo a um objeto.
bloco syncronized impedirá que o outro acesse a região antes que o primeiro termine.
wait() faz a thread esperar e notify() ativa a thread.
Um bloco sincronizado em Java só pode ser executado por uma única thread por vez.
Os blocos sincronizados Java podem, portanto, ser usados para evitar condições de corrida

condicao de corrida:
Uma condição de corrida é um problema de simultaneidade que pode ocorrer dentro de uma area crítica. 
Uma area crítica é uma seção de código que é executada por vários threads e onde a sequência de execução dos 
threads faz diferença no resultado da execução simultânea da area crítica.
Quando o resultado de vários threads executando uma area crítica pode diferir dependendo da sequência na qual os threads são executados, 
diz-se que a seção crítica contém uma condição de corrida

synchronized pode ser usado para marcar quatro tipos diferentes de blocos:
Métodos de instância
métodos estáticos
Blocos de código dentro de métodos de instância
Blocos de código dentro de métodos estáticos

----

Métodos de instância sincronizados:
Um método de instância sincronizado em Java é sincronizado na instância (objeto) que possui o método. 
Assim, cada instância tem seus métodos synchronized sincronizados em um objeto diferente: a instância proprietária.
Apenas um thread por instância pode ser executado dentro de um método de instância sincronizado. 
Se existir mais de uma instância, um thread por vez pode ser executado dentro de um método de instância sincronizada por instância. 
ou seja um thread por instância.

----

Métodos estáticos sincronizados:
Esses métodos são sincronizados no objeto Class associado à classe. 
Como existe apenas um objeto Class por JVM por classe, apenas um encadeamento pode ser executado dentro de um 
método sincronizado estático por classe, independentemente do número de instâncias que possui.

----

Blocos sincronizados em métodos de instância:
Você não precisa sincronizar um método inteiro. Às vezes é preferível sincronizar apenas parte de um método. 
Os blocos sincronizados Java dentro dos métodos tornam isso possível.

public void add(int value){ 
  synchronized(this){ 
       this.count += value;
  }
}

Este exemplo usa a construção de bloco sincronizado Java para marcar um bloco de código como sincronizado. 
Este código agora será executado como se fosse um método sincronizado.

Observe como a construção de bloco sincronizado Java usa um objeto entre parênteses. 
No exemplo, "this" é usado, que é a instância em que o método add é chamado. O objeto colocado entre parênteses pela construção sincronizada é 
chamado de objeto monitor. Diz-se que o código está sincronizado no objeto do monitor. 
Um método de instância sincronizada usa o objeto ao qual pertence como objeto de monitor.
Apenas uma thread pode executar dentro de um bloco de código Java sincronizado no mesmo objeto monitor.
  
----

Blocos sincronizados em métodos estáticos:
Blocos sincronizados também podem ser usados dentro de métodos estáticos. Aqui estão os mesmos dois exemplos da seção anterior como métodos estáticos. 
Esses métodos são sincronizados no objeto de classe da classe à qual os métodos pertencem:
public class MyClass { 

  public static synchronized void log1(String msg1, String msg2){ 
       log.writeln(msg1); 
       log.writeln(msg2); 
  } 

  
  public static void log2(String msg1, String msg2){ 
       synchronized(MyClass.class){ 
          log.writeln(msg1); 
          log.writeln(msg2);  
       } 
  }
}

Apenas um thread pode executar dentro de qualquer um desses dois métodos ao mesmo tempo.
Se o segundo bloco sincronizado tivesse sido sincronizado em um objeto diferente de MyClass.class, 
uma thread poderia ser executada dentro de cada método ao mesmo tempo.

-----


Exemplo:
Aqui está um exemplo que inicia 2 threads e faz com que ambos chamem o método add na mesma instância de Counter. 
Apenas uma thread por vez poderá chamar o método add na mesma instância, pois o método é sincronizado na instância a qual pertence.

 public class Exemplo { 

    public static void main(String[] args){ 
      Counter counter = new Counter(); 
      Thread threadA = new CounterThread(counter); 
      Thread threadB = new CounterThread(contador); 

      threadA.start(); 
      threadB.start(); 
    } 
  }
  
Aqui estão as duas classes usadas no exemplo acima, Counter e CounterThread:

  public class Counter{
     
     long count = 0;
    
     public synchronized void add(long value){
       this.count += value;
     }
  }
  
  public class CounterThread extends Thread{

     protected Counter counter = null;

     public CounterThread(Counter counter){
        this.counter = counter;
     }

     public void run() {
	for(int i=0; i<10; i++){
           counter.add(i);
        }
     }
  }
  
Dois threads são criados. A mesma instância de Counter é passada para ambos em seu construtor. 
O Counter.add()método é sincronizado na instância, porque o método add é um método de instância e marcado como sincronizado. 
Portanto, apenas um dos threads pode chamar o método add() por vez. 
A outra thread irá esperar até que a primeira thread saia do método add(), antes de poder executar o próprio método.

----

Se as duas threads tivessem referenciado duas instâncias de Counter separadas, não haveria problemas em chamar os métodos add() simultaneamente.
As chamadas seriam para objetos diferentes, então os métodos chamados também seriam sincronizados em objetos diferentes (o objeto que possui o método).
Portanto, as chamadas não seriam bloqueadas. Aqui está como isso pode parecer:

public class Example {

 public static void main(String[] args){
    Counter counterA = new Counter();
    Counter counterB = new Counter();
    Thread  threadA = new CounterThread(counterA);
    Thread  threadB = new CounterThread(counterB);

    threadA.start();
    threadB.start();
  }
}

Observe como os dois threads, threadA e threadB, não fazem mais referência à mesma instância de Counter.
O método add de counterA e counterB são sincronizados em suas duas instâncias separadas. 
Chamar add() em counterA não bloqueará uma chamada para add() em counterB.


-------

Sincronização e Visibilidade de Dados:
Sem o uso da palavra-chave synchronized (ou a palavra-chave volatile do Java ) não há garantia de que quando uma thread altera o valor de uma 
variável compartilhada com outras threads (por exemplo, por meio de um objeto ao qual todas as threads têm acesso),
as outras threads podem ver o valor alterado. Não há garantias sobre quando uma variável mantida em um registrador da CPU por um 
thread é "confirmada" na memória principal, e não há garantia sobre quando outros threads "atualizam" uma variável 
mantida em um registrador da CPU da memória principal.

A palavra-chave synchronized muda isso. Quando um thread entra em um bloco sincronizado, ele atualiza os valores de todas as variáveis 
visíveis para o thread. Quando um thread sai de um bloco sincronizado, todas as alterações nas variáveis visíveis ao thread 
serão confirmadas na memória principal. Isso é semelhante ao funcionamento da palavra-chave volatile.
*/

public class Monitor {

    private long i = 0;
    private Object monitor = new Object();//monitor pode ser qualquer objeto, desde que ele seja colocado dentro dos syncronized(){}

    public static void main(String[] args) {
        new Monitor();
    }

    public Monitor() {
        ThreadA tA = new ThreadA();
        Thread t1 = new Thread(tA);
        ThreadB tB = new ThreadB();
        Thread t2 = new Thread(tB);
        Thread t3 = new Thread(new ThreadConfere(tA, tB));
        t1.start();
        t2.start();
        t3.start();
    }

    private class ThreadConfere implements Runnable {

        private ThreadA threadA;
        private ThreadB threadB;

        public ThreadConfere(ThreadA threadA, ThreadB threadB) {
            this.threadA = threadA;
            this.threadB = threadB;
        }

        @Override
        public void run() {
            System.out.println("CONFERE name: " + Thread.currentThread().getName() + ", id: " + Thread.currentThread().getId());
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) { }
                synchronized (Monitor.class) {//syncronized com mesmo objeto como parametro garante que o monitor funcione
                    long jSomados = threadA.j + threadB.j;
                    System.out.println("i = " + Monitor.this.i +
                            ", jSomados = " + jSomados +
                            ", dif: " + (jSomados - Monitor.this.i)
                    );
                }
            }
        }
    }

    private class ThreadA implements Runnable {

        private long j = 0;

        @Override
        public void run() {
            System.out.println("name: " + Thread.currentThread().getName() + ", id: " + Thread.currentThread().getId());
            while (true) {
                synchronized(Monitor.class) {//syncronized com mesmo objeto como parametro garante que o monitor funcione
                    i++;
                    j++;
                }
            }
        }
    }

    private class ThreadB implements Runnable {

        private long j = 0;

        @Override
        public void run() {
            System.out.println("name: " + Thread.currentThread().getName() + ", id: " + Thread.currentThread().getId());
            while (true) {
                synchronized (Monitor.class){//syncronized com mesmo objeto como parametro garante que o monitor funcione
                    i++;
                    j++;
                }
            }
        }
    }

}
