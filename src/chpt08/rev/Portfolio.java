// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 08 - IO
 *
 *    Thema: - 08.7 - ets Review Questions
 *
 *  Listing: - 08.7.12 - Portfolio.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt08.rev;

import java.io.*;

class Bond {
    String ticker = "bac";
    double coupon = 8.3;
}

public class Portfolio implements Serializable {
    String accountName;
    transient Bond bond = new Bond();
    private void writeObject(ObjectOutputStream os) throws Exception {
        os.defaultWriteObject();
        os.writeObject(bond.ticker);
        os.writeObject(bond.coupon);
    }

    private void readObject(ObjectInputStream os) throws Exception {
        os.defaultReadObject();
        this.bond = new Bond();
        bond.ticker = (String) os.readObject();
        bond.coupon = os.readDouble();
    }

}