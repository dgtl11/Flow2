// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 06 - Exceptions And Assertions
 *
 *    Thema: - 06.4 - working with assertions
 *
 *  Listing: - 06.4.08 - Rectangle.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt06.xmpls.assertions;

// assertions should not alter outcomes

// int x = 10;
//assert ++x > 10;  // Not a good design!

public class Rectangle {

    private int width, height;

    /* public Rectangle(int width, int height) {

        this.width = width;


        this.height = height;
    } */

    public int getArea() {
        assert isValid() : "Not a valid Rectangle";
        return width * height;
    }

    private boolean isValid() {

        return (width >= 0 && height >= 0);

    }

    public static void main(String[] args) {
        Rectangle one = new Rectangle(5, 12);
        Rectangle two = new Rectangle(-4, 10);
        System.out.println("Area one = " + one.getArea());

        System.out.println("Area two = " + two.getArea());

    }

    // do not use assertions to check for valid arguments passed in to a meth use an illegalArgumentExcption:
    public Rectangle(int width, int height) {
        if(width < 0 || height < 0) {
            throw new IllegalArgumentException();
        }
        this.width = width;
        this.height = height;
    }
}

