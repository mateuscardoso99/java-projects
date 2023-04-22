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
			while(cb == true){}
			ca = true;
			num++;
			ca = false;
			System.out.println("A "+ca+" "+" "+cb+" num: "+num);
			Thread.sleep(100);
		}
	}

	public void processB() throws InterruptedException{
		while(true){
			while(ca == true){}
			cb = true;
			num++;
			cb = false;
			System.out.println("B "+ca+" "+" "+cb+" num: "+num);
			Thread.sleep(100);
		}
	}
}
