package chpt08.ios;

import java.io.*;

public class File8 {
    public static void main(String[] args) {
	try {
		//
	 	// FileWriter 
		// ----------------------------------------------------------------------------------------
		// Stream-Objekt meinFW vom Typ FileWriter wird deklariert, um auf eine Datei zu schreiben.
		//
		FileWriter	meinFW = new FileWriter("Dateiname_FW.txt");
                meinFW.write("TEST: >>> Zum Start aus meinFW <<<\n");
		//
		// BufferedWriter 
		// ----------------------------------------------------------------------------------------
		// Stream-Objekt meinBW vom Typ BufferedWriter wird deklariert, da mit meinFW nicht direkt
		// auf die Datei "Dateinname_FW.txt" von meinFW geschrieben werden soll sondern über einen
		// Puffer dieses erfolgen soll. Nur wird in diesem Fall auch nicht über meinBW auf die Datei
		// geschrieben sondern ein spezieller Writer definiert.
		//
		BufferedWriter	meinBW = new BufferedWriter(meinFW);
                meinBW.write("TEST: !!! Hallo aus meinBW !!!\n");
		//
		// PrintWriter 
		// ----------------------------------------------------------------------------------------
		// Stream-Objekt meinPW vom Typ PrintWriter wird deklariert, da mit meinFW über meinBW nicht
		// direkt auf die Datei "Dateinname_FW.txt" von meinFW geschrieben werden soll sondern über
		// einen PrintWriter dieses erfolgen soll. 
		//
		PrintWriter meinPW = new PrintWriter(meinBW);
		//
		meinPW.print("### Auch meinPW," + "\n" + "arbeitet perfekt. ###"+"\n\n"+"!!! und beendet alle geöffneten Streams genau jetzt!!! ");
                meinPW.close();
                //
                // Mit meinPW.close() werden auch alle darunter liegenden Streams geschlossen.
                //
	}
	catch (IOException e) {
		System.out.println("Fehler beim erstellen der Datei");
        }
    }
}
