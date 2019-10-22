package file.io;

import java.io.IOException;
import java.io.File;
import java.io.FileOutputStream;

public class FileOutPutDemo {

	public static void main(String[] args) throws IOException {
		String filePath = "D:\\java\\temp\\out.dat";
		// 如果文件不存在，则直接创建；如果存在，删除后再创建
		// #若有第二个参数：true往文件里追加内容
		FileOutputStream out = new FileOutputStream(filePath);
		// 写出了A的低8位
		out.write('A');
		// 写出了B的低8位
		out.write('B');
		// write只能写8位，即写一个int需要写4次
		int a = 10;
		out.write(a >>> 24);
		out.write(a >>> 16);
		out.write(a >>> 8);
		out.write(a);
		
		byte[] gbk = "中国".getBytes("GBK");
		out.write(gbk);
		out.close();
		
		IOUtils.printHex(filePath);
		
		File destFile = new File("D:\\java\\temp\\copy.txt");
		
		IOUtils.fileCopy(new File(filePath), destFile);
	}

}
