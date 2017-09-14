package tingo.core.thread;

import java.math.BigDecimal;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by user on 17/7/27.
 */
public class ReadWriteLock {

    private static java.util.concurrent.locks.ReadWriteLock lock = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        ReadWriteLockBean readWriteLockBean = new ReadWriteLockBean(lock);

        ReadWriteLockThread1 thread1 = new ReadWriteLockThread1(readWriteLockBean);
        ReadWriteLockThread1 thread2 = new ReadWriteLockThread1(readWriteLockBean);

        thread1.run();
        thread2.run();
    }
}

class ReadWriteLockThread1 implements Runnable {

    private ReadWriteLockBean readWriteLockBean;

    public ReadWriteLockThread1(ReadWriteLockBean readWriteLockBean) {
        this.readWriteLockBean = readWriteLockBean;
    }

    public void run() {
        readWriteLockBean.getPrice();
    }
}

class ReadWriteLockThread2 implements Runnable {

    private ReadWriteLockBean readWriteLockBean;

    public ReadWriteLockThread2(ReadWriteLockBean readWriteLockBean) {
        this.readWriteLockBean = readWriteLockBean;
    }

    public void run() {
        readWriteLockBean.setPrice(new BigDecimal("1000"));
    }
}

class ReadWriteLockBean {

    private java.util.concurrent.locks.ReadWriteLock readWriteLock;

    public ReadWriteLockBean(java.util.concurrent.locks.ReadWriteLock readWriteLock) {
        this.readWriteLock = readWriteLock;
    }

    private BigDecimal price;

    public BigDecimal getPrice() {
        readWriteLock.readLock().lock();
        System.out.println("Start get");
        try {
            Thread.sleep(5000L);
            System.out.println("finish get");
            return price;
        } catch (InterruptedException e) {

        }finally {
            readWriteLock.readLock().unlock();
        }
        return price;
    }

    public void setPrice(BigDecimal price) {
        readWriteLock.writeLock().lock();
        System.out.println("Start write");
        try {
            Thread.sleep(5000L);
            this.price = price;
            System.out.println("Finish write");
        } catch (InterruptedException e) {

        } finally {
            readWriteLock.writeLock().unlock();
        }
    }
}
