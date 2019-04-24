package chpt08.ios;

import java.io.*;
import java.util.*;

public class ErstelleDatei {
    
    public static void main( String[] args) throws IOException { 
        //
        char[] in = new char[80];
        int groesse = 0;
        //
        File meinDir = new File("Daten");
        meinDir.mkdir();
	//
	// Erste Möglickeit: neues File erstellen
	//
	File meinFile1 = new File(meinDir, "meineDaten_1.txt");
	meinFile1.createNewFile();
	//
	// Zweite Möglickeit: neues File erstellen
	//
	File meinFile2 = new File(meinDir, "meineDaten_2.txt");
        GregorianCalendar cal = new GregorianCalendar();
        PrintWriter pw = new PrintWriter(meinFile2);
        pw.println("Absolut Path :         " + meinFile2.getAbsolutePath());
        pw.println("Is Directory :         " + meinFile2.isDirectory());
        pw.println("Parent Path  :         " + meinFile2.getParent());
        //
        cal.setTime(new Date(meinFile2.lastModified()));
        pw.println("Letzte Änderung: " +
                    cal.get(Calendar.DATE) + "." +
                    (cal.get(Calendar.MONTH)+1) + "." +
                    cal.get(Calendar.YEAR) + " " +
                    cal.get(Calendar.HOUR_OF_DAY) + ":" +
                    cal.get(Calendar.MINUTE) + ":" +
                    cal.get(Calendar.SECOND)
         );
        //
        pw.flush();
        pw.close();
        //
        // Ausgabe von meineDaten_2.txt
        //
        FileReader fr = new FileReader("Daten\\meineDaten_2.txt");
	groesse = fr.read(in);
	System.out.print("Anzahl der Zeichen: " + groesse + "\n");
	for(char c : in)
		System.out.print(c);
	fr.close();
    }
}