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
 * test result:
 * cost:3->3707464716
	cost:11->3707464716
	cost:6->3707464716
	cost:1->3707464716
 * @author Administrator
 *
 */
public class CRCTest {
	
	public static long chechsumInputStream(Path fileName) throws Exception{
		try(InputStream inputStream = Files.newInputStream(fileName)){
			CRC32 crc = new CRC32();
			int c;
			while( (c = inputStream.read()) != -1) {
				crc.update(c);
			}
			return crc.getValue();
		}
	}
	
	public static long checksumBufferedInputStream(Path fileName) throws Exception{
		try(InputStream inputStream = new BufferedInputStream(Files.newInputStream(fileName))){
			CRC32 crc = new CRC32();
			int c;
			while( (c = inputStream.read()) != -1) {
				crc.update(c);
			}
			return crc.getValue();
		}
	}
	
	public static long checksumRandomAccessFile(Path fileName) throws Exception {
		try(RandomAccessFile file = new RandomAccessFile(fileName.toFile(), "r")){
			long length = file.length();
			CRC32 crc = new CRC32();
			for(long p = 0;p<length;p++) {
				file.seek(p);
				int c = file.readByte();
				crc.update(c);
			}
			return crc.getValue();
		}
	}
	
	public static long chechsumMappedFile(Path fileName) throws Exception{
		try(FileChannel channel = FileChannel.open(fileName)){
			CRC32 crc32 = new CRC32();
			int length = (int)channel.size();
			MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, length);
			for(int p = 0;p<length;p++) {
				int c = buffer.get(p);
				crc32.update(c);
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
