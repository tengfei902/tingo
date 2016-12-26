package tingo.core.nio;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.ServerSocketChannel;

/**
 * Created by tengfei on 2016/12/25.
 */
public class ServerSocketChannelTest {

    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        ServerSocket serverSocket = serverSocketChannel.socket();
        serverSocket.bind(new InetSocketAddress(8080));
        //阻塞模式监听
        serverSocket.accept();
        //非阻塞模式监听
        serverSocketChannel.accept();
    }
}
