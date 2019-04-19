/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chpt10.javafxtest;

import javafx.application.Application;
import javafx.event.ActionEvent;

import javafx.event.EventHandler;

import javafx.scene.Scene;

import javafx.scene.control.Button;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class App extends Application {

    Label lbl = new Label();
    
    @Override
    public void start(Stage primaryStage) {
        // Label lbl = new Label();
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        
        EventHandler<ActionEvent> handeler = (e) -> lbl.setText("Hallo Welt!");
        

        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                lbl.setText("Hallo Welt!");
                //System.out.println("Hello World!");
            }
        });

        
        // btn.setOnAction(handeler);

        btn.setOnAction(this::machWas);
        
        Button btn1 = new Button("Moin Moin!");
        
        // StackPane root = new StackPane();
        
        // Label lbl = new Label();
        
        GridPane root = new GridPane();
        
        // HBox box = new HBox(btn, btn1);
        // root.getChildren().add(box);
        
        root.add(btn, 0, 0);
        root.add(lbl, 1, 0);
        root.add(btn1, 0, 1);
        
        Scene scene = new Scene(root, 400, 400);
        
        primaryStage.setTitle("Eine Super App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void machWas(ActionEvent e) {
        lbl.setText("Hallo Welt!");
    }
    


    public static void main(String[] args) {
        launch(args);
    }
    
}


