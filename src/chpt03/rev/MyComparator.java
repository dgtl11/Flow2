// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 03 - Generics & Collections
 *
 *    Thema: - 3.8 - Review Questions
 *
 *  Listing: - 3.8.55 - MyComparator.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt03.rev;

import java.util.Arrays;
import java.util.Comparator;

public class MyComparator implements Comparator<String> {

    public int compare(String a, String b) {
        return b.toLowerCase().compareTo(a.toLowerCase());
    }
    public static void main(String[] args) {
        String[] values = { "123", "Abb", "aab" };
        Arrays.sort(values, new MyComparator());
        for (String s: values)
            System.out.print(s + " ");
    }

}

// --> Abb aab 123