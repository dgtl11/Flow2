// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 01 - Advanced Class Design
 *
 *    Thema: - 1.10 - Review Questions
 *
 *  Listing: - 1.10.35 - IsItFurry2.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

// import:

package chpt01.rev;


import java.util.*;

public class IsItFurry2 {
    static class Chipmunk { }
    public static void main(String[] args) {
        Chipmunk c = new Chipmunk();
        ArrayList <Chipmunk> l = new ArrayList<>();
        Runnable r = new Thread();
        int result = 0;
        if (c instanceof Chipmunk) result += 1;
        // if (l instanceof Chipmunk) result += 2;      // does not compile
        if (r instanceof Chipmunk) result += 4;
        System.out.println(result);
    }
}

