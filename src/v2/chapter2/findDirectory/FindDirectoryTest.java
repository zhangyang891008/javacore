package v2.chapter2.findDirectory;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.stream.Stream;

public class FindDirectoryTest {
	
	public static void main(String[] args) throws Exception {
		Path dir = Paths.get("F:/walkFile");
		Files.walkFileTree(dir, new SimpleFileVisitor<Path>() {

			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
				if(attrs.isDirectory())
					return FileVisitResult.CONTINUE;
				System.out.println("visit:"+file.toAbsolutePath());
				return super.visitFile(file, attrs);
			}
			
		});
		
		System.out.println("***list***");
		
		try(Stream<Path> filesStream = Files.list(dir)) {
			filesStream.peek(path->{System.out.println(path);}).count();
		} catch (Exception e) {
			 e.printStackTrace();
		}
		
		
		System.out.println("***walk***");
		try(Stream<Path> filesStream = Files.walk(dir)) {
			filesStream.peek(path->{System.out.println(path);}).count();
		} catch (Exception e) {
			 e.printStackTrace();
		}
		
		System.out.println("***walk with links***");
		try(Stream<Path> filesStream = Files.walk(dir, FileVisitOption.FOLLOW_LINKS)) {
			filesStream.peek(path->{System.out.println(path);}).count();
		} catch (Exception e) {
			 e.printStackTrace();
		}

	}

}
