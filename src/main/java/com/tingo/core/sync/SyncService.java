package com.tingo.core.sync;

/**
 * Created by user on 17/7/27.
 */
public class SyncService {

    public synchronized void test1() {
        System.out.println("start test1");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {

        }
        System.out.println("finish test1");
    }

    public synchronized void test2() {
        System.out.println("start test2");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {

        }
        System.out.println("finish test2");
    }

    public synchronized static void test3() {
        System.out.println("start test3");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {

        }
        System.out.println("finish test3");
    }
}
