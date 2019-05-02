package chpt05.Localization;

import java.util.Properties;

public class SysProps {
    public static void main(String[] args) {
        Properties p = System.getProperties(); // öffnet Propertie-Datei
        p.setProperty("myProp", "myValue");    // fügt einen Eintrag hinzu
        p.list(System.out);                    // liste den Propertie-Datei Inhalt
    }
}