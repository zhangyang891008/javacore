package v2.chapter2;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.CRC32;
/**
 * compute CRC in four ways
 * 
 
 * @author Administrator
 *
 */
public class CRCTest_2 {
	private static int BUFFER_SIZE=1024;
	
	public static long chechsumInputStream(Path fileName) throws Exception{
		try(InputStream inputStream = Files.newInputStream(fileName)){
			CRC32 crc = new CRC32();
			byte[] bytes = new byte[BUFFER_SIZE];
			int c;
			while( (c = inputStream.read(bytes)) != -1) {
				//crc.update(c);
				crc.update(bytes, 0, c);
			}
			return crc.getValue();
		}
	}
	
	public static long checksumBufferedInputStream(Path fileName) throws Exception{
		try(InputStream inputStream = new BufferedInputStream(Files.newInputStream(fileName))){
			CRC32 crc = new CRC32();
			int c;
			byte[] bytes = new byte[BUFFER_SIZE];
			while( (c = inputStream.read(bytes)) != -1) {
				crc.update(bytes, 0 ,c);
			}
			return crc.getValue();
		}
	}
	
	public static long checksumRandomAccessFile(Path fileName) throws Exception {
		try(RandomAccessFile file = new RandomAccessFile(fileName.toFile(), "r")){
			long length = file.length();
			CRC32 crc = new CRC32();
			
			byte[] bytes = new byte[BUFFER_SIZE];
			for(long p = 0;p<length;p+=BUFFER_SIZE) {
				file.seek(p);
				int c = file.read(bytes);
				crc.update(bytes,0,c);
			}
			return crc.getValue();
		}
	}
	
	public static long chechsumMappedFile(Path fileName) throws Exception{
		try(FileChannel channel = FileChannel.open(fileName)){
			CRC32 crc32 = new CRC32();
			int length = (int)channel.size();
			MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, length);
			byte[] bytes = new byte[BUFFER_SIZE];
			for(int p = 0;p<length;p+=BUFFER_SIZE) {
				//int c = buffer.get(p);
				int c = Math.min(BUFFER_SIZE, length-p);
				buffer.get(bytes, 0, c);
				crc32.update(bytes,0,c);
			}
			
			return crc32.getValue();
		}
	}
	
	public static void main(String[] args) {
		Path myfilePath = Paths.get("D:/", "EmployeeTest.java");
		long ret;
		try {
			long start1 = System.currentTimeMillis();
			ret = checksumRandomAccessFile(myfilePath);
			System.out.println("cost:"+(System.currentTimeMillis()-start1)+"->"+ret);
			
			long start2 = System.currentTimeMillis();
			ret = checksumBufferedInputStream(myfilePath);
			System.out.println("cost:"+(System.currentTimeMillis()-start2)+"->"+ret);
			
			
			long start3 = System.currentTimeMillis();
			long ret2 = chechsumInputStream(myfilePath);
			System.out.println("cost:"+(System.currentTimeMillis()-start3)+"->"+ret2);
			
			long start4 = System.currentTimeMillis();
			long retMapped = chechsumMappedFile(myfilePath);
			System.out.println("cost:"+(System.currentTimeMillis()-start4)+"->"+retMapped);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
