package v2.chapter2.findDirectory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 拷贝文件，但是不能删除文件
 */
public class CopyFilesTest {
	
	public static void main(String[] args) throws Exception {
		Path copyPath = Paths.get("F:/copyFile");
		Path sourcePath = Paths.get("F:/walkFile");

		Files.walk(sourcePath).forEach(p->{
			try {
				Path q = copyPath.resolve(sourcePath.relativize(p));
				System.out.println(q.toAbsolutePath());
				if(!Files.exists(q)) {
					if(Files.isDirectory(q)) {
						Files.createDirectory(q);
					}else {
						Files.copy(p, q);
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}

}
