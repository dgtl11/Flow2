package chpt09.io_nio;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathAttrib
{
   public static void main(String[] args) throws IOException
   {
      if (args.length != 1)
      {
         System.err.println("usage: java PathAttrib path-object");
         return;
      }

      Path path = Paths.get(args[0]);
      System.out.printf("Last modified time: %s%n", Files.getLastModifiedTime(path));
      System.out.printf("Owner: %s%n", Files.getOwner(path));
      System.out.printf("Size: %d%n", Files.size(path));
   }
}