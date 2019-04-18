/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chpt10.de.gfn.ocp.local;

import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Student
 */
public class App extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        try {
            BenutzerGateway.createTable();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        ResourceBundle bundle = ResourceBundle.getBundle("chpt10.de.gfn.ocp.lang.strings", Locale.getDefault());
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLBenutzer.fxml"), bundle);
        
        // Parent root = FXMLLoader.load(getClass().getResource("FXMLLokaleBenutzerVerwaltung.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
