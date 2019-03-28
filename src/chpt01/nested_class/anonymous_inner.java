/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chpt01.nested_class;

/**
 *
 * @author trainer
 */
interface Auto 
{ 
    String marke = "BMW";
    String f_typ = "2002";
    String f_jhr = "1984";
    void fhz_daten(); 
} 

public class anonymous_inner {   
    public static void main(String[] args) {
        Auto fhz = new Auto() {
            @Override
            public void fhz_daten() {
                System.out.println(String.format("Fahrzeug %s %s ist vom Baujahr %s\n",marke,f_typ,f_jhr));
            }
        };
        // Myclass ist die verborgene innere Klasse der Auto-Schnittstelle
        // deren Name nicht geschrieben wird, sondern ein Objekt dagegen
        // geschaffen
        fhz.fhz_daten();
    }
}
 