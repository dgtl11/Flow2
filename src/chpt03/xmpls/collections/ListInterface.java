// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 02 - Generics & Collections
 *
 *    Thema: - 2.3 - Using Lists, Sets, Maps, and Queues
 *             2.3.2 - Using the List Interface
 *
 *  Listing: - 2.3.17 - ListInterface.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt03.xmpls.collections;

import java.util.*;

public class ListInterface {

    public static void main(String[] args) {

        // basic methods for adding and removing
        // items from a list:
        List<String> list = new ArrayList<>();
        list.add("SD"); // [SD]
        list.add(0, "NY"); // [NY,SD]
        list.set(1, "FL"); // [NY,FL]
        list.remove("NY"); // [FL]
        list.remove(0); // []

        // more example that queries the list:
        list.add("OH"); // [OH]
        list.add("CO"); // [OH,CO]
        list.add("NJ"); // [OH,CO,NJ]
        String state = list.get(0); // OH
        int index = list.indexOf("NJ"); // 2


        // how to loop through a list using an enhanced for loop
        for (String string: list) {
            System.out.println(string);
        }

        // this in code written before Java 5:
        Iterator iter = list.iterator();
        while(iter.hasNext()) {
            String string = (String) iter.next();
            System.out.println(string);
        }

        // a hybrid way where you still use Iterator with generics
        Iterator<String> iter2 = list.iterator();
        while(iter2.hasNext()) {
            String string = iter2.next();
            System.out.println(string);
        }

    }

}

