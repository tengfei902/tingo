package tingo.core.thread;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by user on 16/12/3.
 */
public class ThreadLocalTest {

    public static void main(String[] args) {
        UnsafeTask unsafeTask = new UnsafeTask();
        for(int i=0;i<10;i++) {
            Thread thread = new Thread(unsafeTask);
            thread.start();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class UnsafeTask implements Runnable {

    private ThreadLocal<Date> startDate = new ThreadLocal<Date>() {
        @Override
        protected Date initialValue() {
            return new Date();
        }
    };

    public void run() {
        System.out.printf("Starting thread: %s : %s\n",Thread.currentThread().getId(),startDate.get());
        try {
            TimeUnit.SECONDS.sleep((int)Math.rint(Math.random()*10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Thread finished: %s : %s\n",Thread.currentThread().getId(),startDate.get());
    }
}
