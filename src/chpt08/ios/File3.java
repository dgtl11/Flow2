package chpt08.ios;

import java.io.*;

class File3 {
	public static void main(String [] args) {
		byte[] in = new byte[50];	//bytes keine chars
		int size = 0;
		FileOutputStream fos = null;
		FileInputStream fis = null;
		File file = new File("Output\\DateiSchreiber3.txt");
		try {
			fos = new FileOutputStream(file);
			String s = "Hallo\nBenutzer\n";
			fos.write(s.getBytes("UTF-8"));
			fos.flush();
			fos.close();
			//
			fis = new FileInputStream(file);
			size = fis.read(in);
			System.out.print(size + "\n");
			for (byte b : in) {
				System.out.print((char)b);
			}
			fis.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}