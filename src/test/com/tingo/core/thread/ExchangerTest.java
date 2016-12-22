package tingo.core.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * Created by user on 16/11/2.
 */
public class ExchangerTest {

    private static Exchanger<List<String>> exchanger = new Exchanger<List<String>>();

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Producer(exchanger));
        Thread thread2 = new Thread(new Consumer(exchanger));

        thread1.start();
        thread2.start();
    }
}

class Producer implements Runnable {

    private Exchanger<List<String>> exchanger;

    public Producer(Exchanger<List<String>> exchanger) {
        this.exchanger = exchanger;
    }

    public void run() {
        List<String> buffer = new ArrayList<String>();
        int i=0;
        while (true) {
            i++;
            buffer.add("test");
            if(buffer.size()>=10) {
                try {
                    exchanger.exchange(buffer);
                    System.out.println("Producer size:"+buffer.size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if(i>=100) {
                break;
            }
        }
    }
}

class Consumer implements Runnable {

    private Exchanger<List<String>> exchanger;

    public Consumer(Exchanger<List<String>> exchanger) {
        this.exchanger = exchanger;
    }

    public void run() {
        List<String> buffer = new ArrayList<String>();
        for(int i=0;i<10;i++) {
            try {
                buffer = exchanger.exchange(buffer);
                System.out.println("Consumer size:"+buffer.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
