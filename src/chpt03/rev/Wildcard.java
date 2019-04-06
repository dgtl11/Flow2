// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 03 - Generics & Collections
 *
 *    Thema: - 3.8 - Review Questions
 *
 *  Listing: - 3.8.57 - Wildcard.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt03.rev;


import java.io.IOException;
import java.util.*;

public class Wildcard {
    public void showSize(List<?> list) {
        System.out.println(list.size());
    }
    public static void main(String[] args) {
        Wildcard card = new Wildcard();
        ArrayDeque<?> list = new ArrayDeque<String>();
        ArrayList<? super Date> list2 = new ArrayList<Date>();
        // List<?> list3 = new ArrayList<?>();
        //List<Exception> list4 = new LinkedList<IOException>();
        Vector<? extends Number> list5 = new Vector<Integer>();
        card.showSize((List<?>) list);
    }
}




