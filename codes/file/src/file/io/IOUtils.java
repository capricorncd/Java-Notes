package file.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOUtils {
	private static final int LINE_NUM = 10; 
	/**
	 * 读取指定文件内容，按照16进制输出到控制台
	 * 并且每输出10个byte换行
	 * @param fileName
	 * @throws IOException 
	 */
	public static void printHex(String fileName) throws IOException {
		// 把文件作为字节流进行读取操作
		FileInputStream in = new FileInputStream(fileName);
		int b;
		int count = 1;
		while((b = in.read()) != -1) {
			print(b, count++);
		}
		in.close();
	}
	
	/**
	 * printHexByByteArray
	 * @param fileName
	 * @throws IOException
	 */
	public static void printHexByByteArray(String fileName) throws IOException {
		File file = new File(fileName);
		FileInputStream in = new FileInputStream(file);
		byte[] buf = new byte[(int)file.length()];
		// 从in中排量读取字节，放入到buffer这个字节数组中
		// 从第0个位置开始放，最多放buf.length个
		// 返回的是读到的字节的个数
		int bytes = in.read(buf, 0, buf.length);
		int count = 1;
		for (int i = 0; i < bytes; i++) {
			print(buf[i], count++);
		}
		in.close();
	}
	
	/**
	 * printHexByByteArray2
	 * @param fileName
	 * @throws IOException
	 */
	public static void printHexByByteArray2(String fileName) throws IOException {
		File file = new File(fileName);
		FileInputStream in = new FileInputStream(file);
		byte[] buf = new byte[(int)file.length()];
		int count = 1;
		int bytes = 0;
		while((bytes = in.read(buf, 0, buf.length)) != -1) {
			for (int i = 0; i < bytes; i++) {
				print(buf[i], count++);
			}
		}
		in.close();
	}
	
	/**
	 * print
	 * @param b
	 * @param count
	 */
	private static void print(int b, int count) {
		// 单位数前补0，及小于10的数
		if (b >= 0x0 && b <= 0xf) {
			System.out.print("0");
		}
		// & 0xff：byte类型8位，int类型32位，
		// 为了避免数据转换错误，通过&0xff将高24位清零
		System.out.print(Integer.toHexString(b & 0xff) + " ");
		if (count % LINE_NUM == 0) {
			System.out.println();
		}
	}
	
	/**
	 * file copy
	 * @param srcFile
	 * @param destFile
	 * @throws IOException
	 */
	public static void fileCopy(File srcFile, File destFile) throws IOException {
		if (!srcFile.exists()) {
			throw new IllegalArgumentException("文件不存在。" + srcFile);
		}
		if (!srcFile.isFile()) {
			throw new IllegalArgumentException("非文件对象。" + srcFile);
		}
		FileInputStream in = new FileInputStream(srcFile);
		FileOutputStream out = new FileOutputStream(destFile);
		byte[] buffers = new byte[(int)srcFile.length()];
		int n;
		while((n = in.read(buffers, 0, buffers.length)) != -1) {
			out.write(buffers, 0, n);
			out.flush();
		}
		in.close();
		out.close();
	}
}
