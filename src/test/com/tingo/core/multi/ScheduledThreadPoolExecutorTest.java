package tingo.core.multi;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by tengfei on 2016/11/2.
 */
public class ScheduledThreadPoolExecutorTest {

    public static void main(String[] args) {
        ScheduledThreadPoolExecutor executor = (ScheduledThreadPoolExecutor)Executors.newScheduledThreadPool(1);

        for(int i=0;i<5;i++) {
            ScheduledTask task = new ScheduledTask("schedule"+i);
            System.out.println("start at:"+new Date());
            executor.schedule(task,2000, TimeUnit.MILLISECONDS);
        }
    }
}

class ScheduledTask implements Callable<String> {

    private String name;

    public ScheduledTask(String name) {
        this.name = name;
    }

    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName()+" start,"+name+", execute at:"+new Date());
        return "Hello,"+name;
    }
}
