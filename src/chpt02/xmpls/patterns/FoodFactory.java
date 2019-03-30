// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 02 - Design Patterns & Principles
 *
 *    Thema: - 2.5 - working with design patterns
 *             2.5.4 - factory pattern
 *
 *  Listing: - 2.5.13 - FoodFactory.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt02.xmpls.patterns;

public class FoodFactory {
    public static Food getFood(String animalName) {
        switch(animalName) {
            case "zebra": return new Hay(100);
            case "rabbit": return new Pellets(5);
            case "goat": return new Pellets(30);
            case "polar bear": return new Fish(10);
        }

        // Good practice to throw an exception if no matching subclass could be found
        throw new UnsupportedOperationException("Unsupported animal: "+animalName);
    }
}


