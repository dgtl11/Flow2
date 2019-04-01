// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 00 - Assessment Test
 *
 *    Thema: - 0.0 - get your Score evaluated
 *
 *  Listing: - 0.0.05 - TC05.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

// import:

package assessmentTest;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;

public class TC05 {
    public static void main(String[] args) {
        List<Integer> source = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> fish = new CopyOnWriteArrayList<>(source);
        List<Integer> mammals = Collections.synchronizedList(source);
        Set<Integer> birds = new ConcurrentSkipListSet<>();
        birds.addAll(source);
        synchronized (new Integer(10)) {
            for (Integer f : fish) fish.add(4); // c1
            for (Integer m : mammals) mammals.add(4); // c2
            for (Integer b : birds) birds.add(5); // c3
            System.out.println(fish.size() + " " + mammals.size() + " " + birds.size());

        }
    }
}