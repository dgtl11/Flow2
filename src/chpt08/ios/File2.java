package chpt08.ios;

import java.io.*;

class File2 {
	public static void main(String [] args) {
		char[] in = new char[50];	//speichern der Eingabe
		int size = 0;
		try {
			File file = new File("Output\\DateiSchreiber2.txt");
			FileWriter fw = new FileWriter(file);
			fw.write("Hallo\nWelt\n");
			fw.flush();
			fw.close();
                        FileReader fr = new FileReader(file);
			size = fr.read(in);
			System.out.print(size + "\n");
			for(char c : in)
				System.out.print(c);
			fr.close();
		} catch(IOException e) { }
	}
}