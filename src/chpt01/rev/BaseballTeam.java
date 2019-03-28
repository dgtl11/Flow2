// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 01 - Advanced Class Design
 *
 *    Thema: - 1.10 - Review Questions
 *
 *  Listing: - 1.10.31 - BaseballTeam.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

// import:

package chpt01.rev;

public class BaseballTeam {
    private String city, mascot;
    private int numberOfPlayers;
    public boolean equals(Object obj) {
        if (!(obj instanceof BaseballTeam))
            return false;
        BaseballTeam other = (BaseballTeam) obj;
        return (city.equals(other.city) && mascot.equals(other.mascot));
    }
    public int hashCode() {
        return numberOfPlayers;
    }
    // imagine getters and setters are here
}