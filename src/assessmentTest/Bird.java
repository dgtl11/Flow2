// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 00 - Assessment Test
 *
 *    Thema: - 0.0 - get your Score evaluated
 *
 *  Listing: - 0.0.03 - Bird.java
 *
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

// import:

package assessmentTest;

import java.io.*;

class Tail {
}

public class Bird implements Serializable {
    private String name;
    private transient int age;
    private Tail tail;

    public String getName() {
        return name;
    }

    public Tail getTail() {
        return tail;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTail(Tail tail) {
        this.tail = tail;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void main(String[] args) throws IOException {
        try (InputStream is = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream("birds.dat")))) {
            // Bird bird = is.readObject();
        }
    }
}