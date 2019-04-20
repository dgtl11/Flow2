// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 06 - Exceptions And Assertions
 *
 *    Thema: - 06.4 - working with assertions
 *
 *  Listing: - 06.4.07 - Testseasons.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt06.xmpls.assertions;


// The syntax for an assert statement has two forms:
// assert boolean_expression;
// assert boolean_expression: error_message;

//  run with:
// java –ea Assertions

//  the -enableassertions flag on the command line:
// java -enableassertions Rectangle
//  You can also use the shortcut -ea flag:
// java -ea Rectangle

//  in specific pckg
// java -ea:com.wiley.demos... my.programs.Main

//  enable assertions for a specifi c class:
// java -ea:com.wiley.demos.TestColors my.programs.Main

// both
//  enables assertions for the com.wiley.demos package but disables assertions for the TestColors
//  class:
// java -ea:com.wiley.demos... -da:com.wiley.demos.TestColors my.programs.Main

class AssertionsTest {

    public static void main(String[] args) {
        int numGuests = -5;
        assert numGuests > 0;
        System.out.println(numGuests);
    }
}

enum Seasons {
    SPRING, SUMMER, FALL
}

public class TestSeasons {
    public static void test(Seasons2 s) {
        switch (s) {
            case SPRING:
            case FALL:
                System.out.println("Shorter hours");
                break;
            case SUMMER:
                System.out.println("Longer hours");
                break;
            default:
                assert false: "Invalid season";
        }
    }
    public static void main(String [] args) {
        test (Seasons2.WINTER);
    }
}

enum Seasons2 {
    SPRING, SUMMER, FALL, WINTER
}