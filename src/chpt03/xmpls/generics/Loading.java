// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 02 - Generics & Collections
 *
 *    Thema: - 2.2 - Working with Generics
 *             2.2.1 - Generic Classes
 *
 *  Listing: - 2.2.05 - Loading.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt03.xmpls.generics;


public class Loading {
    public static void main(String[] args) {

        // normal loading
        Loading elephant = new Loading();
        Crate<Loading> crateForElephant = new Crate<>();
        crateForElephant.packCrate(elephant);
        Loading inNewHome = crateForElephant.emptyCrate();

        // Crate<Zebra> crateForZebra = new Crate<>();

        // Robot joeBot = new Robot();
        // Crate<Robot> robotCrate = new Crate<>();
        // robotCrate.packCrate(joeBot);
        // // ship to St. Louis
        // Robot atDestination = robotCrate.emptyCrate();



        // limited size loading
        Elephant elephant2 = new Elephant();
        Integer numPounds = 15_000;
        SizeLimitedCrate<Elephant, Integer> c1 = new SizeLimitedCrate<>(elephant2,
                numPounds);
    }
}
