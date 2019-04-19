/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chpt10.javafxmltest;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


public class FXMLMainScreenController implements Initializable {
    
    // @FXML
    // private Label label;
    
    private List<Benutzer> benutzer = new ArrayList<>();
    
    @FXML
    private TextField txt_Nachname;
    
    @FXML
    private TextField txt_Vorname;
    
    @FXML
    private Button btn_Speichern;
    
    @FXML
    private TableView tbl_Benutzer;
    
    @FXML
    private Label alert;
    
    
    @FXML
    private void speichernAction(ActionEvent event) {
        benutzer.add(new Benutzer(txt_Vorname.getText(), txt_Nachname.getText()));
        txt_Vorname.setText("");
        txt_Nachname.setText("");
        alert.setText("Benutzer wurde gespeichert");
        updateTable();
        
    }
    
    private void updateTable() {
        
        ObservableList<Benutzer> list = FXCollections.observableArrayList(benutzer);
        tbl_Benutzer.setItems(list);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
