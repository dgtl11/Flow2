// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 08 - IO
 *
 *    Thema: - 08.8 - ets Review
 *
 *  Listing: - 08.8.20 - Liner.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt08.rev;

import java.io.*;

public class Liner {

    public void dumper(File f) throws IOException {
        FileReader x1 = new FileReader(f);
        BufferedReader x2 = new BufferedReader(x1);
        String x3 = x2.readLine();
        while(x3 != null) {
            System.out.println(x3);
            x3 = x2.readLine();
        }
    }
}