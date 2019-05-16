// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 06 - Exceptions And Assertions
 *
 *    Thema: - 06.4 - working with assertions
 *
 *  Listing: - 06.4.15 - Whizlab.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt06.rev;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Whizlab {

    public static void main(String[] args) throws IOException {
        Path path1 = Paths.get("F:\\Whizlabs\\java\\nio\\myfile.txt");
        Path path2 = Paths.get(".\\myfile.txt");
        System.out.println(Files.isSameFile(path1,path2));


    }

    /*
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("1","2","3","4").parallel();
        IntStream ins = stream.mapToInt(s -> Integer.parseInt(s));

        System.out.println(ins.isParallel());
    }
    */

    /*
    public static void main(String[] args) throws InterruptedException {
        Thread tmine = new Thread();
        tmine.start();
        tmine.join(2000);
    }
    */

    /*
    public static void main(String[] args) {
        Set list = new HashSet();

        list.add("1");
        list.add("2");
        list.add("3");
        list.add("1");

        list.forEach(System.out::print);
    }
    */
    /*
    public void meth()throws Exception {
        for (int x =0; x>5;x++)
            System.out.println(x);
    }

    public static void main(String[] args) {
        // new Whizlab().meth();
    }
    */
}
