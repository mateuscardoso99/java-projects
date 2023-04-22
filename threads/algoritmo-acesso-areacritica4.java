import java.util.Random;

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
    static int num = 0;
    boolean ca = false;
    boolean cb = false;
    
    public void processA() throws InterruptedException{
        while(true){
            ca = true;
            while(cb == true){
                ca=false;
                Thread.sleep(new Random().nextInt(2)*100);
                ca = true;
            }
            num++;
             ca=false;
            System.out.println("A "+ca+" "+" "+cb+" num: "+num);
        }
    }
    
    public void processB() throws InterruptedException{
        while(true){
            cb = true;
            while(ca == true){
                cb=false;
                Thread.sleep(new Random().nextInt(2)*100);
                cb = true;
            }
            num++;
            cb = false;
            System.out.println("B "+ca+" "+" "+cb+" num: "+num);
        }
    }
}
