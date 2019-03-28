// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 01 - Advanced Class Design
 *
 *    Thema: - 1.07 - Creating Nested Classes
 *             1.07.3 - Anonymous Inner Classes
 *
 *  Listing: - 1.07.27 - AnonInner2.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

// import:

package chpt01.xmpls.nested;

public class AnonInner2 {

    interface SaleTodayOnly {
        int dollarsOff();
    }
    public int pay() {
        return admission(5, new SaleTodayOnly() {
            public int dollarsOff() { return 3; }
        });
    }
    public int admission(int basePrice, SaleTodayOnly sale) {
        return basePrice - sale.dollarsOff();
    }

    /* Used as Event Handlers
        JButton button = new JButton("red");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // handle the button click
            }
        });
     */
}