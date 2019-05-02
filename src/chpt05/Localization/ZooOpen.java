package chpt05.Localization;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;
// import static jdk.nashorn.internal.objects.NativeObject.keys;

public class ZooOpen {
    public static void main(String[] args) {
        Locale us = new Locale("en", "US");
        Locale france = new Locale("fr","FR");
        Locale german = new Locale("de","DE");
        Locale spain = new Locale("es","ES");
        
        printProperties(us);
        System.out.println();
        printProperties(france);
        System.out.println();
        printProperties(german);
        System.out.println();
        printProperties(spain);
        System.out.println();
}
    
    public static void printProperties(Locale locale) {
        ResourceBundle rb = ResourceBundle.getBundle("chpt05.Localization.Zoo", locale);
        System.out.println();
        System.out.println("--- Ausgabe ueber rb.getString ---");
        System.out.println(rb.getString("hello"));
        System.out.println(rb.getString("open"));
        System.out.println();
        System.out.println("--------------------------------------------------------------------");
        System.out.println("---        Ausgabe ueber rb.getString inkl. Variablenname        ---");
        System.out.println("--- import static jdk.nashorn.internal.objects.NativeObject.keys ---");
        System.out.println("--------------------------------------------------------------------");
        System.out.println();
        Set<String> keys = rb.keySet();
        keys.stream().map(k -> k + " " + rb.getString(k)).forEach(System.out::println);
    }
}
