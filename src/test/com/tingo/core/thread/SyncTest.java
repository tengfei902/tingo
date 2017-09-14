package tingo.core.thread;

import com.tingo.core.sync.SyncService;

/**
 * Created by user on 17/7/27.
 */
public class SyncTest {

    public static void main(String[] args) {

        SyncService syncService = new SyncService();
        Thread thread1 = new Thread(new SyncThread1(syncService));
        SyncService syncService2 = new SyncService();
        Thread thread2 = new Thread(new SyncThread2(syncService2));

        thread1.start();
        thread2.start();

    }
}

class SyncThread1 implements Runnable {

    private SyncService syncService;

    public SyncThread1(SyncService syncService) {
        this.syncService = syncService;
    }

    public void run() {
        syncService.test1();
    }
}

class SyncThread2 implements Runnable {
    private SyncService syncService;

    public SyncThread2(SyncService syncService) {
        this.syncService = syncService;
    }

    public void run() {
        syncService.test2();
    }
}

class SyncThread3 implements Runnable {

    public void run() {
        SyncService.test3();
    }
}

