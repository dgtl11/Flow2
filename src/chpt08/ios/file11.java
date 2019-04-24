package chpt08.ios;

//
// Serializable 2 Zeit-Objekt
//
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
 
public class file11
{
  public static void main(String[] args)
  {
    try {
       FileOutputStream fs = new FileOutputStream("file11.ser");
       ObjectOutputStream os = new ObjectOutputStream(fs);
       os.writeInt(123);
       os.writeObject("File11");
       os.writeObject(new Zeit(10, 30));
       os.writeObject(new Zeit(11, 25));
       os.close();        
    } catch (IOException e) {
        System.err.println(e.toString());
    }
  }
}