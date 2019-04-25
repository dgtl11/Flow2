package chpt09.xmpls.attributes;

import java.io.IOException;
import java.nio.file.*;

public class workgroup_nio {
    public static void main(String[] args) throws IOException {


        Path source = Paths.get("temp/quellen.txt");  // ist vorhanden
        Path target = Paths.get("temp/neu.txt");      // zur Zeit nicht 
        Path second = Paths.get("temp/ziel.txt");     // das Spiel kann beginnen 
        
        Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);                   // zwei Kopien von der gleichen Datei
        Files.delete(target);                         // zurück zu einer Kopie
        Files.move(source, target);                   // da waren es nur noch eins
    }
}