// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 03 - Generics & Collections
 *
 *    Thema: - 3.8 - Review Questions
 *
 *  Listing: - 3.8.55 - TestClass2.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt03.rev;


import java.util.*;

public class TestClass2 {

    public <E extends CharSequence> Collection <E> getWordsStartingWith(Collection<E> input, char ch) {
        Collection<E> returnValue = new ArrayList<E>();
        int len = input.size();
        for(E e : input) {
            if(e.charAt(0) == ch) returnValue.add(e);
        }
        return returnValue;
    }

    public void checkIt() {
        List<String> a = new ArrayList<String>();
        a.add("apple"); a.add("cherry");
        Set<StringBuffer> b = new HashSet<StringBuffer>();
        b.add(new StringBuffer("pineapple"));
        Collection<String> ac = getWordsStartingWith(a, 'a');
        Collection<StringBuffer> bc = getWordsStartingWith(b, 'b');
    }

}
