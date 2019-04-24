package chpt08.ios;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
//
// Serializable 2 Zeit-Objekt
//
public class file11_Lesen
{
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        try {
            FileInputStream fs = new FileInputStream("file11.ser");
            ObjectInputStream is = new ObjectInputStream(fs);
            System.out.println("" + is.readInt());
            System.out.println((String)is.readObject());
            Zeit zeit = (Zeit)is.readObject();
            System.out.println(zeit.toString());
            zeit = (Zeit)is.readObject();
            System.out.println(zeit.toString());
            is.close();
        } catch (ClassNotFoundException e) {
            System.err.println(e.toString());
        } catch (IOException e) {
            System.err.println(e.toString());
        }  
    }
}