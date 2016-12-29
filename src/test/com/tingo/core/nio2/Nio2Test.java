package tingo.core.nio2;

import java.io.File;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by user on 16/12/28.
 */
public class Nio2Test {
    public static void main(String[] args) {
        new Nio2Test().testMetadata();
    }

    public void testCopyFile() throws Exception {
        File source = new File("");
        File target = new File("");
        Files.copy(source.toPath(),target.toPath(), StandardCopyOption.COPY_ATTRIBUTES);
    }

    public void testDeletePath() throws Exception {
        Path path = Paths.get("");
        Files.delete(path);
    }

    public void testMoveFile() {

    }

    public void testWatch() {

    }

    public void testMetadata() throws Exception {
        //basic
        //dos
        //posix
        //owner
        //acl
        //user defined
        FileSystem fileSystem = FileSystems.getDefault();
        //当前系统可支持的view类型
        Set<String> set = fileSystem.supportedFileAttributeViews();
        for(String view:set) {
            System.out.println(view);
        }

        Path path = Paths.get("path url","fileName");
        //read basic view
        BasicFileAttributes basicView = Files.readAttributes(path, BasicFileAttributes.class);
        basicView.size();
        basicView.creationTime();
        basicView.fileKey();
        basicView.isDirectory();
        basicView.isOther();
        basicView.isRegularFile();
        basicView.isSymbolicLink();
        basicView.lastAccessTime();
        basicView.lastModifiedTime();

        Files.getAttribute(path,"basic:size",LinkOption.NOFOLLOW_LINKS);

        //update view attribute
        Files.setLastModifiedTime(path,FileTime.from(1000L,TimeUnit.MINUTES));
    }
}
