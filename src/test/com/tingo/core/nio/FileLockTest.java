package tingo.core.nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Random;

/**
 * Created by tengfei on 2016/12/24.
 */
public class FileLockTest {

    private Random rand = new Random();
    private static final int SIZEOF_INT = 4;
    private static final int INDEX_START = 0;
    private static final int INDEX_COUNT = 10;
    private static final int INDEX_SIZE = INDEX_COUNT * SIZEOF_INT;
    private ByteBuffer buffer = ByteBuffer.allocate(INDEX_SIZE);
    private IntBuffer indexBuffer = buffer.asIntBuffer();

    public static void main(String[] args) throws Exception {
        boolean writer = false;
        String filename = "";
        RandomAccessFile randomAccessFile = new RandomAccessFile(filename,"rw");
        FileChannel fileChannel = randomAccessFile.getChannel();
    }

    public void doQuery(FileChannel fileChannel) throws Exception {
        System.out.println("trying for shared lock");
        FileLock fileLock = fileChannel.lock(INDEX_START,INDEX_SIZE,true);
        int reps = rand.nextInt(60)+20;
        for(int i=0;i<reps;i++) {
            int n = rand.nextInt(INDEX_COUNT);
            int position = INDEX_START+(n*SIZEOF_INT);
            buffer.clear();
            fileChannel.read(buffer,position);
            int value = indexBuffer.get(n);
            System.out.println(value);
        }
        fileLock.release();
    }

    public void doUpdate(FileChannel fileChannel) throws Exception {
        System.out.println("trying for exclusive lock");
        FileLock fileLock = fileChannel.lock(INDEX_START,INDEX_SIZE,false);
        updateIndex(fileChannel);
        fileLock.release();
    }

    private int idxval = 1;

    private void updateIndex(FileChannel fileChannel) throws Exception {
        indexBuffer.clear();
        for(int i = 0;i < INDEX_COUNT; i++) {
            idxval++;
            System.out.println("updating index "+i+ "="+idxval);
            indexBuffer.put(idxval);
        }
        buffer.clear();
        fileChannel.write(buffer,INDEX_START);
    }
}
