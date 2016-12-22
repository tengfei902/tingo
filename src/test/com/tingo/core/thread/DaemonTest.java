package tingo.core.thread;

import javafx.event.Event;

import java.util.Deque;

/**
 * Created by user on 16/12/3.
 */
public class DaemonTest {

    public static void main(String[] args) {

    }
}

class WriterTask implements Runnable {

    private Deque<Event> deque;

    public WriterTask(Deque<Event> deque) {
        this.deque = deque;
    }

    public void run() {

    }
}