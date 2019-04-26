package chpt09.io_nio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class MorePathOp
{
   public static void main(String[] args)
   {
      Path path1 = Paths.get("reports", ".", "2015", "jan");
      System.out.println(path1);
      System.out.println(path1.normalize());
      path1 = Paths.get("reports", "2015", "..", "jan");
      System.out.println(path1.normalize());
      System.out.println();

      path1 = Paths.get("reports", "2015", "jan");
      System.out.println(path1);
      System.out.println(path1.relativize(Paths.get("reports", "2016", "mar")));
      try
      {
         System.out.println(path1.relativize(Paths.get("/reports", "2016", 
                                                       "mar")));
      }
      catch (IllegalArgumentException iae)
      {
         iae.printStackTrace();
      }
      System.out.println();

      path1 = Paths.get("reports", "2015");
      System.out.println(path1);
      System.out.println(path1.resolve("apr"));
      System.out.println(path1.resolve("/apr"));
   }
}