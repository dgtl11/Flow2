// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 01 - Advanced Class Design
 *
 *    Thema: - 1.06 - Working with Enums
 *
 *  Listing: - 1.06.17 - Enumes.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

// import:

package chpt01.xmpls.enums;

public class Enumes {
    public enum Season {
        WINTER, SPRING, SUMMER, FALL
    }

    public static void main(String[] args) {
        Season s = Season.SUMMER;
        System.out.println(Season.SUMMER);      // SUMMER
        System.out.println(s == Season.SUMMER); // true

        // method to get an array of all the values
        for(Season season: Season.values()) {
            System.out.println(season.name() + " " + season.ordinal());
        }

        // but not comparable with int
        // if ( Season.SUMMER == 2) {} // DOES NOT COMPILE

        // Strings can be passed but the have to fit
        Season s1 = Season.valueOf("SUMMER"); // SUMMER
        // Season s2 = Season.valueOf("summer"); // exception

        // Enums in Switch
        Season summer = Season.SUMMER;
        switch (summer) {
            case WINTER:
                System.out.println("Get out the sled!");
                break;
            case SUMMER:
                System.out.println("Time for the pool!");
                break;
            default:
                System.out.println("Is it summer yet?");
        }

        // but they are not ints
        /*
        switch (summer) {
            case 0: // DOES NOT COMPILE
                System.out.println("Get out the sled!");
                break;
        }
        */

    }

    // And the cannot be extended
    // public enum ExtendedSeason extends Season { } // DOES NOT COMPILE
}