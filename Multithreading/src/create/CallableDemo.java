package create;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CallableDemo {

	public static void main(String[] args) {
		Counter counter = new Counter();
		CompletableFuture<Integer> f = CompletableFuture.supplyAsync(() -> {
			int x = 1;
			while (x < 5) {
				// System.out.println(Thread.currentThread().getName());
				counter.incCounter();
				System.out.println("Thread.currentThread().getName()" + counter.count);
				x++;
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			return x;

		});
		try {
			System.out.println(f.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Done");
		
	}

}