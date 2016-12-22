package tingo.core.thread;

import java.util.concurrent.CountDownLatch;

/**
 * Created by user on 16/11/1.
 */
public class CountDownLatchTest {

    private static final CountDownLatch countDownLatch = new CountDownLatch(10);

    public static void main(String[] args) {
        Thread[] threads = new Thread[10];
        for(int i=0;i<threads.length;i++) {
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    countDownLatch.countDown();
                    System.out.println(Thread.currentThread().getName()+" arrived");
                }
            });
            thread.start();
        }

        System.out.println("All started");
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Continue working");
    }
}
