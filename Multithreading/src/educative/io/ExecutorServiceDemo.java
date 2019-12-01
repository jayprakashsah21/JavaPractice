package educative.io;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceDemo {

	public static void main(String[] args) {
		System.out.println(Runtime.getRuntime().availableProcessors());
		ExecutorService es = Executors.newCachedThreadPool();
		for (int i = 0; i < 100; i++) {
			es.submit(new Task());
		}
		es.shutdown();
	}
}

class Task implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}
	

}
