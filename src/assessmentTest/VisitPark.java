// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 00 - Assessment Test
 *
 *    Thema: - 0.0 - get your Score evaluated
 *
 *  Listing: - 0.0.15 - VisitPark.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

// import:

package assessmentTest;

public class VisitPark {
    enum AnimalsInPark {
        SQUIRREL, CHIPMUNK, SPARROW;
    }

    public static void main(String[] args) {
        AnimalsInPark[] animals = AnimalsInPark.values();
        System.out.println(animals[1]);
    }
}