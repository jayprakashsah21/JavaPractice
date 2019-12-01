package create;

import java.util.concurrent.Callable;

public class CreateThread1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Counter counter = new Counter();
	
		Runnable r=null;
		
			r = () -> {
				int x=1;
				while (x < 5) {
				//System.out.println(Thread.currentThread().getName());
				counter.incCounter();
				System.out.println("Thread.currentThread().getName()"+counter.count);
				x++;
			}
			
		};
		
		
			Thread t1 = new Thread(r);
			Thread t2 = new Thread(r);
			t1.start();
			t2.start();
			
		    
			

	}
	
}

class Counter {
	volatile int count = 0;

	void incCounter() {
		count = count + 1;
	}

}
