// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 06 - Exceptions And Assertions
 *
 *    Thema: - 06.4 - working with assertions
 *
 *  Listing: - 06.4.11 - AssertionTester.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt06.xmpls;


public class MultiCatchTester {

    public static void main(String[] args) {

        // in meth decl werden sie auch nicht darauf überprüft ob sie auch geworfen werden (könnten)
        /*
        try {
            new FileOutputStream("xyz.txt");
        } catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
            // throw e;
            // e = new Exception();
        }

        // alle checked ex (außer Ex selbst) müssen auch geworfen werden
        // RuntimeX werden nicht überprüft

        try {

        } catch  (Exception e) {
            System.out.println(e.getMessage());
            // throw e;             // eines von beiden
            e = new Exception();
        }
        */

        // try with resoureces
        /*
        try (FileOutputStream fos = new FileOutputStream("xyz.txt")) {

        } catch (IOException e) {

        }
        */

        try (MyRes res1 = new MyRes("Max");
             MyRes res2 = new MyRes("Peter")) {
            res1.machWas();
            res2.machWas();
            throw new Exception("problem");
        } catch (Exception e) {
            System.out.println("Catch " + e.getMessage());
            System.out.println("Catch " + e.getCause());

            for(Throwable t : e.getSuppressed()){
                System.out.println(t.getMessage());
            }

        }
        finally {
            System.out.println("Finally");
        }

    }
}

class MyRes implements AutoCloseable {

    private String name = "Leer";

    public MyRes (String name) {
        this.name = name;
        System.out.println(name + " Open ");
    }

    public MyRes () {
        System.out.println(name + " Open ");
    }

    void machWas() {
        System.out.println(name + " Working");
        throw new RuntimeException(name + " hat ein problem in Work");
    }

    @Override
    public void close()  {
        System.out.println(name + " Close");
        throw new RuntimeException(name + " hat ein problem in Close");
    }
}
