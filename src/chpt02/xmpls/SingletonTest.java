// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 03 - Generics & Collections
 *
 *    Thema: - 3.3 - Collections
 *
 *  Listing: - 3.3.18 - SingletonTest.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt02.xmpls;

public class SingletonTest {

    public static void main(String[] args) {

        EagerSingleton es1 = EagerSingleton.getInstance();

        EagerSingleton es2 = EagerSingleton.getInstance();

        System.out.println(es1 == es2);

        // Enum immer singleton / jede option in enum einzelnes singleton
        EnumSingleton.OBJ.machWas();

    }

}

class EagerSingleton {

    // EAGER Variante
    private static final EagerSingleton instance;

    static {
        instance = new EagerSingleton();
    }

    private EagerSingleton() {

    }

    public static EagerSingleton getInstance() {
        return instance;
    }

}

class LazySingleton {

    // LAZY
    private volatile static LazySingleton instance;

    private LazySingleton() {

    }

    public static LazySingleton getInstance() {

        // double Cheching
        if(instance == null) {
            synchronized (LazySingleton.class) {
                if(instance == null) {
                    instance = new LazySingleton();
                }
            }

        }

        return instance;
    }

}

enum EnumSingleton {

    OBJ("Max");

    private String name;

    private EnumSingleton(String name) {
        this.name = name;
    }

    void machWas() {
        System.out.println("Mein EnumSingleton" + name);
    }
}