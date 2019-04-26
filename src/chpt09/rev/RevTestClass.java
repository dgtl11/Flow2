// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 09 - NIO.2
 *
 *    Thema: - 09.8 - Review Q
 *
 *  Listing: - 09.8.20 - RevTestClass.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt09.rev;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RevTestClass {
    public static void main(String[] args) throws IOException, URISyntaxException {

        // System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println(" 01 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
/*
        Path path = Path.get("/user/.././root","../kodiacbear.txt");
        path.normalize().relativize("/lion");
        System.out.println(path);
*/
        System.out.println(" 02 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
/*
        Path path = ____________________;
        if(Files.isDirectory(path))
            System.out.println(Files.deleteIfExists(path) ? "Success": "Try Again");
*/
        System.out.println(" 03 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
/*
        Path path = Paths.get("sloth.schedule");
        BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
        if(attributes.size()>0 && attributes.creationTime().toMillis()>0) {
            attributes.setTimes(null,null,null);
            }
*/
        System.out.println(" 04 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        Path path = Paths.get("/zoo/animals/bear/koala/food.txt");
        System.out.println(path.subpath(1,3).getName(1).toAbsolutePath());

        // C:\Users\Student\Documents\IdeaProjects\Flow2\bear

        System.out.println(" 05 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        Path path22 = Paths.get("/kang");
        if(Files.isDirectory(path22) && Files.isSymbolicLink(path22))
            Files.createDirectory(path22.resolve("joey"));

        System.out.println(" 06 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
/*
        Path path3 = Paths.get("/animals");
        boolean myBoolean = Files.walk(path3)
                .filter((p,a) -> a.isDirectory() && !path3.equals(p)) // w1   // Error
                .findFirst().isPresent(); // w2
        System.out.println(myBoolean ? "No Sub-directory": "Has Sub-directory");
*/
        System.out.println(" 07 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
/*
        Path path4 = Paths.get("turkey");
        if(Files.isSameFile(path4,Paths.get("/zoo/turkey"))) // x1 // Xcptn
            Files.createDirectory(path4.resolve("info")); // x2
*/
        System.out.println(" 08 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        Path path1 = Paths.get("/pets/../cat.txt");
        Path path2 = Paths.get("./dog.txt");
        System.out.println(path1.resolve(path2));
        System.out.println(path2.resolve(path1));

        // \pets\..\cat.txt\.\dog.txt
        // \pets\..\cat.txt

        System.out.println(" 09 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
/*
        Files.move(Paths.get("monkey.txt"), Paths.get("/animals"),
                StandardCopyOption.ATOMIC_MOVE,
                LinkOption.NOFOLLOW_LINKS);
*/
        // java.nio.file.NoSuchFileException: monkey.txt -> \animals

        System.out.println(" 10 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println(" 11 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
/*
        Path path11 = Paths.get("./goat.txt").normalize(); // k1
        Path path21 = Paths.get("mule.png");
        Files.copy(path11,path21,StandardCopyOption.COPY_ATTRIBUTES); //k2
        System.out.println(Files.isSameFile(path11, path21)); //k3
*/
        // NoSuchFileEx

        System.out.println(" 12 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // new Path("jaguar.txt")               // abs meth cannot be instanciated
        FileSystems.getDefault().getPath("puma.txt");
        // Paths.get(new URI("cheetah.txt"));              // missing scheme
        Paths.get("cats","lynx.txt");
        new java.io.File("tiger.txt").toPath();
        // new FileSystem().getPath("leopard")  // abs meth cannot be instanciated
        // Paths.getPath("ocelot.txt");        // cannot resolve meth

        System.out.println(" 13 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
/*
        Path path13 = Paths.get("/monkeys");
        Files.find(path13, 0, (p,a) -> a.isSymbolicLink()).map(p -> p.toString()) // y1
                .collect(Collectors.toList()) // y2
                .stream() // y3
                .filter(x -> x.toString().endsWith(".txt")) // y4
                .forEach(System.out::println);
*/
        // NoSuchFileEx

        System.out.println(" 14 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println(" 15 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println(" 16 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
/*
        Path path16 = Paths.get("/squid/food-schedule.csv");
        Files.lines(path16) // r1
                .flatMap(p -> Stream.of(p.split(","))) // r2
                .map(s -> s.toUpperCase()) // r3
                .forEach(System.out::println);
*/
        // NoSuchFileEx

        System.out.println(" 17 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
/*
        Files.walk(Paths.get("..").toRealPath().getParent()) // u1
                .map(p -> p.toAbsolutePath().toString()) // u2
                .filter(s -> s.endsWith(".java")) // u3
                .collect(Collectors.toList())
                .forEach(System.out::println);
*/
        // java.nio.file.AccessDeniedException: C:\Users\Student\Documents\Eigene Bilder

        System.out.println(" 18 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
/*
        Path path18 = Paths.get("/lizard/./").resolve(Paths.get("walking.txt"));
        Path path28 = new File("/lizard/././actions/../walking.txt").toPath();
        System.out.print(Files.isSameFile(path18,path28));
        System.out.print(" "+path18.equals(path28));
        System.out.print(" "+path18.normalize().equals(path28.normalize()));
*/
        // NoSuchFileException: \lizard\.\walking.txt

        System.out.println(" 19 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println(" 20 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        final Path path20 = Paths.get(".").normalize(); // h1
        int count = 0;
        for(int i=0; i<path.getNameCount(); ++i) {
            count++;
        }
        System.out.println(count);

        // System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

    }
}