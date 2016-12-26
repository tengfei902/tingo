package tingo.core.nio;

import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/**
 * Created by tengfei on 2016/12/25.
 */
public class DatagramChannelTest {
    public static void main(String[] args) throws Exception {
        DatagramChannel datagramChannel = DatagramChannel.open();
        //负责监听
        DatagramSocket datagramSocket = datagramChannel.socket();
        datagramSocket.bind(new InetSocketAddress(8080));
        ByteBuffer buffer = ByteBuffer.allocate(100);
        datagramChannel.receive(buffer);
    }
}
