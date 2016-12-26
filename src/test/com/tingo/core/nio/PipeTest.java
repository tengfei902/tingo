package tingo.core.nio;

import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.Pipe;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

/**
 * Created by tengfei on 2016/12/26.
 * 通道中SourceChannel读到的内容会写入到SinkChannel中，SinkChannel的内容输出到System.out
 */
public class PipeTest {

    public static void main(String[] args) throws Exception {
        //wrap a channel around stdout
        WritableByteChannel out = Channels.newChannel(System.out);
        //Start worker and get read end of channel
        ReadableByteChannel workerChannel = startWorker(10);
        ByteBuffer byteBuffer = ByteBuffer.allocate(100);
        while(workerChannel.read(byteBuffer) >= 0) {
            byteBuffer.flip();
            out.write(byteBuffer);
            byteBuffer.clear();
        }
    }

    private static ReadableByteChannel startWorker(int reps) throws Exception {
        Pipe pipe = Pipe.open();
        Worker worker = new Worker(pipe.sink(),reps);
        worker.start();
        return pipe.source();
    }

    private static class Worker extends Thread {
        WritableByteChannel channel;
        private int reps;

        Worker(WritableByteChannel channel,int reps) {
            this.channel = channel;
            this.reps = reps;
        }

        public void run() {
            ByteBuffer buffer = ByteBuffer.allocate(100);
            try {
                for(int i=0;i<this.reps;i++) {
                    //do something
                    while(channel.write(buffer) > 0) {
                        //do something
                    }
                }
                this.channel.close();
            } catch (Exception e) {

            }
        }
    }
}
