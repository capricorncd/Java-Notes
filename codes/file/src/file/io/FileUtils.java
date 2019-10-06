package file.io;

import java.io.File;
import java.io.IOException;

/**
 * 实现File的一些常用操作，比如过滤、遍历等
 * @author capricorncd
 *
 */
public class FileUtils {	
	/**
	 * 列出指定目录下的所有文件及子文件夹（包含其子目录）
	 * @param dir
	 * @param deep
	 */
	public static void printListDirectory(File dir, boolean deep) throws IOException {
		if (!dir.exists()) {
			throw new IllegalArgumentException("目录不存在，" + dir);
		}
		if (!dir.isDirectory()) {
			throw new IllegalArgumentException(dir + ", 不是目录");
		}
		//返回目录下的所有文件或子目录，及子目录的所有文件及目录
		if (deep) {
			File[] files = dir.listFiles();
			if (files != null && files.length > 0) {
				for (File f : files) {
					if (f.isDirectory()) {
						printListDirectory(f, true);
					} else {
						System.out.println(f);
					}
				}
			}
		}
		//返回目录下的文件或子目录名称，不包含子目录下的内容
		else {
			String[] fileNames = dir.list();
			for (String str : fileNames) {
				System.out.println(dir + "\\" + str);
			}
		}
	}
}
