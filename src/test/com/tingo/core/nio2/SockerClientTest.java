package tingo.core.nio2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.Random;
import java.util.concurrent.ExecutionException;

/**
 * Created by user on 16/12/30.
 */
public class SockerClientTest {

    public static void main(String[] args) {

    }

    public void testSocketClient(String ip,Integer port) throws IOException,ExecutionException,InterruptedException {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        ByteBuffer helloBuffer = ByteBuffer.wrap("Hello!".getBytes());
        ByteBuffer randomBuffer ;
        CharBuffer charBuffer;
        Charset charset = Charset.defaultCharset();
        CharsetDecoder decoder = charset.newDecoder();

        AsynchronousSocketChannel socketChannel = AsynchronousSocketChannel.open();
        socketChannel.setOption(StandardSocketOptions.SO_RCVBUF,128*1024);
        socketChannel.setOption(StandardSocketOptions.SO_SNDBUF,128*1024);
        socketChannel.setOption(StandardSocketOptions.SO_KEEPALIVE,true);

        Void connect = socketChannel.connect(new InetSocketAddress(ip,port)).get();
        if(connect == null) {
            System.out.println("Local address:"+socketChannel.getLocalAddress());
            socketChannel.write(helloBuffer).get();

            while (socketChannel.read(buffer).get()!= -1) {
                buffer.flip();
                charBuffer = decoder.decode(buffer);
                System.out.println(charBuffer.toString());

                if(buffer.hasRemaining()) {
                    buffer.compact();
                } else {
                    buffer.clear();
                }

                int r = new Random().nextInt();
                if(r == 50) {
                    System.out.println("50 was generated ! Close asynchronous socket channel!");
                    break;
                } else {
                    randomBuffer = ByteBuffer.wrap("Random num".concat(String.valueOf(r)).getBytes());
                    socketChannel.write(randomBuffer);
                }
            }
        } else {
            System.out.println("The connection cannot be established");
        }
    }
}
