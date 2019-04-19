// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 05 - Dates, Strings Localization
 *
 *    Thema: - 05.3 - i18n & l10n
 *
 *  Listing: - 05.3.07 - i18n_l10nTest.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt05.xmpls.i18n_l10n;


import java.util.Locale;

public class i18n_l10nTest {

    public static void main(String[] args) {

        // picking a locale
        Locale locale = Locale.getDefault();
        System.out.println(locale);

        // common
        System.out.println(Locale.GERMAN); // de
        System.out.println(Locale.GERMANY); // de_DE

        System.out.println(new Locale("fr"));// fr
        System.out.println(new Locale("hi", "IN"));// hi_IN


        Locale l1 = new Locale.Builder()
                .setLanguage("en")
                .setRegion("US")
                .build();

        Locale l2 = new Locale.Builder()
                .setRegion("US")
                .setLanguage("en")
                .build();
/*
        Locale l2dont = new Locale.Builder() // bad but legal

                .setRegion("us")
                .setLanguage("EN")
                .build();
*/

        System.out.println(Locale.getDefault()); // en_US
        Locale locale2 = new Locale("fr");
        Locale.setDefault(locale2);              // change the default

        System.out.println(Locale.getDefault()); // fr
    }


}