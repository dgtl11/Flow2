// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 05 - Dates, Strings Localization
 *
 *    Thema: - 05.2 - String Review
 *
 *  Listing: - 05.2.06 - StringReview.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt05.xmpls.stringRev;



public class StringReview {

    public static void main(String[] args) {

        // comparing and pool
        String s1 = "bunny";
        String s2 = "bunny";
        String s3 = new String("bunny");
        System.out.println(s1 == s2);// true
        System.out.println(s1 == s3);// false
        System.out.println(s1.equals(s3));// true

        // concatenation
        String s4 = "1" + 2 + 3;
        String s5 = 1 + 2 + "3";
        System.out.println(s4); // 123
        System.out.println(s5); // 33

        // methods
        String s = "abcde ";
        System.out.println(s.trim().length()); // 5
        System.out.println(s.charAt(4)); // e
        System.out.println(s.indexOf('e')); // 4
        System.out.println(s.indexOf("de")); // 3
        System.out.println(s.substring(2, 4).toUpperCase()); // CD
        System.out.println(s.replace('a', '1')); // 1bcde
        System.out.println(s.contains("DE")); // false
        System.out.println(s.startsWith("a")); // true



        // StringBuilder
        StringBuilder b = new StringBuilder();
        b.append(12345).append('-');// 6

        System.out.println(b.length());// 5

        System.out.println(b.indexOf("-"));// 3

        System.out.println(b.charAt(2));
        StringBuilder b2 = b.reverse();
        System.out.println(b.toString());// -54321
        System.out.println(b == b2);// true

        StringBuilder s22 = new StringBuilder("abcde");
        s22.insert(1, '-').delete(3, 4);//a-bde

        System.out.println(s22);
        System.out.println(s22.substring(2, 4)); // bd


    }


}