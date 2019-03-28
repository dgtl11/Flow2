/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chpt01.nested_class;

/**
 *
 * @author trainer
 * 
 */
// Äußere Klasse (OuterClass)
public class Nested_class {
    static int a = 3;

    public static class StaticNestedClass {
        static int a2 = a;
        int b = 4;

        public static void method1() {
          System.out.println("Hello");
        }
        public void method2() {
          System.out.println("Welt!");
        }
    }
  
    public static void main(String[] args) {
        int a3 = Nested_class.StaticNestedClass.a2;
        System.out.println(a3);

        Nested_class.StaticNestedClass.method1();

        Nested_class.StaticNestedClass snc = new Nested_class.StaticNestedClass();
        int b2 = snc.b;
        System.out.println(b2);
        snc.method2();
    }
}
