package tingo.core.nio2;

import java.io.IOException;
import java.nio.file.*;

/**
 * Created by tengfei on 2016/12/29.
 */
public class WatchServiceTest {
    public static void main(String[] args) {

    }

    /**
     * 1.watchable object
     * 2.Event type
     * 3.Event modifier
     * 4.watcher
     */
    public void testWatch() throws IOException,InterruptedException {
        Path path = Paths.get("");
        WatchService watchService = FileSystems.getDefault().newWatchService();
        path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE,StandardWatchEventKinds.ENTRY_DELETE,StandardWatchEventKinds.ENTRY_MODIFY);
        while (true) {
            final WatchKey watchKey = watchService.take();
            for(WatchEvent watchEvent:watchKey.pollEvents()) {
                final WatchEvent.Kind kind = watchEvent.kind();
                if(kind == StandardWatchEventKinds.OVERFLOW) {
                    continue;
                }

                final WatchEvent<Path> watchEventPath = (WatchEvent<Path>)watchEvent;
                final Path filename = watchEventPath.context();
            }

            boolean valid = watchKey.reset();
            if(!valid) {
                break;
            }
        }
    }
}
