package tingo.core.netty;

import org.apache.log4j.net.SocketServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by tengfei on 17/1/2.
 */
public class BlockingTimeServer {
    public static void main(String[] args) throws IOException {
        int port = 8080;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("The time server is start in port:"+port);

        try {
            Socket socket = null;
            while (true) {
                socket = serverSocket.accept();
                new Thread(new BlockingTimeServerHandler(socket)).start();
            }
        } finally {
            System.out.println("The time server close");
            serverSocket.close();
        }

    }
}
