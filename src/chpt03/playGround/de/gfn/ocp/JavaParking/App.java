// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 03 - Generics & Collections
 *
 *    Thema: - 3.x - AnwendungsBeispiel
 *
 *  Listing: - 3.x.09 - CollectionTest2.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt03.playGround.de.gfn.ocp.JavaParking;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Parking parking = new Parking(10);

        String input;

        prog: while(true) {
            input = scanner.nextLine();         // next bis zum nächsten space

            switch (input.toLowerCase()) {

                case "i":
                    System.out.print("Kennzeichen: ");
                    if(parking.insert(new Car(scanner.nextLine())))
                        System.out.println("Eingeparkt");
                    break;

                case "o":
                    System.out.print("Kennzeichen: ");
                    Car car = parking.remove(scanner.nextLine());
                    if(car != null)
                        System.out.println(car.getRegistration() + ": Ausgeparkt");
                    else
                        System.out.println("Fahrzeug wurde nicht gefunden. ");
                    break;

                case "l":
                    // eingeparkte Fahrzeuge anzeigen
                    for(Car c : parking.getCars()) {
                        System.out.println(c.getRegistration());
                    }
                    break;

                case "x":
                    break prog;

                 default:
                     System.out.println("Falsche Eingabe");
            }
        }

        System.out.println("Programm beendet!");

    }
    
}
