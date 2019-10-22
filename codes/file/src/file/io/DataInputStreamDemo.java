package file.io;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DataInputStreamDemo {

	public static void main(String[] args) throws IOException {
		String filePath = "D:\\java\\temp\\dos.dat";
		IOUtils.printHex(filePath);
		System.out.println("\n");
		
		FileInputStream inputFile = new FileInputStream(filePath);
		DataInputStream dis = new DataInputStream(inputFile);
		
		// read
		int i = dis.readInt();
		System.out.println(i);
		i = dis.readInt();
		System.out.println(i);
		
		long l = dis.readLong();
		System.out.println(l);
		
		double d = dis.readDouble();
		System.out.println(d);
		
		String s = dis.readUTF();
		System.out.println(s);
		
		dis.close();
	}

}
