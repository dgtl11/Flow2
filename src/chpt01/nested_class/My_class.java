/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chpt01.nested_class;

/**
 *
 * @author Trainer
 */
class Outer_Demo {
   int num;
   
   // inner class
   private class Inner_Demo {
      public void print() {
         System.out.println("Dieses ist eine > inner class <");
      }
   }
   
   // Accessing he inner class from the method within
   void display_Inner() {
      Inner_Demo inner = new Inner_Demo();
      inner.print();
   }
}
   
public class My_class {

   public static void main(String args[]) {
      // Unterkenntnis der äußeren Klasse 
      Outer_Demo outer = new Outer_Demo();    
      // Zugriff auf die Methode display_Inner()
      outer.display_Inner();
   }
}