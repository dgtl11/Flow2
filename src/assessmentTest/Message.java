// <editor-fold defaultstate="collapsed" desc="Title">
/*     Buch: - Flow2 / OCP Study Guide
 *  Kapitel: - 00 - Assessment Test
 *
 *    Thema: - 0.0 - get your Score evaluated
 *
 *  Listing: - 0.0.02 - Message.java
 *  
 *   IDEA Project
 *
 *    Autor: - Daniel dgtl
 *  </editor-fold> */

// import:

package assessmentTest;

public abstract class Message {
    public String recipient;
    public abstract /* final */ void sendMessage();   // abs can never be final
    public static void main(String[] args) {
        Message m = new TextMessage();
        m.recipient = "1234567890";
        m.sendMessage();
    }
    static class TextMessage extends Message {
        public final void sendMessage() {
            System.out.println("Text message to " + recipient);
        }
    }
}