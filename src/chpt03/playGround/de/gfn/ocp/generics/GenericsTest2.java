// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 03 - Generics & Collections
 *
 *    Thema: - 3.2 - Generics
 *
 *  Listing: - 3.2.02 - GenericsTest2.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt03.playGround.de.gfn.ocp.generics;

import java.util.*;

public class GenericsTest2 {
    public static void main(String[] args) {
        NonGenericClass<Double> ngc = new NonGenericClass();
        ngc.machWas(123);
        
        List<String> liste = new ArrayList<>();
        Object[] o = liste.toArray(); 
        Integer[] s = liste.toArray(new Integer[0]);
        
        GenericNumbers<Integer> gn = new GenericNumbers<>();
        System.out.println(gn.getNumber(200));
        
        Object o1 = new ArrayList();
        
        
        List<Object> ln = new ArrayList<Object>();
        ln.add(1d);
        ln.add(2.7);
        // showList(Arrays.asList(1,2,5,9,17,22));
        showList(ln);
        
        List li = new LinkedList<String>();
        li.add(123);
        System.out.println(li.get(0));
        
        
        List<?> ln2 = new ArrayList<Integer>();
        
    }
    
    private static void showList(List<? super Number> l) {
        
        System.out.println(l.get(1));
        l.add(2);
        
//        for(Object n : l) {
//            System.out.println(n);
//        }
    }
}

class NonGenericClass<T> {
    
    public <T> T machWas(T t) {
        T var1;
        System.out.println(t.getClass().getName());
        return t;
    }
    
    public <T> void machWasAnderes(T t) {
        System.out.println(t.getClass().getName());
    }
}

class GenericNumbers<T extends Number> {
    public double getNumber(T t) {
        return t.doubleValue();
    }
}
