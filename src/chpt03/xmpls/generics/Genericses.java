// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 02 - Generics & Collections
 *
 *    Thema: - 2.2 - Working with Generics
 *
 *  Listing: - 2.2.02 - Genericses.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt03.xmpls.generics;

import java.util.ArrayList;
import java.util.List;

public class Genericses {

    static void printNames(List list) {
        for (int i = 0; i < list.size(); i++) {
            String name = (String) list.get(i); // class cast exception here
            System.out.println(name);
            }
        }

    public static void main(String[] args) {

        List names = new ArrayList();
        names.add(new StringBuilder("Webby"));
        printNames(names);

        List<String> names2 = new ArrayList<String>();
        // names2.add(new StringBuilder("Webby")); // DOES NOT COMPILE

    }
}