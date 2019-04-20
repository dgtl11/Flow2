// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 05 - Dates, Strings Localization
 *
 *    Thema: - 05.3 - i18n & l10n
 *
 *  Listing: - 05.3.11 - GettingBundle.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt05.xmpls.i18n_l10n;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class GettingBundle {

    public static void main(String[] args) {

        // two ways of getting a resource bundle
        // ResourceBundle.getBundle("name");
        // ResourceBundle.getBundle("name", locale);

        // Locale.setDefault(new Locale("hi"));
        // ResourceBundle rb = ResourceBundle.getBundle("chpt05.xmpls.i18n_l10n.Zoo", new Locale("en"));

        Locale locale = new Locale("fr", "CA");
       // Locale locale = new Locale("en", "CA");

        ResourceBundle rb = ResourceBundle.getBundle("chpt05.xmpls.i18n_l10n.Zoo", locale);
        System.out.print(rb.getString("hello"));
        System.out.print(". ");
        System.out.print(rb.getString("name"));
        System.out.print(" ");
        System.out.print(rb.getString("open"));
        System.out.print(" ");
        System.out.print(rb.getString("visitor"));


        // hello by name
        // # helloByName=Hello, {0}

        String format = rb.getString("helloByName");
        String formatted = MessageFormat.format(format, "Tammy");
        System.out.print(formatted);

    }

}

