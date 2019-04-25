// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 09 - NIO.2
 *
 *    Thema: - 09.1 - Introducing NIO.2
 *
 *  Listing: - 09.1.01 - PathTester.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt09.xmpls.intro;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTester {
    public static void main(String[] args) throws URISyntaxException {

        Path path1 = Paths.get("pandas/cuddly.png");

        //win
        Path path2 = Paths.get("c:\\zooinfo\\November\\employees.txt");

        // unix
        Path path3 = Paths.get("/home/zoodirector");

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        Path path12 = Paths.get("pandas","cuddly.png");
        Path path22 = Paths.get("c:","zooinfo","November","employees.txt");
        Path path32 = Paths.get("/","home","zoodirector");

        // Paths path13 = Paths.get("/alligator/swim.txt"); // DOES NOT COMPILE
        // Path path23 = Path.get("/crocodile/food.csv"); // DOES NOT COMPILE

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // Path path14 = Paths.get(new URI("file://pandas/cuddly.png")); // THROWS EXCEPTION
                                                                    // AT RUNTIME
        Path path24 = Paths.get(new URI("file:///c:/zoo-info/November/employees.txt"));
        Path path34 = Paths.get(new URI("file:///home/zoodirectory"));

        Path path4 = Paths.get(new URI("http://www.wiley.com"));
        Path path5 = Paths.get(
                new URI("ftp://username:password@ftp.the-ftp-server.com"));

        Path path45 = Paths.get(new URI("http://www.wiley.com"));
        URI uri45 = path45.toUri();

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        Path path16 = FileSystems.getDefault().getPath("pandas/cuddly.png");
        Path path26 = FileSystems.getDefault().getPath("c:","zooinfo","November",
                "employees.txt");
        Path path36 = FileSystems.getDefault().getPath("/home/zoodirector");

        FileSystem fileSystem = FileSystems.getFileSystem(
                new URI("http://www.selikoff.net"));
        Path path = fileSystem.getPath("duck.txt");

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // Legacy
        File file = new File("pandas/cuddly.png");
        Path path7 = file.toPath();

        Path path8 = Paths.get("cuddly.png");
        File file8 = path8.toFile();

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");




    }
}