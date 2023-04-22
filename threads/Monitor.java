package br.ufsm.poli.csi.so.threads;

import java.util.Objects;
import java.util.concurrent.Semaphore;

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
