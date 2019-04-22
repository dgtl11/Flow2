/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// <editor-fold defaultstate="collapsed" desc="Title">
//     Buch: -   plm Java 
//  Kapitel: -   14 - Animationen und Threads
//
//    Thema: -   14.2 - Zeitlich gesteuerte Abläufe programmieren
//               14.2.2 Ampelsteuerung mit Thread
//
//  Listing: -   14.5 - Stoppuhr.java 
//  
//  NetBeans Project
//
//    Autor: - Daniel dgtl
// </editor-fold> 

// import:

package chpt07.gui14;


// Klasse Stoppuhr (von der Klasse Thread abgeleitet)
// Die Klasse zeigt exemplarisch die Erstellung eines eigenen Threads.

public class Stoppuhr extends Thread {
    public void run() {
	long zeit;
	long startzeit = System.currentTimeMillis() / 1000;
	while (true) {
	    try {
		Thread.sleep(1000);
	    } catch (InterruptedException e) {
		break;
	    }
	    zeit = System.currentTimeMillis() / 1000 - startzeit;
	    System.out.println(zeit);
	}
    }
}

/* 
    Zur Verwendung des Stoppuhr-Threads erzeugen Sie ihn durch Aufruf des Konstruktors
    und starten ihn mit der Methode start :

    Stoppuhr stoppuhr = new Stoppuhr();
    stoppuhr.start();
*/