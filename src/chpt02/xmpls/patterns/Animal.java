// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 02 - Design Patterns & Principles
 *
 *    Thema: - 2.5 - working with design patterns
 *             2.5.2 - Creating immutable classes
 *
 *  Listing: - 2.5.09 - Animal.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt02.xmpls.patterns;

import java.util.ArrayList;
import java.util.List;

public final class Animal {
    private final List<String> favoriteFoods;

    public Animal(List<String> favoriteFoods) {
        if(favoriteFoods == null) {
            throw new RuntimeException("favoriteFoods is required");
        }
        this.favoriteFoods = new ArrayList<String>(favoriteFoods);
    }

    public List<String> getFavoriteFoods() { // MAKES CLASS MUTABLE!
        return favoriteFoods;
    }
}
