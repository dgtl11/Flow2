// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 09 - NIO.2
 *
 *    Thema: - 09.3 - Understanding File Attributes
 *
 *  Listing: - 09.3.06 - BasicFileAttributeViewSample.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt09.xmpls.attributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

public class BasicFileAttributeViewSample {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/turtles/sea.txt");

        BasicFileAttributeView view = Files.getFileAttributeView(path,BasicFileAttributeView.class);

        BasicFileAttributes data = view.readAttributes();

        FileTime lastModifiedTime = FileTime.fromMillis(data.lastModifiedTime().toMillis()+10_000);

        view.setTimes(lastModifiedTime,null,null);
    }
}