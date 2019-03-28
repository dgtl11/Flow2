// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 01 - Advanced Class Design
 *
 *    Thema: - 1.05 - Coding equals, hashCode, toString
 *
 *  Listing: - 1.05.16 - Card.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

// import:

package chpt01.xmpls.coding;

public class Card {
    private String rank;
    private String suit;
    public Card(String r, String s) {
        if (r == null || s == null)
            throw new IllegalArgumentException();
        rank = r;
        suit = s;
    }
    public boolean equals(Object obj) {
        if ( !(obj instanceof Card)) return false;
        Card c = (Card) obj;
        return rank.equals(c.rank) && suit.equals(c.suit);
    }
    public int hashCode() {
        return rank.hashCode();
    }

    // What is wrong ?
    /*
    public int hashCode() { return idNumber; }
    public int hashCode() { return 6; }
    public long hashcode() { return idNumber; }             // CaseSense
    public int hashCode() { return idNumber * 7 + age; }    // to much vars
    */

    // Real World Scenario
    /* Apache is to complex, better write your own
        public int hashCode() {
            return keyField + 7 * otherKeyField.hashCode();
        }
     */
}