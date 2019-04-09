// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 03 - Generics & Collections
 *
 *    Thema: - 3.3 - Collections
 *
 *  Listing: - 3.3.20 - BuilderTest.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt03.playGround.de.gfn.ocp.additions;


import java.util.ArrayList;
import java.util.List;

public class BuilderTest {
    public static void main(String[] args) {

        try {
            Fahrzeug f = new FahrzeugBuilder()
                    .setMarke("VW")
                    .setTyp("Kombi")
                    .addReifen(new Reifen("Dunlop", 22))
                    .addReifen(new Reifen ("Hankook", 11))
                    .build();

            System.out.println(f.getMarke());
        } catch (FahrzeugNichtGutXcptn ex) {
            ex.printStackTrace();
        }

    }


}

class FahrzeugBuilder {

    private String marke;

    private String typ;

    private List<Reifen> reifen = new ArrayList<>();

    public FahrzeugBuilder setMarke(String marke) {
        this.marke = marke;
        return this;
    }

    public FahrzeugBuilder setTyp(String typ) {
        this.typ = typ;
        return this;
    }

    public FahrzeugBuilder addReifen(Reifen reifen) {
        if(reifen == null) {
            throw new IllegalArgumentException();
        }

        this.reifen.add(reifen);
        return this;
    }

    public Fahrzeug build() throws FahrzeugNichtGutXcptn {
        return new Fahrzeug(marke, typ, reifen);
    }
}
