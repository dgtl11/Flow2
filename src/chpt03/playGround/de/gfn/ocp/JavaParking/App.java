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

import java.io.*;
import java.time.LocalDateTime;
import java.util.Scanner;

public class App {

    private static final String DB_FILE = "data.dat";

    private static final String KEYS = "**************************\n"
                                     + " i = Einparken \n"
                                     + " o = Ausparken \n"
                                     + " l = list elements \n"
                                     + " x ^ exit = exit \n"
                                     + " h ^ help = manual \n"
                                     + "**************************\n";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Parking parking = new Parking(10);
        // alte Daten aus der DAtei lesen
        Parking parking = readFromFile();

        // wenn datei nicht da oder leer
        if(parking == null)
            parking = new Parking(10);

        String input;

        // keys ausgeben

        System.out.println(KEYS);


        prog: while(true) {

            System.out.println("Eingabe: ");
            input = scanner.nextLine();         // next bis zum nächsten space

            switch (input.toLowerCase()) {

                case "i":
                    System.out.print("Kennzeichen: ");
                    if (parking.insert(new Car(scanner.nextLine())))
                        System.out.println("Eingeparkt");

                    saveInFile(parking);
                    break;

                case "o": {
                    System.out.print("Kennzeichen: ");
                    Car car = parking.remove(scanner.nextLine());
                    if (car != null) {
                        System.out.println(car.getRegistration() + ": Ausgeparkt");
                        BillHelper.showBill(car);
                    }
                    else
                        System.out.println("Fahrzeug wurde nicht gefunden. ");

                    // in datei schreiben
                    saveInFile(parking);
                }
                    break;

                case "l":
                    // eingeparkte Fahrzeuge anzeigen
                    /*
                    for(Car c : parking.getCars()) {
                        System.out.println(c.getRegistration());
                    }
                    */
                    parking.showCars(LocalDateTime.now().minusMinutes(2), LocalDateTime.now());
                    // parking.showCars(Parking.COMP_TIME_ASC);
                    // parking.showCars((a, b) -> a.hashCode() - b.hashCode());
                    // möglich
                    break;

                case "help":
                case "h":
                    // help
                    System.out.println(KEYS);
                    break;

                case "exit":
                case "x":
                    break prog;

                 default:
                     System.out.println("Falsche Eingabe");
            }
        }

        System.out.println("Programm beendet!");

    }

    public static Parking readFromFile() {

        // try with resources / must implemen autocloseable
        try (
            FileInputStream fis = new FileInputStream(DB_FILE);
            BufferedInputStream bis = new BufferedInputStream(fis);        // decorator gibt der Kuh flügel
            ObjectInputStream ois = new ObjectInputStream(bis)) {         // decorator und rollschuhe

            return (Parking) ois.readObject();

        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Probleme beim Lesen aus der Datei");
        }

        return null;
    }

    public static void saveInFile(Parking parking) {
        try (FileOutputStream fos = new FileOutputStream(DB_FILE);
             BufferedOutputStream bos = new BufferedOutputStream(fos);        // decorator gibt der Kuh flügel
             ObjectOutputStream oos = new ObjectOutputStream(bos)) {

            oos.writeObject(parking);

        } catch (IOException ex) {
            System.out.println("Probleme beim Schreiben in die Datei");
        }
    }
    
}
