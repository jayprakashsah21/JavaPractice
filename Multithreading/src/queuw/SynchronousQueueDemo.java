package queuw;

import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueDemo {

    public static void main(String[] args) {

        SynchronousQueue<String> sq = new SynchronousQueue<>();
        Producer p = new Producer(sq);
        p.start();
        Consumer c = new Consumer(sq);
        c.start();

    }
}
     class Producer extends Thread{
        SynchronousQueue q;
        Producer(SynchronousQueue q){
            this.q=q;
        }

        @Override
        public void run() {
            String s="Added";
            try {
                System.out.printf("[%s] published event : %s %n", Thread .currentThread().getName(), s);
                q.put(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
     class Consumer extends Thread{
        SynchronousQueue q;
        Consumer(SynchronousQueue q){
            this.q=q;
        }

        @Override
        public void run() {

            try {
                String event = (String) q.take(); // thread will block here
                 System.out.printf("[%s] consumed event : %s %n", Thread .currentThread().getName(), event);
        } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


