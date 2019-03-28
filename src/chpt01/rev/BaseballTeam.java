// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 01 - Advanced Class Design
 *
 *    Thema: - 1.10 - Review Questions
 *
 *  Listing: - 1.10.30 - TestClass.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

// import:

package chpt01.rev;

public class BaseballTeam {
    private int ISBN;
    private String title, author;
    private int pageCount;
    public int hashCode() {
        return ISBN;
    }
    @Override public boolean equals(Object obj) {
        if (!(obj instanceof BaseballTeam)) {
            return false;
        }
        BaseballTeam other = (BaseballTeam) obj;
        return this.ISBN == other.ISBN;
    }
    // imagine getters and setters are here
}