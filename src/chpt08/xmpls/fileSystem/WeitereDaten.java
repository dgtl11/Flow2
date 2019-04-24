// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 08 - IO
 *
 *    Thema: - 08.1 - Understanding Files and Directories
 *
 *  Listing: - 08.1.03 - WeitereDaten.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt08.xmpls.fileSystem;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class WeitereDaten {
    public static void main(String[] args) {

        // File file = new File("/home/smith/data/zoo.txt");        // absolut path     // relative:   data/zoo.txt

        File file = new File("C:\\Users\\Student\\Documents\\IdeaProjects\\Flow2\\zoo.txt");  // SchulSystem

        // File file = new File("/home/dani/develop/IdeaProjects/Flow2/zoo.txt");                   // homeSystem

        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(new Date(file.lastModified()));
        System.out.println("letzte Anderung: ");
        System.out.println(
                cal.get(Calendar.DATE) + "." +
                        (cal.get(Calendar.MONTH)+1) + "." +
                        cal.get(Calendar.YEAR) + " " +
                        cal.get(Calendar.HOUR_OF_DAY) + ":" +
                        cal.get(Calendar.MINUTE) + ":" +
                        cal.get(Calendar.SECOND)
        );
    }
}