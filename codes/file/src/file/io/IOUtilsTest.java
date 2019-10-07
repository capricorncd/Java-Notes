package file.io;

import java.io.IOException;

public class IOUtilsTest {

	public static void main(String[] args) {
		try {
			String filePath = "D:\\java\\test.txt";
			IOUtils.printHex(filePath);
			System.out.println("\n");
			IOUtils.printHexByByteArray(filePath);
			System.out.println("\n");
			IOUtils.printHexByByteArray2(filePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
