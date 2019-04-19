// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 05 - Dates, Strings Localization
 *
 *    Thema: - 05.3 - i18n & l10n
 *
 *  Listing: - 05.3.10 - Tax_en_US.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt05.xmpls.i18n_l10n;

import java.util.ListResourceBundle;
import java.util.Locale;
import java.util.ResourceBundle;

class UsTaxCode {}

public class Tax_en_US extends ListResourceBundle {
    protected Object[][] getContents() {
        return new Object[][] { { "tax", new UsTaxCode() } };
    }
    public static void main(String[] args) {
        ResourceBundle rb = ResourceBundle.getBundle(
                "resourcebundles.Tax", Locale.US);
        System.out.println(rb.getObject("tax"));
    }
}