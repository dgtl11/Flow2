/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chpt10.javafxmltest;

public class Benutzer {
    
    private String vorname;
    
    private String nachname;

    public Benutzer() {
        
    }
    
    public Benutzer(String vorname, String nachname) {
        this.vorname = vorname;
        this.nachname = nachname; 
    }
    
    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }
    
    
    
}
