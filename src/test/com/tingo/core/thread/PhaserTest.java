package tingo.core.thread;

import java.util.concurrent.Phaser;

/**
 * Created by user on 16/11/1.
 */
public class PhaserTest {

    private static Phaser phaser = new Phaser(3);

    public static void main(String[] args) {
        for(int i = 0;i<10;i++) {
            Thread thread = new Thread(new PrePhaser(phaser));
            System.out.println("Waiting others to start");
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            thread.start();
        }
    }
}

class PrePhaser implements Runnable {

    private Phaser phaser ;

    public PrePhaser(Phaser phaser) {
        this.phaser = phaser;
    }

    public void run() {
        phaser.arriveAndAwaitAdvance();
        System.out.println(Thread.currentThread().getName()+" started");
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName()+" finished");
            phaser.arriveAndDeregister();
        }

    }
}
