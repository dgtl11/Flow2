// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 03 - Generics & Collections
 *
 *    Thema: - 3.3 - Collections
 *
 *  Listing: - 3.3.17 - CompositionTest.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt02.xmpls;

public class CompositionTest {

    public static void main(String[] args) {
        Ganzes g = new Ganzes("whole");
        g.machWas();

    }

}

class Ganzes {
    private Teil teil;

    public Ganzes(String name) {
        this.teil = new Teil(name);
    }

    void machWas() {
        teil.machWas();
    }

}

class Teil {

    private String name;

    public Teil(String name) {
        this.name = name;
    }

    public void machWas() {
        System.out.println("ich bin ein Teil");
    }

}
