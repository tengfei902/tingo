package tingo.core.nio;

import sun.nio.ch.DirectBuffer;

import java.io.FileInputStream;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by tengfei on 2016/12/21.
 */
public class ChannelTest {

    public static void main(String[] args) throws Exception {
        //SocketChannel open
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost",8080));

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress("localhost",8080));

        DatagramChannel datagramChannel = DatagramChannel.open();
        datagramChannel.connect(new InetSocketAddress("localhost",8080));

        //FileChannel对象只能通过在一个打开的RandomAccessFile,FileInputStream,FileOutputStream对象上调用getChannel方法
        RandomAccessFile randomAccessFile = new RandomAccessFile("filePath","r");
        FileChannel fileChannel = randomAccessFile.getChannel();

        FileInputStream fileInputStream = new FileInputStream("filename");
        FileChannel fileChannel1 = fileInputStream.getChannel();

        //写入byteBuffer
        fileChannel1.write(ByteBuffer.allocate(100));
    }
}
