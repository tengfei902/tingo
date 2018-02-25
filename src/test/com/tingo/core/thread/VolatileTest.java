package tingo.core.thread;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

/**
 * Created by user on 17/8/1.
 */
public class VolatileTest {

    private int count = 0;

    @Test
    public void testVolatile() {
        for(int i=0;i<1000;i++) {
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    count++;
                    try {
                        Thread.sleep(RandomUtils.nextLong(0,1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
        }

        System.out.println(count);
    }

    @Test
    public void testWait() {
        System.out.println("000-------");
        try {
            this.wait(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("00000000000");

    }
}
