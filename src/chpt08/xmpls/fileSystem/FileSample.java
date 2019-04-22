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

        // plattform independend file.separator    [  \ on win    / on linux  ]
        System.out.println(System.getProperty("file.separator"));
        System.out.println(java.io.File.separator);


        // File file = new File("/home/smith/data/zoo.txt");        // absolut path     // relative:   data/zoo.txt
        File file = new File("/home/dani/develop/IdeaProjects/Flow2/zoo.txt");
        System.out.println(file.exists());

        File parent = new File("/home/dani/develop/IdeaProjects");
        File child = new File(parent,"Flow2/zoo.txt");



    }
}