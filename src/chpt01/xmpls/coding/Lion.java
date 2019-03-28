// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 01 - Advanced Class Design
 *
 *    Thema: - 1.05 - Coding equals, hashCode, toString
 *
 *  Listing: - 1.05.15 - Lion.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

// import:

package chpt01.xmpls.coding;

public class Lion {
    private int idNumber;
    private int age;
    private String name;
    public Lion(int idNumber, int age, String name) {
        this.idNumber = idNumber;
        this.age = age;
        this.name = name;
    }

    @Override public boolean equals(Object obj) {
        if (!(obj instanceof Lion)) return false;
        Lion otherLion = (Lion) obj;
        return this.idNumber == otherLion.idNumber;
    }

    // not overriding - overloading
    public boolean equals(Lion obj) {
        if (obj == null) return false;
        return this.idNumber == obj.idNumber;
    }

    /* Real world scenario
    Apache Commons Lang

    public boolean equals(Object obj) {
        if ( !(obj instanceof LionEqualsBuilder)) return false;
        Lion other = (Lion) obj;
        return new EqualsBuilder().appendSuper(super.equals(obj))
                .append(idNumber, other.idNumber)
                .append(name, other.name)
                .isEquals();
    }
    */
}