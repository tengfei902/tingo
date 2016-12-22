package tingo.core.multi;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by tengfei on 2016/11/2.
 */
public class ThreadPoolExcutorTest {

    private static ThreadPoolExecutor executor;

    public static void main(String[] args) {
        executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        executor.execute(new Task());
        executor.shutdown();

        executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
        Future<Integer> result = executor.submit(new CallableTask());
        try {
            System.out.println("result:"+result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}

class Task implements Runnable {
    public void run() {
        System.out.println(Thread.currentThread().getName()+": started");
    }
}

class CallableTask implements Callable<Integer> {
    public Integer call() throws Exception {
        return new Random().nextInt();
    }
}
