package locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {

	public static void main(String[] args) {

		Lock lock = new ReentrantLock();
		String s1 = "BC";
		String s2 = "DE";

		Runnable r = () -> {
			lock.lock();
			System.out.println("Thread 1: locked resource 1" + s1);
			lock.unlock();
			lock.lock();
			System.out.println("Thread 1: locked resource 2" + s2);
			lock.unlock();

		};

		Runnable r2 = () -> {
			lock.lock();
			System.out.println("Thread 2: locked resource 2" + s2);
			lock.unlock();
			lock.lock();
			System.out.println("Thread 2: locked resource 1" + s1);
			lock.unlock();

		};

		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();
	}
}
