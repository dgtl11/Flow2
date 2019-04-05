// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 04 - Built-In Functional Interfaces
 *
 *    Thema: - 4.1 - Using Variables in Lambdas
 *
 *  Listing: - 4.1.01 - GorillaFamily.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt04.xmpls;

interface Gorilla { String move(); }

public class GorillaFamily {

    String walk = "walk";
    void everyonePlay(boolean baby) {
        String approach = "amble";
        //approach = "run";

        play(() -> walk);
        play(() -> baby ? "hitch a ride" : "run");
        play(() -> approach);
    }

    void play(Gorilla g) {
        System.out.println(g.move());
    }
}