package file.io;

import java.io.File;
import java.io.IOException;

public class FileUtilsTest {

	public static void main(String[] args) throws IOException {
		FileUtils.printListDirectory(new File("D:\\java"), true);
	}

}
