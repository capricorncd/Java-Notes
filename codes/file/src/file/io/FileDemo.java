package file.io;

import java.io.File;
import java.io.IOException;

public class FileDemo {

	public static void main(String[] args) {
		// 了解构造函数的情况
		File file = new File("D:\\java\\test");
		System.out.println("文件是否存在：" + (file.exists() ? "是" : "否"));
		// 不存在文件（目录）创建
		if (!file.exists()) {
			file.mkdir();
			// 多级目录创建
			//file.mkdirs();
		} else {
			file.delete();
		}
		// 是目录或目录存在返回true，否则返回false
		System.out.println("是否为目录：" + file.isDirectory());
		System.out.println("是否为文件：" + file.isFile());
		System.out.println();
		
//		File file2 = new File("D:\\java\\test.txt");
		File file2 = new File("D:\\java", "test.txt");
		if (!file2.exists()) {
			try {
				file2.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			file2.delete();
		}
		
		System.out.println(file);//D:\java\test
		System.out.println(file.getAbsolutePath());//D:\java\test
		System.out.println(file.getParent());//D:\java
		System.out.println(file.getName());//test
		System.out.println();
		
		System.out.println(file2.getParent());//D:\java
		System.out.println(file2.getName()); //test.txt
	}

}
