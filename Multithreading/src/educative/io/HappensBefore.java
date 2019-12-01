package educative.io;

import java.util.concurrent.TimeUnit;

public class HappensBefore {
    private static boolean stopRequested;

    public static void main(String[] args)
            throws InterruptedException {
        Thread backgroundThread = new Thread(new Runnable() {
            public void run() {
                int i = 0;
                while (!stopRequested) {
                    i++;

                    System.out.println(i);
                }
            }
        });
        backgroundThread.start();
        TimeUnit.SECONDS.sleep(3);
       // requestStop();
        stopRequested=true;
    }

}
