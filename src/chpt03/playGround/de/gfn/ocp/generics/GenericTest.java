// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 03 - Generics & Collections
 *
 *    Thema: - 3.2 - Generics
 *
 *  Listing: - 3.2.01 - GenericTest.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */


package de.gfn.ocp.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericTest {
    public static void main(String[] args) {
        GenericBox<String> b1 = new GenericBox<>();
        b1.addElement("Moin");
        
//        for(String s : b1.getElements()) {
//            System.out.println(s);
//        }
//        
//        b1.getElements().forEach(w -> System.out.println(w));
        
        b1.getElements().forEach(System.out::println);
        
        MegaGenericBox mgb = new MegaGenericBox();
        
        // CRUD create retrieve update & delete
    }
}

class GenericBox <T> {
    private List<T> elements = new ArrayList<>(10);  // at ArrayList default 10 anyway  

    public List<T> getElements() {
        return elements;
    }

    public boolean addElement(T element) {
        if(elements.size() < 10)
            return elements.add(element);
        
        return false;
        // unreachable 
        
    }    
}

// nichtgenerische Klasse mit Vererbung von einer generischen KLasse
class MegaGenericBox extends GenericBox<User> {
    
}

// generische Klasse mit Vererbung von einer generischen Klasse 
class GigaGenericBox<T> extends GenericBox<T> {
    
}
// generische Klasse mit 2 Generics mit Vererbung von einer generischen Klasse 
class PetaGenericBox<T, U> extends GenericBox<T> {
    
}
 
class TerraGenericBox<T> implements Boxable<T> {
    
}

interface Boxable<T> {
    
}

class User {
    
}