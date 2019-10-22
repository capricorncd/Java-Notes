package file.io;

import java.io.IOException;

public class IOUtilsTest {
	
	private static final String FILE_PATH = "D:\\java\\test.txt";

	public static void main(String[] args) {
		try {
			IOUtils.printHex(FILE_PATH);
			System.out.println("\n");
			
			IOUtils.printHexByByteArray(FILE_PATH);
			System.out.println("\n");
			
			IOUtils.printHexByByteArray2(FILE_PATH);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
