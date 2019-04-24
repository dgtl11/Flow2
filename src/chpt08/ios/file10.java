package chpt08.ios;

//
// Serializable 1 Zeit-Objekt
//
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
 
public class file10
{
  public static void main(String[] args)
  {
    try {
        FileOutputStream fs = new FileOutputStream("file10.ser");
        ObjectOutputStream os = new ObjectOutputStream(fs);
        Zeit zeit = new Zeit(10,20);
        os.writeObject(zeit);
        os.close();
    } catch (IOException e) {
        System.err.println(e.toString());
    }
  }
}
