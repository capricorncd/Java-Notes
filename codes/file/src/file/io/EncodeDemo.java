package file.io;

import java.io.UnsupportedEncodingException;

public class EncodeDemo {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String s = "您好世界ABC";
		
		/**
		 * 字符串转byte[]
		 */
		// 转换成字节码序列用的是项目默认的编码GBK，中文占两个字节
		byte[] bytes1 = s.getBytes();
		for (byte b : bytes1) {
			// 把字节（转换错了int）以16进制的方式显示
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}
		// 结果：c4 fa ba c3 ca c0 bd e7 41 42 43 
		System.out.println("");
		
		byte[] bytes2 = s.getBytes("GBK");
		for (byte b : bytes2) {
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}
		// 结果：c4 fa ba c3 ca c0 bd e7 41 42 43 
		// GBK编码中文占2个字节，英文占1个字节
		System.out.println("");
		
		// utf-8
		byte[] bytes3 = s.getBytes("utf-8");
		for (byte b : bytes3) {
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}
		// 结果：e6 82 a8 e5 a5 bd e4 b8 96 e7 95 8c 41 42 43 
		// utf-8编码中文占3个字节，英文占1个字节
		System.out.println("");
		
		// Java是双字节编码utf-16be
		byte[] bytes4 = s.getBytes("utf-16be");
		for (byte b : bytes4) {
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}
		// 结果：60 a8 59 7d 4e 16 75 4c 0 41 0 42 0 43 
		// utf-16be中文占2个字节，英文占用2个字节
		System.out.println("");
		
		/**
		 * byte[]转字符串
		 * 当字节序列为某种编码时，这个时候想把字节序列变成字符串，
		 * 也需要用这种编码方式，否则会出现乱码
		 */
		// 用项目默认的编码
		String str1 = new String(bytes1);
		System.out.println(str1);
		String str2 = new String(bytes2, "GBK");
		System.out.println(str2);
		String str3 = new String(bytes3, "utf-8");
		System.out.println(str3);
		String str4 = new String(bytes4, "utf-16be");
		System.out.println(str4);
		
		/**
		 * 文本文件 就是字节序列，
		 * 其可以使任意编码的字节序列
		 * *在中文机器上直接创建文本文件，该文件只认识ansi编码
		 */
	}

}
