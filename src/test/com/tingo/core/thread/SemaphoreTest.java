package tingo.core.thread;

import java.util.concurrent.Semaphore;

/**
 * Created by user on 16/11/1.
 */
public class SemaphoreTest {
    private static final Semaphore semaphore = new Semaphore(2);

    public static void main(String[] args) {

        Runnable r = new Runnable() {
            public void run() {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(20000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }
        };

        Thread thread1 = new Thread(r);
        Thread thread2 = new Thread(r);

        thread1.start();
        thread2.start();
    }
}
