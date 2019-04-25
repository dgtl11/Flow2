// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 09 - NIO.2
 *
 *    Thema: - 09.3 - Understanding File Attributes
 *
 *  Listing: - 09.3.04 - BasicFileAttributesSample.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt09.xmpls.attributes;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.UserPrincipal;

public class BasicAttributesTester {
    public static void main(String[] args) throws IOException {

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // isDirectory(), isRegularFile(),
        // and isSymbolicLink()
        Files.isDirectory(Paths.get("/canine/coyote/fur.jpg"));
        Files.isRegularFile(Paths.get("/canine/types.txt"));
        Files.isSymbolicLink(Paths.get("/canine/coyote"));

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // isHidden()
        try {
            System.out.println(Files.isHidden(Paths.get("/walrus.txt")));
        } catch (IOException e) {
            // Handle file I/O exception...
        }


        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // isReadable() and isExecutable()
        System.out.println(Files.isReadable(Paths.get("/seal/baby.png")));
        System.out.println(Files.isExecutable(Paths.get("/seal/baby.png")));

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // Length with size()
        try {
            System.out.println(Files.size(Paths.get("/zoo/c/animals.txt")));
        } catch (IOException e) {
            // Handle file I/O exception...
        }

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // getLastModifiedTime() and
        // setLastModifiedTime()
        try {
            final Path path = Paths.get("/rabbit/food.jpg");
            System.out.println(Files.getLastModifiedTime(path).toMillis());
            Files.setLastModifiedTime(path,
                    FileTime.fromMillis(System.currentTimeMillis()));
            System.out.println(Files.getLastModifiedTime(path).toMillis());
        } catch (IOException e) {
            // Handle file I/O exception...
        }

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // getOwner() and setOwner()
        UserPrincipal owner = FileSystems.getDefault().getUserPrincipalLookupService().lookupPrincipalByName("jane");

        Path path2 = Paths.get("/rabbit/food.jpg");      // not correct
        UserPrincipal owner2 = path2.getFileSystem().getUserPrincipalLookupService().lookupPrincipalByName("jane");

        try {
            // Read owner of file
            Path path3 = Paths.get("/chicken/feathers.txt");
            System.out.println(Files.getOwner(path3).getName());
                // Change owner of file
            UserPrincipal owner3 = path3.getFileSystem()
                    .getUserPrincipalLookupService().lookupPrincipalByName("jane");
            Files.setOwner(path3, owner3);
                // Output the updated owner information
            System.out.println(Files.getOwner(path3).getName());
        } catch (IOException e) {
            // Handle file I/O exception...
        }


        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");


        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");


    }
}