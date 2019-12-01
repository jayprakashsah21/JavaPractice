package create;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeoutException;

import javax.swing.plaf.SliderUI;

public class CompleteFutureDemo {
	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		// TODO Auto-generated method stub
		ExecutorService executor = Executors.newFixedThreadPool(3);
		// create a list to hold the Future object associated with Callable
		// Thread.currentThread().join();

	

		CompletableFuture completableFuture = CompletableFuture.supplyAsync(() -> {

			try {
				Thread.sleep(4000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "4";

		});
		CompletableFuture completableFuture1 = CompletableFuture.supplyAsync(() -> {

			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "1";

		});
		
		CompletableFuture completableFuture2 = CompletableFuture.supplyAsync(() -> {

			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "2";

		});

		System.out.println(completableFuture.get());
		System.out.println("Hello");
		System.out.println(completableFuture1.get());
		System.out.println(completableFuture2.get());
		// System.out.println(CompletableFuture.supplyAsync(()->executor).get());
		// System.out.println(CompletableFuture.supplyAsync(()->executor).get());
		// System.out.println(CompletableFuture.supplyAsync(()->executor).get());

		// shut down the executor service now
		executor.shutdown();
	}

}

interface A{
	void get();
}
