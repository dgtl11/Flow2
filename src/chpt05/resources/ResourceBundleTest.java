// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 05 - Dates, Strings and Localization
 *
 *    Thema: - 05.0 -
 *
 *  Listing: - 05.0.09 - ResourceBundleTest.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt05.resources;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleTest {
    public static void main(String[] args) {
        
        Locale loc = Locale.getDefault();
        System.out.println(loc);
        // loc = new Locale("de", "DE");

        ResourceBundle bundle = ResourceBundle.getBundle("chpt10.resources.translate", loc);

        System.out.println(bundle.getString("hi"));
        System.out.println("...");
        System.out.println(bundle.getString("goodbye"));




    }
}