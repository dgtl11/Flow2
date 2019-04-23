package chpt08.ios;

import java.io.*;
// Mit der File-Klasse können Sie nicht nur Dateien erstellen,
// sondern auch Dateien umbenennen und löschen. Der folgende Code
// zeigt einige der gebräuchlichsten Funktionen, wenn Sie Dateien
// und Verzeichnisse löschen (über delete ()) und Dateien und
// Verzeichnisse umbenennen (über renameTo ())

public class File6 {
	public static void main(String [] args) throws IOException {
            File delDir = new File("loeschVerzeichnis");
            delDir.mkdir();
            
            File delFile1 = new File(delDir,"delFile1.txt");
            delFile1.createNewFile();
            
            File delFile2 = new File(delDir,"delFile2.txt");
            delFile2.createNewFile();
            delFile1.delete();
            System.out.println("delDir is " + delDir.delete());
            
            File neueDatei = new File(delDir, "neueDatei.txt");
            delFile2.renameTo(neueDatei);
            
            File neuesVerzeichnis = new File("neuesVerzeichnis");
            delDir.renameTo(neuesVerzeichnis);
    }
}