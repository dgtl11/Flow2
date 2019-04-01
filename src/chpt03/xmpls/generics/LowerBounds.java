// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 02 - Generics & Collections
 *
 *    Thema: - 2.2 - Working with Generics
 *             2.2.5 - Bounds
 *                   - Unbounded Wildcards
 *
 *  Listing: - 2.2.14 - LowerBounds.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt03.xmpls.generics;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LowerBounds {

    public static void addSound(List<? super String> list) { // lower bound
        list.add("quack");
    }

    public static void main(String[] args) {
        List<String> strings = new ArrayList<String>();
        strings.add("tweet");
        List<Object> objects = new ArrayList<Object>(strings);
        addSound(strings);      // geht erst nicht solange das Problem besteht
        addSound(objects);

        // The problem is that we want to pass a List<String> and a List<Object> to the same
        // method.

        // Understand Generic Supertypes
        List<? super IOException> exceptions = new ArrayList<Exception>();
        // exceptions.add(new Exception()); // DOES NOT COMPILE
        exceptions.add(new IOException());
        exceptions.add(new FileNotFoundException());
    }







}

