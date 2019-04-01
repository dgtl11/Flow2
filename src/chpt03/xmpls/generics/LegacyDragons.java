// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 02 - Generics & Collections
 *
 *    Thema: - 2.2 - Working with Generics
 *             2.2.4 - interacting with Legacy Code
 *
 *  Listing: - 2.2.09 - LegacyDragons.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt03.xmpls.generics;


import java.util.ArrayList;
import java.util.List;

class Dragon {}
class Unicorn { }

public class LegacyDragons {

    public static void main(String[] args) {
        List unicorns = new ArrayList();
        unicorns.add(new Unicorn());
        printDragons(unicorns);
    }
    private static void printDragons(List<Dragon> dragons) {
        for (Dragon dragon: dragons) { // ClassCastException
            System.out.println(dragon);
        } }
}

