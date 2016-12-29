package tingo.core.nio2;

import java.nio.file.*;

/**
 * Created by tengfei on 2016/12/28.
 */
public class Nio2Test {
    public static void main(String[] args) {

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
}
