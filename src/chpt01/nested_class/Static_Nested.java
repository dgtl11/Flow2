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
public class Static_Nested {
    
    static int wert1 = 3;
    
    public static class StaticNestedClass {
        static int wert2 = wert1;
        int alternative = 4;
        
        public static void ansatz1() {
            System.out.println("Ansatz 1");
        }
        
        public void ansatz2() {
            System.out.println("Ansatz 2");
        }             
    }
    
    public static void main(String[] args) {
        int wert3 = Static_Nested.StaticNestedClass.wert2;
        System.out.println(wert3);
        
        Static_Nested.StaticNestedClass.ansatz1();
        
        Static_Nested.StaticNestedClass snc = new Static_Nested.StaticNestedClass();
        int alternative2 = snc.alternative;
        System.out.println(alternative2);
        snc.ansatz2();
    }
    
}
