// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 05 - Dates, Strings Localization
 *
 *    Thema: - 05.3 - i18n & l10n
 *
 *  Listing: - 05.3.09 - Zoo_en.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt05.xmpls.i18n_l10n;

import java.util.*;

public class Zoo_en extends ListResourceBundle {
    protected Object[][] getContents() {
        return new Object[][] {
                { "hello", "Hello" },
                { "open", "The zoo is open" } };
    }
}