package tingo.core.netty;

/**
 * Created by user on 17/1/2.
 */
public class NonBlockingTimeServer {
    public static void main(String[] args) {
        int port = 8080;
        MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port);
        new Thread(timeServer).start();
    }
}
