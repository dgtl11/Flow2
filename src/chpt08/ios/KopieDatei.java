package chpt08.ios;

import java.io.*;

public class KopieDatei {
    public static void copy(File source, File destination) throws IOException {
        try (InputStream in = new FileInputStream( source);
            OutputStream out = new FileOutputStream( destination)) {
              int b;
              while(( b = in.read()) != -1) {
                  out.write( b); 
              } 
            } 
        } 
    
    public static void main( String[] args) throws IOException { 
        File source = new File("C:\\Users\\User\\Documents\\Writer1\\src\\ReadFileInformation.java");
        File destination = new File("C:\\Users\\User\\Documents\\Writer1\\src\\ReadFileInformation.bak");
        copy( source, destination);
    }
}
