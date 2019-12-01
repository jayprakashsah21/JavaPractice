package educative.io;

public class WaitANdNotify {
	public static void main(String[] args) throws InterruptedException {
		ThreadA a = new ThreadA();
		a.start();
		Thread.sleep(1000);
		synchronized (a) {
			a.wait(1000);
			System.out.println(a.sum);
		}
		
	}
}

class ThreadA extends Thread {
	int sum = 0;

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			sum += i;
			synchronized (this) {
				this.notify();
			}
			
		}
	}
}