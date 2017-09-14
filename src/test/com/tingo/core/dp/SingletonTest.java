package tingo.core.dp;

import org.junit.Test;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by user on 17/8/12.
 */
public class SingletonTest {

    @Test
    public void generateSeriNo() {
        for(int i=0;i<10;i++) {
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    System.out.println(SeriNoGenerator.getInstance().generate());
                }
            });
            thread.start();
        }
    }
}

class SeriNoGenerator {
    private String systemId;

    private static SeriNoGenerator generator;
    private AtomicInteger count = new AtomicInteger(0);
    private volatile int autoInc = 0;

    private SeriNoGenerator() {
        this.systemId = "000001";
    }

    public static SeriNoGenerator getInstance() {
        if(Objects.isNull(generator)) {
            generator = new SeriNoGenerator();
        }
        return generator;
    }

    public String generate() {
        return String.format("%s_%s",systemId,count.getAndIncrement());
    }
}
