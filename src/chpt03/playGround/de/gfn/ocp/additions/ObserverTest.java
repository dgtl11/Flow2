// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 03 - Generics & Collections
 *
 *    Thema: - 3.3 - Collections
 *
 *  Listing: - 3.3.17 - ObserverTest.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt03.playGround.de.gfn.ocp.additions;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ObserverTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bonefire fire = new Bonefire();
        fire.addObserver(new Scout("Peter"));
        fire.addObserver(new Scout("Bob"));
        fire.addObserver(new Wolf());


        app: while(true) {

            switch (scanner.nextLine().toUpperCase()) {
                case "ON":
                    fire.setState(Bonefire.State.ON);
                    break;

                case "OFF" :
                    fire.setState(Bonefire.State.OFF);
                    break;

                case "BIG":
                    fire.setState(Bonefire.State.BIG);
                    break;

                case "SMALL":
                    fire.setState(Bonefire.State.SMALL);
                    break;

                case "X":
                    break app;

                    default:
                        System.out.println("falsche Eingabe !!!");
                        break;
            }
        }
    }

}

interface Observer {
 void update(Observable o);
}

// ein beobachter
class Scout implements Observer {

    private final String name;

    private int offCount = 0;

    public Scout(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o) {
        // System.out.println(getClass().getSimpleName() + " wurde benachrichtigt ");
        switch(((Bonefire) o).getState()) {
            case ON:
                System.out.println(name + ": Jup. Super!");
                break;
            case OFF:
                System.out.println(name + ": Schade, dann gehe ich schlafen");
                if(++offCount == 3) {
                    o.removeObserver(this);
                }
                break;
            case BIG:
                System.out.println(name + ": Genial, jetzt gibt es Würstchen");
                break;
            case SMALL:
                System.out.println(name + ": * Gähn *");
                break;
        }
    }
}

// ein beobachter
class Wolf implements Observer {

    private int distance;

    public Wolf() {
        distance = new Random().nextInt(100);
    }

    @Override
    public void update(Observable o) {
        // System.out.println(getClass().getSimpleName() + " wurde benachrichtigt ");
        switch (((Bonefire) o).getState()) {
            case OFF:
                distance -= new Random().nextInt(50);
                System.out.println("wolf kommt näher");
                System.out.printf("entfernung: %d m ", distance);
                break;
            default:
                System.out.println("wolf wartet");
                break;
        }
    }
}

abstract class Observable {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer o) {
        if(!observers.contains(o))
            observers.add(o);
    }

    public void removeObserver(Observer o) {
        if(observers.contains(o))
            observers.remove(o);
    }

    protected void notifyObservers () {

        for(int i = 0; i < observers.size(); i++) {
            observers.get(i).update(this);
        }
    }
}

// wird beobachtet
class Bonefire extends Observable {

    static enum State {
        ON, OFF, BIG, SMALL;
    }

    private State state = State.OFF;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        if(this.state != state) {
            this.state = state;
            notifyObservers();
        }
    }

}


