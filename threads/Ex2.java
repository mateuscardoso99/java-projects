/**
 * Dado um inteiro N, a tarefa é escrever um programa Java para imprimir os primeiros N números naturais em ordem 
 * crescente usando dois threads.
 * criar duas threads e imprimir números pares com uma thread e números ímpares com outra thread. Abaixo estão os passos
 * Se o contador for par no Thread T1, espere que o thread T2 imprima esse número par. Caso contrário, imprima esse número ímpar, 
 * incremente o contador e notifique para o Thread T2  usando a função notify() .
 * Se o contador for ímpar no Thread T2 , aguarde que o thread T1 imprima esse número ímpar. Caso contrário, 
 * imprima esse número par, incremente o contador e notifique o Thread T1 usando a função notify().
 */

public class Ex2{
    public static int N = 0;
    
    public static void main(String[] args) {

        Ex2 e = new Ex2();

        Thread t1 = new Thread(new Runnable() {
            public void run(){
                try{
                    e.imprimirPares();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run(){
                try{
                    e.imprimirImpares();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
    }

    public synchronized void imprimirPares() throws InterruptedException{
        while(true){
            if(Ex2.N % 2 != 0){
                wait();
            }
            
            System.out.println(Ex2.N);
            Ex2.N++;
            notify();
            Thread.sleep(800);           
        }
    }

    public synchronized void imprimirImpares() throws InterruptedException{
        while(true){
            if(Ex2.N % 2 == 0){
                wait();
            }
            
            System.out.println(Ex2.N);
            Ex2.N++;
            notify();
            Thread.sleep(800);
        }
    }

}
