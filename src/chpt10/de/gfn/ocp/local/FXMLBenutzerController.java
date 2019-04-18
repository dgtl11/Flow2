/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chpt10.de.gfn.ocp.local;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 *
 * @author Student
 */
public class FXMLBenutzerController implements Initializable {
    
    @FXML
    private TextField txt_Id;
    
    @FXML
    private TextField txt_Vorname;
    
    @FXML
    private TextField txt_Nachname;
    
    @FXML
    private Button btn_Speichern;
    
    @FXML
    private TableView<Benutzer> tbl_Benutzer;
    
    @FXML
    private void speichernAction(ActionEvent event) {
         String vorname = txt_Vorname.getText();
         String nachname = txt_Nachname.getText();
         // int id = Integer.parseInt(txt_Id.getText());
         
         Benutzer benutzer = new Benutzer();
         int id = 0;
         
         try {
             id = Integer.parseInt(txt_Id.getText());
             
             if(id > 0) {
                 try {
                     benutzer = BenutzerGateway.find(id);
                 } catch (SQLException ex) {
                     System.out.println(ex.getMessage());
                 }
             }
         }
         catch (NumberFormatException e) {
             id = 0;
         }
         
         
         // Benutzer benutzer = new Benutzer();
         benutzer.setVorname(vorname);
         benutzer.setNachname(nachname);
         
        try {
            BenutzerGateway.save(benutzer);
            refreshTable();
            txt_Id.setText("");
            txt_Vorname.setText("");
            txt_Nachname.setText("");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    @FXML
    private void loeschenAction(ActionEvent event) {
        // ObservableList<Benutzer> benutzer = tbl_Benutzer.getSelectionModel().getSelectedItems();
        // System.out.println(benutzer.get(0).getVorname());
        Benutzer benutzer = tbl_Benutzer.getSelectionModel().getSelectedItem();
        try {
            BenutzerGateway.delete(benutzer.getId());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            refreshTable();
        }
        refreshTable();
    }
    
    @FXML
    private void bearbeitenAction(ActionEvent event) {
        Benutzer benutzer = tbl_Benutzer.getSelectionModel().getSelectedItem();
        txt_Id.setText(benutzer.getId() + "");
        
        txt_Vorname.setText(benutzer.getVorname());
        txt_Nachname.setText(benutzer.getNachname());
        // refreshTable();
    }
    
    private void refreshTable() {
        try {
            List<Benutzer> list = BenutzerGateway.findAll(); 
            tbl_Benutzer.setItems(FXCollections.observableList(list));
        }
        catch(SQLException e) {
            // TODO: sinnvoll ausgeben 
            System.out.println(e.getMessage());
        }
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // tbl_Benutzer.getSelectionModel().setCellSelectionEnabled(true);
        // ObservableList selectedCells = tbl_Benutzer.getSelectionModel().getSelectedCells();
        refreshTable();
    }    
    
}
