package tingo.core.nio2;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by tengfei on 16/12/29.
 */
public class Search implements FileVisitor<Path> {

    private final Path searchedFile;
    public boolean found;

    public Search(Path searchedFile) {
        this.searchedFile = searchedFile;
        this.found = false;
    }

    public void search(Path file) throws IOException {
        Path name = file.getFileName();
        if(null != name && name.equals(searchedFile)) {
            System.out.println("searched file found,"+searchedFile+" in "+file.toRealPath().toString());
            this.found = true;
        }
    }

    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        return null;
    }

    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        search(file);
        if(!found) {
            return FileVisitResult.CONTINUE;
        }
        return FileVisitResult.TERMINATE;
    }

    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    public static void main(String[] agrs) throws Exception {
        Path searchFile = Paths.get("123.jpg");
        Search walk = new Search(searchFile);
        Path targetPath = FileSystems.getDefault().getPath("");
        walk.search(targetPath);
    }
}
