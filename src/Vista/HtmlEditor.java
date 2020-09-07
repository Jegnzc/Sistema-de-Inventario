/*
 * To change this 
package javaapplication1;
license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.HTMLEditor;
import javax.swing.JPanel;

public class HtmlEditor{

    JPanel p = new JPanel();
    

    public void initAndShowGUI() {
       // This method is invoked on Swing thread
       final JFXPanel fxPanel = new JFXPanel();
       this.p.add(fxPanel);
       this.p.setSize(600,225);

       Platform.runLater(new Runnable() {
           @Override
           public void run() {
               initFX(fxPanel);
           }
       });
   }

    private static void initFX(JFXPanel fxPanel) {
       // This method is invoked on JavaFX thread
       Scene scene = createScene();
       fxPanel.setScene(scene);
   }

    private static Scene createScene() {
        
        HTMLEditor ht = new HTMLEditor();
        // Set the Height of the HTMLEditor
        ht.setPrefHeight(225);
        // Set the Width of the HTMLEditor
        ht.setPrefWidth(600);
        
        BorderPane pane = new BorderPane();
        pane.setCenter(ht);
        pane.setPrefSize(600, 208);
        
        Scene scene = new Scene(pane);
        
        return scene;
    }
}