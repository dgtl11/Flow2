// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 08 - IO
 *
 *    Thema: - 08.1 - Understanding Files and Directories
 *
 *  Listing: - 08.1.02 - ReadFileInformation.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt08.xmpls.fileSystem;

import java.io.File;

public class ReadFileInformation {
    public static void main(String[] args) {

        // File file = new File("/home/smith/data/zoo.txt");        // absolut path     // relative:   data/zoo.txt

        File file = new File("C:\\Users\\Student\\Documents\\IdeaProjects\\Flow2\\zoo.txt");  // SchulSystem

        // File file = new File("/home/dani/develop/IdeaProjects/Flow2/zoo.txt");                   // homeSystem

        System.out.println("File Exists: " + file.exists());

        if(file.exists()) {
            System.out.println("Absolute Path: "+file.getAbsolutePath());
            System.out.println("Is Directory: "+file.isDirectory());
            System.out.println("Parent Path: "+file.getParent());
            if(file.isFile()) {
                System.out.println("File size: "+file.length());
                System.out.println("File LastModified: "+file.lastModified());
            } else {
                for(File subfile: file.listFiles()) {
                    System.out.println("\t"+subfile.getName());
                }
            }
        }
    }
}