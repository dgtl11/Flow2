// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 08 - IO
 *
 *    Thema: - 08.7 - Review Questions
 *
 *  Listing: - 08.7.11 - RevTestClass.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

package chpt08.rev;

import java.io.*;

public class RevTestClass {
    public static void main(String[] args) throws IOException {

        // Review Questions
        System.out.println("~~~~01~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        InputStream is = new BufferedInputStream(new FileInputStream("zoo.txt"));
        InputStream wrapper = new BufferedInputStream(is);
        // BufferedInputStream
        //B. FileInputStream
        //C. BufferedWriter
        //D. ObjectInputStream
        //E. ObjectOutputStream
        //F. BufferedReader

        System.out.println("~~~~02~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("~~~~03~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("~~~~04~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("~~~~05~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        String line;
        Console c = System.console();
//        Writer w = c.writer();
//        if ((line = c.readLine()) != null)
//            w.append(line);
//        w.flush();

        System.out.println("~~~~06~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("~~~~07~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("~~~~08~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("~~~~09~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("~~~~10~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        /*
        public static void deleteTree (File file){
            if (!file.isFile())
                for (File entry : file.listFiles())
                    deleteTree(entry);
            else file.delete();
        }
        */

        System.out.println("~~~~11~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("~~~~12~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("~~~~13~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("~~~~14~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("~~~~15~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        /*
        private void echo() throws IOException {
            try (FileReader fileReader = new FileReader("zoo-data.txt");
                 BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                System.out.println(bufferedReader.readLine());
            }
        }
        */

        System.out.println("~~~~16~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("~~~~17~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("~~~~18~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        Console console = System.console();
        String color = console.readLine("What is your favorite color? ");
        console.format("Your favorite color is "+color);

        //A. print
        //B. printf
        //C. println
        //D. format
        //E. writer().println
        //F. out

        System.out.println("~~~~19~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("~~~~20~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("~~~~21~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("~~~~22~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("~~~~23~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        /*
        public static String pullBytes(InputStream is, int count) throws IOException
        {
            is.mark(count);
            final StringBuilder sb = new StringBuilder();
            for(int i=0; i<count; i++)
                sb.append((char)is.read());
            is.reset();
            is.skip(1);
            sb.append((char)is.read());
            return sb.toString();
        }
         */

    }

    // Q10
    public static void deleteTree (File file){
        if (!file.isFile())
            for (File entry : file.listFiles())
                deleteTree(entry);
        else file.delete();
    }

    // Q15
    private void echo() throws IOException {
        try (FileReader fileReader = new FileReader("zoo-data.txt");
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            System.out.println(bufferedReader.readLine());
        }
    }

    // Q23
    public static String pullBytes(InputStream is, int count) throws IOException
    {
        is.mark(count);
        final StringBuilder sb = new StringBuilder();
        for(int i=0; i<count; i++)
            sb.append((char)is.read());
        is.reset();
        is.skip(1);
        sb.append((char)is.read());
        return sb.toString();
    }
}