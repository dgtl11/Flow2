/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chpt01.nested_class;

/**
 *
 * @author trainer
 */
public class Innerhalb_Inner {
    
    public class InnereKlasse {
        int alternative2 = 4;
        
        public void ansatz3() {
            System.out.println("Ansatz 3");
        }    
    }
    
    public void ansatz4() {
        InnereKlasse ii = new InnereKlasse();
        System.out.println(ii.alternative2);
    }
    
     public static void main(String[] args) {
         Innerhalb_Inner ihi = new Innerhalb_Inner();
         ihi.ansatz4();
         
         Innerhalb_Inner.InnereKlasse ik = ihi.new InnereKlasse();
         System.out.println(ik.alternative2);
         ik.ansatz3();
     }
}
