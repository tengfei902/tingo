package tingo.core.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by user on 16/11/1.
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {
            public void run() {
                System.out.println("Next Step");
            }
        });

        for(int i=0;i<10;i++) {
            Thread thread = new Thread(new PreTask(cyclicBarrier));
            thread.start();
        }

        System.out.println("All started");
    }
}

class PreTask implements Runnable {

    private CyclicBarrier cyclicBarrier;

    public PreTask(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName()+" started");
        try {
            cyclicBarrier.await();
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        } catch (BrokenBarrierException e) {

        }

    }
}

class AfterTask implements Runnable {
    public void run() {

    }
}
