package volatiles;

import java.util.Scanner;

public class Volatile {

	public static void main(String[] args) {

		Counter c = new Counter();
		Thread1 t1 = new Thread1(c);
		Thread2 t2 = new Thread2(c);
		t1.start();
		t2.start();
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		t2.stopCount();

	}

}

class Counter {

	private int counter = 0;

	void incrCount() {
		System.out.print("Current Thread:" + Thread.currentThread());
		counter++;
	}

	public int getCounter() {
		return counter;
	}
}

class Thread1 extends Thread {

	private Counter counter;

	private boolean counting = true;

	Thread1(Counter counter) {
		this.counter = counter;
	}

	@Override
	public void run() {
		while (counting) {
			// counter.incrCount();
			counter.incrCount();
			System.out.println(counter.getCounter());
		}
	}

}

class Thread2 extends Thread {

	private Counter counter;
	private boolean counting = true;

	Thread2(Counter counter) {
		this.counter = counter;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (counting) {
			// counter.incrCount();
			counter.incrCount();
			System.out.println(counter.getCounter());
		}

	}

	public void stopCount() {
		counting = false;
	}

}