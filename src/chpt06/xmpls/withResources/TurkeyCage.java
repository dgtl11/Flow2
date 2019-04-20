// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 06 - Exceptions And Assertions
 *
 *    Thema: - 06.2 - Try with Resources
 *
 *  Listing: - 06.2.03 - TurkeyCage.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt06.xmpls.withResources;

class Turkey {
    /*
    public static void main(String[] args) {
         try (Turkey t = new Turkey()) {        // DOES NOT COMPILE how to close a turkey
            System.out.println(t);
         }
    }
    */
}

//    The AutoCloseable interface has only one method to implement:
// public void close() throws Exception;


public class TurkeyCage implements AutoCloseable {

    public void close() {
        System.out.println("Close gate");
    }
    public static void main(String[] args) {
        try (TurkeyCage t = new TurkeyCage()) {
            System.out.println("put turkeys in");
        }
    }
}

class StuckTurkeyCage implements AutoCloseable {
    public void close() throws Exception {
        throw new Exception("Cage door does not close");
    }
    public static void main(String[] args) throws Exception {
        try (StuckTurkeyCage t = new StuckTurkeyCage()) {       // would NOT COMPILE without throws excptn
            System.out.println("put turkeys in");
        }
    }
}

// best implement
class ExampleOne implements AutoCloseable {
    public void close() throws IllegalStateException {
        throw new IllegalStateException("Cage door does not close");
    }
}

// throws Ex rather than specific subclass
class ExampleTwo implements AutoCloseable {
    public void close() throws Exception {
        throw new Exception("Cage door does not close");
    }
}

// side effects
class ExampleThree implements AutoCloseable {
    static int COUNT = 0;
    public void close() {
        COUNT++;
    }
}