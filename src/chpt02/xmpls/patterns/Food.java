// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 02 - Design Patterns & Principles
 *
 *    Thema: - 2.5 - working with design patterns
 *             2.5.4 - factory pattern
 *
 *  Listing: - 2.5.12 - Food.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt02.xmpls.patterns;

public abstract class Food {
    private int quantity;

    public Food(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public abstract void consumed();
}


class Hay extends Food {
    public Hay(int quantity) {
        super(quantity);
    }

    public void consumed() {
        System.out.println("Hay eaten: " + getQuantity());
    }
}


class Pellets extends Food {
    public Pellets(int quantity) {
        super(quantity);
    }

    public void consumed() {
        System.out.println("Pellets eaten: " + getQuantity());
    }
}


class Fish extends Food {
    public Fish(int quantity) {
        super(quantity);
    }

    public void consumed() {
        System.out.println("Fish eaten: " + getQuantity());
    }
}
