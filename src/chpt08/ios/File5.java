package chpt08.ios;

import java.io.*;

public class File5 {
        public static void main(String[] args) throws IOException {

                File existingDir = new File("existing.dir");
                System.out.println(existingDir.isDirectory());

                if (existingDir.isDirectory()) {
                        File existingDirFile = new File(existingDir, "existingDirFile.txt");
                        if (existingDir.isFile()) {
                                FileReader fr = new FileReader(existingDirFile);
                                BufferedReader br = new BufferedReader(fr);

                                String s;

                                while ((s = br.readLine()) != null) System.out.println(s);

                                br.close();
                        } else {
                                System.out.println("Datei ist nicht vorhanden");
                        }
                } else {
                        System.out.println("Verzeichnis und Datei ist nicht vorhanden");

                }
        }
}