package tingo.core.nio2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.*;

/**
 * Created by user on 16/12/30.
 */
public class SocketServerTest {
    public static void main(String[] args) {

    }

    public void testServerSocket(String ip,int port) throws IOException,ExecutionException,InterruptedException {
        AsynchronousServerSocketChannel serverSocketChannel = AsynchronousServerSocketChannel.open();
        serverSocketChannel.setOption(StandardSocketOptions.SO_RCVBUF,4*1024);
        serverSocketChannel.setOption(StandardSocketOptions.SO_REUSEADDR,true);
        serverSocketChannel.bind(new InetSocketAddress(ip,port));
        while (true) {
            Future<AsynchronousSocketChannel> socketChannelFuture = serverSocketChannel.accept();
            AsynchronousSocketChannel socketChannel = socketChannelFuture.get();
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            while (socketChannel.read(buffer).get() != -1) {
                buffer.flip();
                socketChannel.write(buffer).get();

                if(buffer.hasRemaining()) {
                    buffer.compact();
                } else {
                    buffer.clear();
                }
            }

            System.out.println(socketChannel.getRemoteAddress() + " was successfully served");
        }
    }

    public void testMultiServer(String ip,Integer port) throws IOException,ExecutionException,InterruptedException {
        ExecutorService taskExecutor = Executors.newCachedThreadPool(Executors.defaultThreadFactory());
        AsynchronousServerSocketChannel serverSocketChannel = AsynchronousServerSocketChannel.open();
        serverSocketChannel.setOption(StandardSocketOptions.SO_RCVBUF,4*1024);
        serverSocketChannel.setOption(StandardSocketOptions.SO_REUSEADDR,true);
        serverSocketChannel.bind(new InetSocketAddress(ip,port));

        System.out.println("waiting for connections.......");

        while (true) {
            Future<AsynchronousSocketChannel> socketChannelFuture = serverSocketChannel.accept();
            final AsynchronousSocketChannel socketChannel = socketChannelFuture.get();
            Callable<String> worker = new Callable<String>() {
                public String call() throws Exception {
                    String host = socketChannel.getRemoteAddress().toString();
                    System.out.println("incoming connection from :"+host);

                    ByteBuffer  buffer = ByteBuffer.allocate(1024);

                    while (socketChannel.read(buffer).get() != -1) {
                        buffer.flip();
                        socketChannel.write(buffer).get();

                        if(buffer.hasRemaining()) {
                            buffer.compact();
                        } else {
                            buffer.clear();
                        }
                    }

                    socketChannel.close();
                    System.out.println(host+" was successfully served");
                    return host;
                }
            };

            taskExecutor.submit(worker);
        }
    }

    public void testCompletionHandlerServer(String ip,Integer port) throws IOException {
        final AsynchronousServerSocketChannel serverSocketChannel = AsynchronousServerSocketChannel.open();
        serverSocketChannel.setOption(StandardSocketOptions.SO_RCVBUF,4*1024);
        serverSocketChannel.setOption(StandardSocketOptions.SO_REUSEADDR,true);
        serverSocketChannel.bind(new InetSocketAddress(ip,port));

        System.out.println("waiting connections.......");

        serverSocketChannel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Void>() {
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            public void completed(AsynchronousSocketChannel result, Void attachment) {
                try {
                    serverSocketChannel.accept(null,this);
                    System.out.println("Incoming connection from:"+result.getRemoteAddress());

                    while (result.read(buffer).get() != -1) {
                        buffer.flip();
                        result.write(buffer).get();
                        if(buffer.hasRemaining()) {
                            buffer.compact();
                        } else {
                            buffer.clear();
                        }
                    }
                } catch (Exception e ) {

                } finally {
                    try {
                        result.close();
                    } catch (IOException e) {

                    }
                }

            }

            public void failed(Throwable exc, Void attachment) {
                serverSocketChannel.accept(null,this);
            }
        });

    }
}
