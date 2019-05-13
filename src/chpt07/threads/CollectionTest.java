// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 07 - concurrency
 *
 *    Thema: - 07.8 - Live Examples
 *
 *  Listing: - 07.08.55 - CollectionTest.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt07.threads;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class CollectionTest {
    public static void main(String[] args) {

        // Map<String, String> daten = new HashMap<>();
        Map<String,String> daten = new ConcurrentHashMap<>();

        daten.put("vorname" , "Peter");
        daten.put("nachname", "parker");

        for(String key : daten.keySet()) {
            daten.remove(key);
        }

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // List<String> list = new ArrayList<>();
        List<String> list = new CopyOnWriteArrayList<>();

        list.add("peter");
        list.add("parker");

        for(String s : list) {
            System.out.println(s);
            list.add("Clark");
        }

        System.out.println(list.size());

    }
}

