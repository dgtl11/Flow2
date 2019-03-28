// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 01 - Advanced Class Design
 *
 *    Thema: - 1.10 - Review Questions
 *
 *  Listing: - 1.10.34 - IsItFurry.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

// import:

package chpt01.rev;


public class IsItFurry {
    static interface Mammal { }
    static class Furry implements Mammal { }
    static class Chipmunk extends Furry { }
    public static void main(String[] args) {
        Chipmunk c = new Chipmunk();
        Mammal m = c;
        Furry f = c;
        int result = 0;
        if (c instanceof Mammal) result += 1;
        if (c instanceof Furry) result += 2;
        if (null instanceof Chipmunk) result += 4;
        System.out.println(result);
    }
}

// output = 3