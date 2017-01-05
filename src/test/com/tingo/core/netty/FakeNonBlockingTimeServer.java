package tingo.core.netty;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by user on 17/1/2.
 */
public class FakeNonBlockingTimeServer {
    public static void main(String[] args) {
        int port = 8080;
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            System.out.println("The time server is start in port:"+port);
            Socket socket = null;
            FakeNonBlockingTimeServerHandlerExecutePool executor = new FakeNonBlockingTimeServerHandlerExecutePool(50,10000);
            while (true) {
                socket = server.accept();
                executor.execute(new BlockingTimeServerHandler(socket));
            }
        } catch (IOException e) {

        } finally {
            System.out.println("The time server close");
            try {
                server.close();
            } catch (IOException e) {

            }

        }

    }
}
