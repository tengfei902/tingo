package tingo.core.thread;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by user on 16/12/3.
 */
public class JoinTest {

    public static void main(String[] args) {
        DatasourceLoader dsLoader1 = new DatasourceLoader();
        Thread thread1 = new Thread(dsLoader1,"DataSourceThread1");
        DatasourceLoader dsLoader2 = new DatasourceLoader();
        Thread thread2 = new Thread(dsLoader2,"DataSourceThread2");
        thread1.start();
        thread2.start();

        //插入thread1和thread2执行结束后,继续执行main线程
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Finished call threads");
    }
}

class DatasourceLoader implements Runnable {
    public void run() {
        System.out.println("Beginning datasource loading:"+new Date());
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("DataSources loading finished,"+new Date());
    }
}
