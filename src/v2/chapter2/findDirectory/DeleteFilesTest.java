package v2.chapter2.findDirectory;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class DeleteFilesTest {
	
	public static void main(String[] args) throws IOException {
		Files.walkFileTree(Paths.get("F:/copyFile"), new SimpleFileVisitor<Path>() {

			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
				Files.delete(file);
				System.out.println("delete file:"+file.toAbsolutePath());
				return FileVisitResult.CONTINUE;
			}

			@Override
			public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
				if(exc!=null) throw exc;
				Files.delete(dir);
				System.out.println("delete dir:"+dir.toAbsolutePath());
				return FileVisitResult.CONTINUE;
			}
			
		});
	}

}
