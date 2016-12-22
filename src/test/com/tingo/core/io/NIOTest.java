package tingo.core.io;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by user on 16/12/10.
 */
public class NIOTest {

    public static void main(String[] args) {
        try {
            ServerSocketChannel acceptorSvr = ServerSocketChannel.open();
            acceptorSvr.socket().bind(new InetSocketAddress(InetAddress.getByName("IP"),8080));
            acceptorSvr.configureBlocking(false);
            Selector selector = Selector.open();
            SelectionKey key = acceptorSvr.register(selector,SelectionKey.OP_ACCEPT,ioHandler);
            int num = selector.select();
            Set selectedKeys = selector.selectedKeys();
            Iterator it = selectedKeys.iterator();
            while(it.hasNext()) {
                SelectionKey selectionKey = (SelectionKey)it.next();

            }
        } catch (IOException e) {

        }

    }
}
