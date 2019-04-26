package chpt09.io_nio;

import java.net.URI;
import java.net.URISyntaxException;

import java.nio.file.FileSystemNotFoundException;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ObtainPath2
{
   public static void main(String[] args) throws URISyntaxException
   {
      try
      {
         Path path = Paths.get(new URI(""));
         System.out.println(path);
      }
      catch (IllegalArgumentException iae)
      {
         System.err.println("You cannot pass a URI object initialized to the " +
                            "empty string to get().");
         iae.printStackTrace();
      }

      try
      {
         Path path = Paths.get(new URI("nntp://x"));
         System.out.println(path);
      }
      catch (FileSystemNotFoundException fsnfe)
      {
         System.err.println("No file system associated with the specified scheme.");
         fsnfe.printStackTrace();
      }
   }
}