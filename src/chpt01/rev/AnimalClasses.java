// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 01 - Advanced Class Design
 *
 *    Thema: - 1.10 - Review Questions
 *
 *  Listing: - 1.10.37 - AnimalClasses.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

// import:

package chpt01.rev;

public enum AnimalClasses {
    MAMMAL(true), FISH(Boolean.FALSE), BIRD(false), REPTILE(false), AMPHIBIAN(false), INVERTEBRATE(false);
    // must have semicolon

    boolean hasHair;

    // constr must be private or prot
    private AnimalClasses(boolean hasHair) {
        this.hasHair = hasHair;
    }

    public boolean hasHair() {
        return hasHair;
    }

    public void giveWig() {
        hasHair = true;
    }
    }

