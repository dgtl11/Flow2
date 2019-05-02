package chpt05.Localization;

import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class RB_Kartei {
    public static void main(String[] args) {
        Locale locale = new Locale("");
        if(args.length == 0) {
            System.out.println("-----------------------------------------------");
            System.out.println("Leider haben Sie kein Sprachkuerzel mitgegeben,");
            System.out.println("Standartausgabe ist in Latein.");
            System.out.println("-----------------------------------------------");
            System.out.println("folgende Kuerzel stehen zur Verfuegung:");
            System.out.println("       de = Deutschland");
            System.out.println("       fr = Frankreich");
            System.out.println("       en = England");
            System.out.println("-----------------------------------------------");            
        } else {
            locale = new Locale(args[0]);
        }
        ResourceBundle rb = ResourceBundle.getBundle("chpt05//Localization//language//RB", locale);

        String windowTitle = rb.getString("domicile");        

        JFrame jframe = new JFrame();
        jframe.setSize(300, 150);
        JPanel panel = new JPanel();
        jframe.setDefaultCloseOperation (WindowConstants.EXIT_ON_CLOSE);
        jframe.setTitle(windowTitle);
        jframe.setSize(300, 100);
        //
        JLabel lfvName = new JLabel(rb.getString("forname"));
        JTextField tfvName = new JTextField("Julius", 15);
        panel.add(lfvName);
        panel.add(tfvName);
        JLabel lfnName = new JLabel(rb.getString("surname"));
        JTextField tfnName = new JTextField("Caesar",15);
        panel.add(lfnName);
        panel.add(tfnName);
        //
        jframe.add(panel);
        jframe.setVisible(true);
    }
}