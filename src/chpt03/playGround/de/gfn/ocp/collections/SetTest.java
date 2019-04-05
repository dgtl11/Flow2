// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 03 - Generics & Collections
 *
 *    Thema: - 3.3 - Collections
 *
 *  Listing: - 3.3.12 - SetTest.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt03.playGround.de.gfn.ocp.collections;

import java.time.LocalDateTime;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.TreeSet;

public class SetTest {

    public static void main(String[] args) {

        NavigableSet<LocalDateTime> termine = new TreeSet<>();

        termine.add(LocalDateTime.of(2015,3,15,12,22));
        termine.add(LocalDateTime.of(2016,12,15,22,17));
        termine.add(LocalDateTime.of(2010,1,10,13,18));
        termine.add(LocalDateTime.of(2019,5,1,17,30));
        termine.add(LocalDateTime.of(2019,4,15,20,30));

        System.out.println(termine);

        // next
        System.out.println(termine.higher(LocalDateTime.now()));

        // last
        System.out.println(termine.lower(LocalDateTime.now()));

        // Element oder wenn nicht da, das davor
        System.out.println(termine.floor(LocalDateTime.of(2010,1,10,13,18)));

        // Element oder wenn nicht da, das danach
        System.out.println(termine.ceiling(LocalDateTime.of(2010,1,10,13,18)));


    }

}
