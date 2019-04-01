// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 02 - Generics & Collections
 *
 *    Thema: - 2.3 - Using Lists, Sets, Maps, and Queues
 *             2.3.5 - Map
 *
 *  Listing: - 2.3.20 - Maps.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt03.xmpls.collections;


import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Maps {

    public static void main(String[] args) {

        // compare running the same code with two Map types. First up is HashMap:
        Map<String, String> map = new HashMap<>();
        map.put("koala", "bamboo");
        map.put("lion", "meat");
        map.put("giraffe", "leaf");
        String food = map.get("koala"); // bamboo
        for (String key: map.keySet())
            System.out.print(key + ","); // koala,giraffe,lion,

        // Now let’s look at TreeMap:
        Map<String, String> map2 = new TreeMap<>();
        map2.put("koala", "bamboo");
        map2.put("lion", "meat");
        map2.put("giraffe", "leaf");
        String food2 = map2.get("koala"); // bamboo
        for (String key: map2.keySet())
            System.out.print(key + ","); // giraffe,koala,lion,

        // With our same map, we can try some boolean checks:
        // System.out.println(map2.contains("lion")); // DOES NOT COMPILE
        System.out.println(map2.containsKey("lion")); // true
        System.out.println(map2.containsValue("lion")); // false
        System.out.println(map2.size()); // 3

    }

}

