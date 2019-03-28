/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chpt01.meinenum;

/**
 *
 * @author trainer
 */
public class MeinEnum {
    
    // Auch private oder protected
    public enum DayOfWeek {
        Montag,
        Dienstag,
        Mittwoch,
        Donnertag,
        Freitag,
        Samstag,
        Sonntag;
        
        public String HabeNeuenWert() {
            if (this == Montag) { return "Monday"; }
            else if (this == Sonntag) { return "Sunday";}
            return null;
        }
    }
    /** 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // eWT = erster Arbeitswochentag = 0
        ArbeitsTage eWT = ArbeitsTage.MO;
        // aStatus = aktueller Projektstatus = 0
        ProjektStatus aStatus = ProjektStatus.Unbekannt;
        
        // Block Arbeitstage
        String atName1  = eWT.name();
        String atName2  = eWT.toString();
        ArbeitsTage atName3 = ArbeitsTage.valueOf("MO");
        
        // Block ProjektStatus
        String psName1  = aStatus.name();
        String psName2  = aStatus.toString();
        ProjektStatus psName3 = ProjektStatus.valueOf("Unbekannt");
        ProjektStatus psName4 = Enum.valueOf(ProjektStatus.class, "Unbekannt");
        
        // Daten mal ausgeben
        System.out.printf("Der Inhalt vom String atName1 ist = %s\n",atName1);
        System.out.printf("Der Inhalt vom String atName2 ist = %s\n",atName2);
        System.out.printf("Der Inhalt vom String atName3 ist = %s\n\n",atName3);
        
        System.out.printf("Der Inhalt vom String psName1 ist = %s\n",psName1);
        System.out.printf("Der Inhalt vom String psName2 ist = %s\n",psName2);
        System.out.printf("Der Inhalt vom String psName3 ist = %s\n",psName3);
        System.out.printf("Der Inhalt vom String psName3 ist = %s\n\n",psName4);

        // Eine Liste aller Projektstatus Möglichkeiten
        for(ProjektStatus auswahl : ProjektStatus.values()) {
            System.out.printf("Projektstatus Auswahl: %s\t (Nummer(Ordinal): %d\n", auswahl.name(), auswahl.ordinal());
        }
        
        DayOfWeek prjBeginn = DayOfWeek.Donnertag;
        ProjektStatus prjStatus = ProjektStatus.Verschieben;
        
        System.out.printf("\nDas Projekt: Ausflug welches am %s starten soll, hat folgenden Status: %s\n", prjBeginn.name(),prjStatus.name());      
    }
}
