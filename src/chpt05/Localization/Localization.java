/*******************************
 * Kleine Übersicht
 */
package chpt05.Localization;

import java.util.Locale;

class Localization {

    public static void main(String[] args) {
        System.out.println("*************************************************");
        System.out.println("*** ----------------------------------------- ***");
        System.out.println("*  Chapter 5 - Dates,Strings and >Localization< *");
        System.out.println("*** ----------------------------------------- ***");
        System.out.println("*************************************************");
        System.out.println("***");
        // 
        // Auswahl einer Sprache und der Landes
        //
        Locale locale = Locale.getDefault();
        System.out.println("Aktuell eingestellte Sprache und Land : "+locale);
        // 
        // Das kleingeschriebene Landeskürzel steht für Sprache
        // Das großgeschriebene Landeskürzel steht für das Land
        //
        // Deutschland de
        System.out.println("Die gewählte Sprache ist      : " + Locale.GERMAN);
        // Deutschland de_DE
        System.out.println("Die gewählte Sprache/Land ist : " + Locale.GERMANY);
        //
        System.out.println(new Locale("fr"));       // Frankreich fr
        System.out.println(new Locale("hi", "IN")); // Hindi in Indien hi_IN
        //
        Locale l1 = new Locale.Builder()
                .setLanguage("en")
                .setRegion("US")
                .build();
        //
        // System.out.println("*** ----------------------------------------- ***");
        // System.out.println("*   Diese Variante sollte nicht benutzt werden  *");
        // System.out.println("*** ----------------------------------------- ***");
        //
        // Locale l2 = new Locale.Builder()
        //        .setRegion("us")
        //        .setLanguage("en")
        //        .build();
        
        System.out.println(Locale.getDefault()); // de_DE  en_US 
        Locale l3 = new Locale("fr"); 
        Locale.setDefault(l3);                   // change the default 
        System.out.println(Locale.getDefault()); // fr 
        //
        // Nutzen von 2 Sprachen in einem Bundle
        //
        Locale us = new Locale("en","US");
        Locale france = new Locale("fr","FR");
        Locale englishCanada = new Locale("en","CA");
        Locale frenchCanada = new Locale("fr","CA");
        //
    }
}
