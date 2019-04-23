package chpt08.ios;

import java.io.*;

// throws wird sehr häufig im Zusammenhang mit Dateioperationen benötigt,
// da alle Dateioperationen eine IOException auslösen können. Jede Methode,
// die beispielsweise mit einer read-Methode etwas aus einem Stream lesen will,
// muss stets throws benutzen oder selbst auf die IOException reagieren.
// Dies mag anfangs mühselig erscheinen, jedoch ist dies ein vergleichsweise
// einfaches Verfahren, das gleichzeitig alle möglichen Fehler bei Ein- und
// Ausgabeoperationen abdeckt.

public class File4 {
	public static void main(String [] args) throws IOException {
        // File file = new File("Output\\DateiSchreiber4.txt");

        File myDir = new File("meinDir");
        myDir.mkdir();

        File meinedatei = new File(myDir, "muster.txt");
        meinedatei.createNewFile();

        FileWriter fw = new FileWriter(meinedatei);


        PrintWriter pw = new PrintWriter(fw);
            
        pw.println("Zeile 1");  // Daten schreiben
        pw.println("Zeile 2");

        pw.flush();
        pw.close();
            
	}
}
