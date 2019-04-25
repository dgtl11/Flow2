package chpt08.ios;

import java.io.Console;
import java.util.Arrays;
import java.io.IOException;

public class Password {
    
    public static void main (String args[]) throws IOException {

        Console c = System.console();
        if (c == null) {
            System.err.println("Keine JAVA-Konsole vorhanden.");
            System.exit(1);
        }

        String login = c.readLine("Login-Name: ");
        char [] oldPassword = c.readPassword("Ihr altes Passwort: ");

        if (verify(login, oldPassword)) {
            boolean noMatch;
            do {
                char [] newPassword1 = c.readPassword("Ihr neues Passwort: ");
                char [] newPassword2 = c.readPassword("Bitte nochmals Ihr neues Passwort: ");
                noMatch = ! Arrays.equals(newPassword1, newPassword2);
                if (noMatch) {
                    c.format("Passwort war nicht korrekt. Nächster Versuch.%n");
                } else {
                    change(login, newPassword1);
                    c.format("Passwort für %s geändert.%n", login);
                }
                Arrays.fill(newPassword1, ' ');
                Arrays.fill(newPassword2, ' ');
            } while (noMatch);
        }

        Arrays.fill(oldPassword, ' ');
    }
    
    // Dummy change method.
    static boolean verify(String login, char[] password) {
        // This method always returns
        // true in this example.
        // Modify this method to verify
        // password according to your rules.
        return true;
    }

    // Dummy change method.
    static void change(String login, char[] password) {
        // Modify this method to change
        // password according to your rules.
    }
}