package tingo.core.nio2;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.*;

/**
 * Created by tengfei on 2016/12/29.
 */
public class AsyncIOTest {
    public static void main(String[] args) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(100);
        String encoding = System.getProperty("file.encoding");

        Path path = Paths.get("targetFile");
        AsynchronousFileChannel asynchronousFileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.READ);
        Future<Integer> result = asynchronousFileChannel.read(buffer,0);

        while(!result.isDone()) {
            System.out.println("Do something else while reading");
        }

        buffer.flip();
        buffer.clear();
    }

    public void writeFile() throws IOException {
        ByteBuffer buffer = ByteBuffer.wrap("file content".getBytes());
        Path path = Paths.get("");
        AsynchronousFileChannel asynchronousFileChannel = AsynchronousFileChannel.open(path,StandardOpenOption.WRITE);
        Future<Integer> result = asynchronousFileChannel.write(buffer,100);
        while(!result.isDone()) {
            System.out.println("");
        }
    }

    public void testCompletionHandler() throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(100);
        Path path = Paths.get("");

        AsynchronousFileChannel asynchronousFileChannel = AsynchronousFileChannel.open(path,StandardOpenOption.READ);
        final Thread thread = Thread.currentThread();
        asynchronousFileChannel.read(buffer, 0, "read operation", new CompletionHandler<Integer, String>() {
            public void completed(Integer result, String attachment) {
                thread.interrupt();
            }

            public void failed(Throwable exc, String attachment) {
                thread.interrupt();
            }
        });
    }

    public void testMultiThreadRead() throws IOException {
        final int threads = 5;
        ExecutorService taskExecutors = Executors.newFixedThreadPool(threads);

        List<Future<ByteBuffer>> list = new ArrayList<Future<ByteBuffer>>();
        Path path = Paths.get("");

        Set options = new TreeSet();
        options.add(StandardOpenOption.READ);

        final AsynchronousFileChannel asynchronousFileChannel = AsynchronousFileChannel.open(path,options,taskExecutors);

        for(int i=0;i<50;i++) {
            Callable<ByteBuffer> worker = new Callable<ByteBuffer>() {
                public ByteBuffer call() throws Exception {
                    ByteBuffer buffer = ByteBuffer.allocateDirect(ThreadLocalRandom.current().nextInt(100,200));
                    asynchronousFileChannel.read(buffer,ThreadLocalRandom.current().nextInt(0,100));
                    return buffer;
                }
            };

            Future<ByteBuffer> future = taskExecutors.submit(worker);
            list.add(future);
        }

        taskExecutors.shutdown();
        
    }
}
