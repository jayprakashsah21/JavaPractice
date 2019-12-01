package educative.io;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerProblem {
	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();
		new Producer(q).start();
		new Consumer(q).start();
	}
}

class Producer extends Thread {
	Queue<Integer> queue;
	private final int MAX_SIZE = 10;

	public Producer(Queue<Integer> queue) {
		super();
		this.queue = queue;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(3000);
			synchronized (queue) {
				for (int i = 0; i < 2000; i++) {
					if (queue.size() > MAX_SIZE) {
						try {
							queue.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					queue.add(i);
					System.out.println("Que is producing::" + queue.size());
					queue.notify();
				}
			}
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}

class Consumer extends Thread {
	Queue<Integer> queue;
	int i; 

	public Consumer(Queue<Integer> queue) {
		super();
		this.queue = queue;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(5000);
			synchronized (queue) {
				
					while (!queue.isEmpty()) {
						try {
							System.out.println("Que is empty::" + queue.size());
							queue.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

					System.out.println("Que is consuming::" + queue.poll());
					queue.notify();
				
			}
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
}
