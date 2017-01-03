package tingo.core.netty;

/**
 * Created by user on 17/1/2.
 */
public class NonBlockingTimeClient {
    public static void main(String[] args) {
        int port = 8080;
        new Thread(new NonBlockingTimeClientHandler("127.0.0.1",port)).start();
    }
}
