package tingo.core.nio;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * Created by user on 16/12/26.
 */
public class SelectorTest {
    private static final int PORT=8080;

    private ByteBuffer byteBuffer = ByteBuffer.allocate(100);

    public static void main(String[] args) throws Exception {
        new SelectorTest().go();
    }

    public void go() throws Exception {
        Selector selector = Selector.open();

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        ServerSocket serverSocket = serverSocketChannel.socket();
        serverSocket.bind(new InetSocketAddress(PORT));
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while(true) {
            int n = selector.select();

            if(n==0) {
                continue;
            }

            Iterator it = selector.selectedKeys().iterator();
            while(it.hasNext()) {
                SelectionKey key = (SelectionKey)it.next();
                if(key.isAcceptable()) {
                    ServerSocketChannel server = (ServerSocketChannel) key.channel();
                    SocketChannel channel = server.accept();
                    registerChannel(selector,channel,SelectionKey.OP_READ);
                    sayHello(channel);
                }

                if(key.isReadable()) {
                    readDataFromSocket(key);
                }

                it.remove();
            }
        }
    }

    private void registerChannel(Selector selector, SelectableChannel channel,int ops) throws Exception {
        if(channel == null) {
            return;
        }

        channel.configureBlocking(false);
        channel.register(selector,ops);
    }

    private void readDataFromSocket(SelectionKey key) throws Exception {
        SocketChannel socketChannel = (SocketChannel) key.channel();
        int count;
        byteBuffer.clear();
        while((count = socketChannel.read(byteBuffer)) >0) {
            byteBuffer.flip();
            while(byteBuffer.hasRemaining()) {
                socketChannel.write(byteBuffer);
            }
            byteBuffer.clear();
        }

        if(count<0) {
            socketChannel.close();
        }
    }

    private void sayHello(SocketChannel socketChannel) throws Exception {
        byteBuffer.clear();
        byteBuffer.put("Hi there!".getBytes());
        byteBuffer.flip();
        socketChannel.write(byteBuffer);
    }
}
