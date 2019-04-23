package chpt08.ios;

import java.io.*;

class File1 {
	public static void main(String [] args) {
        try { 
            boolean newFile = false;
            File file = new File("Output\\DateiSchreiber1.txt");
            System.out.println(file.exists());
            newFile = file.createNewFile();
            System.out.println(newFile);
            System.out.println(file.exists());
            } catch (IOException e) { }
	}
}
