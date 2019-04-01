// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 00 - Assessment Test
 *
 *    Thema: - 0.0 - get your Score evaluated
 *
 *  Listing: - 0.0.06 - Duck.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

// import:

package assessmentTest;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Duck {
    private String name;
    private List<Duck> ducklings;
    public Duck(String name, List<Duck> ducklings) {
        this.name = name;
        this.ducklings = new ArrayList<Duck>(ducklings);
    }
    public String getName() { return name; }
    public List<Duck> getDucklings() { return ducklings; }
    public String hasDucklings(Predicate<Duck> p) {
        return p.test(this) ? "Quack Quack": "";
    }
}