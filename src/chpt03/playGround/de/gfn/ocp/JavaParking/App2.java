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



import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 *
 * @author tlubowiecki
 */
public class App2 {

    private static final String DB_FILE = "data.dat";
    private static final String KEYS = "**************************\n"
            + " i = Einparken \n"
            + " o = Ausparken \n"
            + " l = Geparkte Autos anzeigen \n"
            + " x = Programm verlassen \n"
            + " h = Hilfe \n"
            + "**************************\n";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Alte Daten aus der Datei lesen
        Parking parking = readFromFile();

        // Wenn Datei nicht da oder leer
        if(parking == null)
            parking = new Parking(10);

        String input;

        System.out.println(KEYS);

        prog: while(true) {

            System.out.print("Eingabe: ");
            input = scanner.nextLine();

            switch(input.toLowerCase()) {

                case "i":
                    System.out.print("Kennzeichen: ");
                    if(parking.insert(new Car(scanner.nextLine())))
                        System.out.println("Eingeparkt");

                    saveInFile(parking);
                    break;

                case "o": {
                    System.out.print("Kennzeichen: ");
                    Car car = parking.remove(scanner.nextLine());
                    if(car != null) {
                        System.out.println(car.getRegistration() + ": Ausgeparkt");
                        BillHelper.showBill(car);
                    }
                    else
                        System.out.println("Fahrzeug wurde nicht gefunden.");

                    saveInFile(parking);
                }
                break;

                case "l":
                    // Eingeparte Fahrzeuge anzeigen
                    for(Car car : parking.getCars()) {
                        System.out.println(car.getRegistration());
                    }
                    break;

                case "help":
                case "h":
                    System.out.println(KEYS);
                    break;

                case "exit":
                case "x":
                    break prog;

                default:
                    System.out.println("Falsche Eingabe.");
            }
        }

        System.out.println("Programm beendet!");
    }

    public static Parking readFromFile() {

        try(FileInputStream fis = new FileInputStream(DB_FILE);
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(bis)) {

            return (Parking) ois.readObject();

        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Probleme beim Lesen aus der Datei.");
        }
        return null;
    }

    public static void saveInFile(Parking parking) {

        try(FileOutputStream fos = new FileOutputStream(DB_FILE);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos)) {

            oos.writeObject(parking);

        } catch (IOException ex) {
            System.out.println("Probleme beim Schreiben in die Datei.");
        }
    }
}


