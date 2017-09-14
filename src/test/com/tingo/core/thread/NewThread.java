package tingo.core.thread;

/**
 * Created by user on 17/8/1.
 */
public class NewThread extends Thread {

    public NewThread() {
        super("demo thread");
        start();
    }

    @Override
    public void run() {
        super.run();
    }
}
