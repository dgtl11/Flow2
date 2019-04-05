// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 03 - Generics & Collections
 *
 *    Thema: - 3.3 - Collections
 *
 *  Listing: - 3.3.09 - CollectionTest.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt03.playGround.de.gfn.ocp.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author tlubowiecki
 */
public class CollectionTest {
    
    public static void main(String[] args) {
        
        List<String> l1 = new ArrayList<>(Arrays.asList("David", "Bruce"));
        
        l1.add("Peter");
        l1.addAll(Arrays.asList("Bruce", "Tony", "Clark"));
        l1.remove("Clark");
        
        Iterator<String> itr = l1.iterator();
        while (itr.hasNext()) {
            String next = itr.next();
            
        }
        
        for (String str : l1) {
            System.out.println(str);
        }
        
        for (int i = 0; i < l1.size(); i++) {
            System.out.println(l1.get(i));
        }
        
        l1 = new LinkedList<>(l1);
        
        Collections.sort(l1);
        System.out.println(l1);
        
        System.out.println("----------------");
        
        Set<String> s1 = new HashSet<>(l1);
        System.out.println(s1);
        s1.add("Bruce");
        
        if(s1.contains("Peter"))
            System.out.println("Peter ist drin");
        
        
        s1.add(new String("Hans"));
        s1.add(new String("Hans"));
        System.out.println(s1);
        
    }
}
