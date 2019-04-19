// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 05 - Dates, Strings Localization
 *
 *    Thema: - 05.3 - i18n & l10n
 *
 *  Listing: - 05.3.08 - ZooOpen.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt05.xmpls.i18n_l10n;


import java.util.*;

// properties.file syntax:
// # one comment
// ! another comment
// key =
// value\tafter tab
// long = abcdefghijklm\
// nopqrstuvwxyz

// gives:
// value → after tab
// abcdefghijklmnopqrstuvwxyz


public class ZooOpen {

    public static void main(String[] args) {

        // we want locale
        Locale us = new Locale("en", "US");
        Locale france = new Locale("fr", "FR");
        // Locale englishCanada = new Locale("en", "CA");
        // Locale frenchCanada = new Locale("fr", "CA");

        printProperties(us);
        System.out.println();
        printProperties(france);

    }
    public static void printProperties(Locale locale) {
        ResourceBundle rb = ResourceBundle.getBundle("chpt05.xmpls.i18n_l10n.Zoo", locale);
        System.out.println(rb.getString("hello"));
        System.out.println(rb.getString("open"));
    }

    public static void how2GetKeySet() {
        Locale us = new Locale("en", "US");
        ResourceBundle rb = ResourceBundle.getBundle("Zoo", us);

        Set<String> keys = rb.keySet();
        keys.stream().map(k -> k + " " + rb.getString(k))
                .forEach(System.out::println);
    }

    public static void fromResourceBundle2Properties () {
        Locale us = new Locale("en", "US");
        ResourceBundle rb = ResourceBundle.getBundle("Zoo", us);
        Properties props = new Properties();
        rb.keySet().stream()
                .forEach(k -> props.put(k, rb.getString(k)));

        // get a default value:
        System.out.println(props.getProperty("notReallyAProperty"));
        System.out.println(props.getProperty("notReallyAProperty", "123"));

    }
}