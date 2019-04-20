// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 08 - IO
 *
 *    Thema: - 08.1 - Understanding Files and Directories
 *
 *  Listing: - 08.1.01 - FileSample.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt08.xmpls.fileSystem;

import java.io.File;

public class FileSample {
    public static void main(String[] args) {
        File file = new File("/home/smith/data/zoo.txt");
        System.out.println(file.exists());

        // put out the seperator
        System.out.println(System.getProperty("file.separator"));
        System.out.println(java.io.File.separator);
    }
}