// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 01 - Advanced Class Design
 *
 *    Thema: - 1.05 - Coding equals, hashCode, toString
 *
 *  Listing: - 1.05.13 - Hippo.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

// import:

package chpt01.xmpls.coding;

public class Hippo {
    private String name;
    private double weight;
    public Hippo(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }
    @Override
    public String toString() {
        return name;
    }

    /* Using all vars
    public String toString() {
        return "Name: " + name + ", Weight: " + weight;
    }
    */

    /*
    This is all you have to write to have Apache Commons return all of the instance variables
    in a String:

        public String toString() {
            return ToStringBuilder.reflectionToString(this);
        }
     */

    /*
    When testing your code, there is a benefit to not having information in toString()
    that isn’t useful to your caller (12da89a7). Apache Commons accounts for this as well.
    You can write

        @Override public String toString() {
            return ToStringBuilder.reflectionToString(this,
            ToStringStyle.SHORT_PREFIX_STYLE);
        }
     */

    public static void main(String[] args) {
        Hippo h1 = new Hippo("Harry", 3100);
        System.out.println(h1); // Harry
    } }
