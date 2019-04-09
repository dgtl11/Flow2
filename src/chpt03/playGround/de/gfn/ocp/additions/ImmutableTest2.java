// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 03 - Generics & Collections
 *
 *    Thema: - 3.3 - Collections
 *
 *  Listing: - 3.3.19 - ImmutableTest.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt03.playGround.de.gfn.ocp.additions;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author tlubowiecki
 */
public class ImmutableTest2 {

    public static void main(String[] args) {



        try {
            Fahrzeug2 f = new Fahrzeug2("VW", "Kombi", Arrays.asList(new Reifen("Dunlop", 22)));

            f.getReifen().add(new Reifen("Hankook", 34));

            System.out.println(f.getReifen());
        }
        catch(FahrzeugNichtGutException e) {
            e.printStackTrace();
        }



    }

}

final class Fahrzeug2 {

    private final String marke;

    private final String typ;

    private final List<Reifen> reifen;

    public Fahrzeug2(String marke, String typ, List<Reifen> reifen) throws FahrzeugNichtGutException {
        this.marke = marke;
        this.typ = typ;

        if(reifen == null) {
            throw new FahrzeugNichtGutException("Keine Reifen?!");
        }
        this.reifen = new ArrayList<>(reifen);
    }

    public String getMarke() {
        return marke;
    }

    public String getTyp() {
        return typ;
    }

    public List<Reifen> getReifen() {
        return new ArrayList(reifen);
    }
}

class FahrzeugNichtGutException extends Exception {

    public FahrzeugNichtGutException() {
    }

    public FahrzeugNichtGutException(String message) {
        super(message);
    }
}

class Reifen2 {

    private final String marke;

    private final int groesse;

    public Reifen2(String marke, int groesse) {
        this.marke = marke;
        this.groesse = groesse;
    }

    public String getMarke() {
        return marke;
    }

    public int getGroesse() {
        return groesse;
    }
}