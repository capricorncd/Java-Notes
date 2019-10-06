package file.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class RandomAccessFileDemo {

	public static void main(String[] args) throws IOException {
		File demo = new File("D:\\java\\demo");
		if (!demo.exists()) {
			demo.mkdir();
		}
		File file = new File(demo, "raf.dat");
		if (!file.exists()) {
			file.createNewFile();
		}
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		// 指针的位置
		System.out.println(raf.getFilePointer());
		// write方法每次只能写一个字节
		raf.write('A');
		System.out.println(raf.getFilePointer());
		raf.write('B');
		
		int num = 0x7fffffff;
		// write方法每次只能写一个字节，如果把num写进去就的写4次
		raf.write(num >>> 24);
		raf.write(num >>> 16);
		raf.write(num >>> 8);
		raf.write(num);
		
		//可以直接写入一个int
		raf.writeInt(num);
		
		String s = "中";
		byte[] gbk = s.getBytes("GBK");
		raf.write(gbk);
		System.out.println(raf.length());
		
		// 读文件，把指针移到头部
		raf.seek(0);
		//一次性读取，把文件中的内容，读取到字节数组中
		byte[] buf = new byte[(int)raf.length()];
		raf.read(buf);
		
		System.out.println(Arrays.toString(buf));
		for (byte b : buf) {
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}
		raf.close();
	}

}
