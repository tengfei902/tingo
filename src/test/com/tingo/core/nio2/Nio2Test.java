package tingo.core.nio2;

import java.io.File;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by user on 16/12/28.
 */
public class Nio2Test {

    public static void main(String[] args) {

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
        Path path = Paths.get("");
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
        for (String view : set) {
            System.out.println(view);
        }

        Path path = Paths.get("path url", "fileName");
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

        Files.getAttribute(path, "basic:size", LinkOption.NOFOLLOW_LINKS);

        //update view attribute
        Files.setLastModifiedTime(path, FileTime.from(1000L, TimeUnit.MINUTES));
    }

    public void testLink() throws Exception {
        Path resource = Paths.get("");
        Path target = Paths.get("");
        Files.createSymbolicLink(resource,target);

        Path link = Paths.get("");
        Path existing = Paths.get("");
        Files.createLink(link,existing);

        Path file = Paths.get("");
        Files.isSymbolicLink(file);

        Path linkFile = Paths.get("");
        Path actualPath = Files.readSymbolicLink(linkFile);
    }

    public void testCheckFileDir() throws Exception {
        Path path = Paths.get("");
        Files.exists(path);

        Files.notExists(path);

        Files.isReadable(path);

        Files.isWritable(path);

        Files.isExecutable(path);

        Files.isRegularFile(path);

        Path path2 = Paths.get("");
        Files.isSameFile(path,path2);

        Files.isHidden(path);

        Iterable<Path> iterable = FileSystems.getDefault().getRootDirectories();
        for(Path dir:iterable) {
            System.out.println(dir);
        }

        Path newdir = FileSystems.getDefault().getPath("");
        Files.createDirectory(newdir);

        Path newdirs = FileSystems.getDefault().getPath("","","");
        Files.createDirectories(newdirs);

        Path path3 = Paths.get("");
        DirectoryStream<Path> ds = Files.newDirectoryStream(path3);
        for(Path path1:ds) {
            System.out.println(path1);
        }

        Path newFile = FileSystems.getDefault().getPath("");
        Files.createFile(newFile);
        byte[] ball_bytes = new byte[10];
        Files.write(newFile,ball_bytes);

        Files.readAllBytes(newFile);
    }

    public void testFileVisitor() throws Exception{
        Path path = Paths.get("");
        Files.walkFileTree(path,new ListTree());
    }
}

class ListTree extends SimpleFileVisitor<Path> {

}
