package chpt08.ios;

//
// Als Beispiel konstruieren wir eine einfache Klasse Time, die eine Uhrzeit, 
// bestehend aus Stunden und Minuten, kapselt
//
import java.io.Serializable;

public class Zeit
implements Serializable {
    private int stunden;
    private int minuten;

    public Zeit(int stunden, int minuten)
    {
        this.stunden = stunden;
        this.minuten = minuten;
    }
 
    public String toString()
    {
        return stunden + ":" + minuten;
    }
}        
