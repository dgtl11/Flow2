// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 01 - Advanced Class Design
 *
 *    Thema: - 1.06 - Working with Enums
 *
 *  Listing: - 1.06.18 - Season.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

// import:

package chpt01.xmpls.enums;

public enum Season {
    WINTER("Low"), SPRING("Medium"), SUMMER("High"), FALL("Medium");
    private String expectedVisitors;
    private Season(String expectedVisitors) {
        this.expectedVisitors = expectedVisitors;
        }
    public void printExpectedVisitors() {
        System.out.println(expectedVisitors);
    }
}