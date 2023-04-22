import java.util.Random;
import java.util.concurrent.Semaphore;

class Main{
    public static void main(String[] args) throws InterruptedException{
        Teste t = new Teste();
         
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run(){
                try {
                    t.processA();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run(){
                try {
                    t.processB();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
    
class Teste{
    Semaphore mutex = new Semaphore(1);
    static int num = 0;
    boolean ca = false;
    boolean cb = false;
    
    public void processA() throws InterruptedException{
        while(true){
            mutex.acquire();
            num++;
            System.out.println("A "+num);
            mutex.release();
            
        }
    }
    
    public void processB() throws InterruptedException{
        while(true){
            mutex.acquire();
            num++;
            System.out.println("B "+num);
            mutex.release();
            
        }
    }
}
