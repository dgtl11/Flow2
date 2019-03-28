// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 01 - Advanced Class Design
 *
 *    Thema: - 1.10 - Review Questions
 *
 *  Listing: - 1.10.38 - FourLegged.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

// import:

package chpt01.rev;

public class FourLegged {
    String walk = "walk,";
    static class BabyRhino extends FourLegged {
        String walk = "toddle,";
    }
    public static void main(String[] args) {
        FourLegged f = new BabyRhino();
        BabyRhino b = new BabyRhino();
        System.out.println(f.walk);
        System.out.println(b.walk);
    } }

// out = walk, toddle,