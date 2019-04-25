// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 09 - NIO.2
 *
 *    Thema: - 09.2 - Interaction Paths + Files
 *
 *  Listing: - 09.2.02 - PathNFilesTester.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt09.xmpls.pathsnfiles;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathNFilesTester {
    public static void main(String[] args) throws IOException {

        Paths.get("/zoo/../home").getParent().normalize().toAbsolutePath();

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // getFileName(), getParent(),
        // and getRoot()

        Path path = Paths.get("/land/hippo/harry.happy");
        System.out.println("The Path Name is: "+path);
        for(int i=0; i<path.getNameCount(); i++) {
            System.out.println(" Element "+i+" is: "+path.getName(i));
        }

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");


        // isAbsolute() and toAbsolutePath()
        Path path1 = Paths.get("C:\\birds\\egret.txt");
        System.out.println("Path1 is Absolute? "+path1.isAbsolute());
        System.out.println("Absolute Path1: "+path1.toAbsolutePath());
        Path path2 = Paths.get("birds/condor.txt");
        System.out.println("Path2 is Absolute? "+path2.isAbsolute());
        System.out.println("Absolute Path2 "+path2.toAbsolutePath());

        System.out.println(Paths.get("/stripes/zebra.exe").isAbsolute());
        System.out.println(Paths.get("c:/goats/Food.java").isAbsolute());

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");


        // subpath()
        Path path3 = Paths.get("/mammal/carnivore/raccoon.image");
        System.out.println("Path is: "+path3);
        System.out.println("Subpath from 0 to 3 is: "+path3.subpath(0,3));
        System.out.println("Subpath from 1 to 3 is: "+path3.subpath(1,3));
        System.out.println("Subpath from 1 to 2 is: "+path3.subpath(1,2));

        // System.out.println("Subpath from 0 to 4 is: "+path.subpath(0,4));    // THROWS
                                                                                // EXCEPTION AT RUNTIME
        // System.out.println("Subpath from 1 to 1 is: "+path.subpath(1,1));    // THROWS
                                                                                // EXCEPTION AT RUNTIME

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // relativize()
        Path path14 = Paths.get("fish.txt");
        Path path24 = Paths.get("birds.txt");
        System.out.println(path14.relativize(path24));
        System.out.println(path24.relativize(path14));

        // output:
        // ..\birds.txt
        // ..\fish.txt

        Path path34 = Paths.get("E:\\habitat");
        Path path44 = Paths.get("E:\\sanctuary\\raven");
        System.out.println(path34.relativize(path44));
        System.out.println(path44.relativize(path34));

        // output:
        // ..\sanctuary\raven
        // ..\..\habitat

        // Compatible Path Types for relativize()
        Path path15 = Paths.get("/primate/chimpanzee");
        Path path25 = Paths.get("bananas.txt");
        // Path15.relativize(path3); // THROWS EXCEPTION AT RUNTIME

        Path path36 = Paths.get("c:\\primate\\chimpanzee");
        Path path46 = Paths.get("d:\\storage\\bananas.txt");
        // path36.relativize(path46); // THROWS EXCEPTION AT RUNTIME


        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // resolve()
        final Path path17 = Paths.get("/cats/../panther");
        final Path path27 = Paths.get("food");
        System.out.println(path17.resolve(path27));

        // output:
        // /cats/../panther/food

        final Path path18 = Paths.get("/turkey/food");
        final Path path28 = Paths.get("/tiger/cage");
        System.out.println(path18.resolve(path28));

        // output:
        // /tiger/cage

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // normalize()
        Path path39 = Paths.get("E:\\data");
        Path path49 = Paths.get("E:\\user\\home");
        Path relativePath = path39.relativize(path49);
        System.out.println(path39.resolve(relativePath));

        // E:\data\..\\user\home        // should just be on slash but needs to be escaped

        System.out.println(path39.resolve(relativePath).normalize());

        // E:\\user\home  // should just be on slash but needs to be escaped

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // toRealPath()
        try {
            System.out.println(Paths.get("/zebra/food.source").toRealPath());
            System.out.println(Paths.get(".././food.txt").toRealPath());
        } catch (IOException e) {
            // Handle file I/O exception...
        }

        // /horse/food.txt
        // /horse/food.txt

        System.out.println(Paths.get(".").toRealPath());

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

    }
}