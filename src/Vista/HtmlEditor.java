/*
 * To change this 
package javaapplication1;
license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.HTMLEditor;
import javax.swing.JPanel;

public class HtmlEditor{

    JPanel p = new JPanel();

    public JFXPanel fxPanel = new JFXPanel();
    
 
    
    HTMLEditor ht;

    public HTMLEditor getHt() {
        return ht;
    }

    public void setHt(HTMLEditor ht) {
        this.ht = ht;
    }
    
    public String getHTML(){
        String text = ht.getHtmlText();
        return text;
    }
    
    public void initAndShowGUI() {
       // This method is invoked on Swing thread
       
       int x = 600;
       int y = 199;
       this.p.add(fxPanel);
       
       this.p.setSize(x,y);
       

       Platform.runLater(new Runnable() {
           @Override
           public void run() {
               
               ht = new HTMLEditor();
               initFX(fxPanel, x, y, ht);
               
           }
       });
   }

    private void initFX(JFXPanel fxPanel, int x, int y, HTMLEditor ht) {
       // This method is invoked on JavaFX thread
       Scene scene = createScene(x, y, ht);
       fxPanel.setScene(scene);
   }

    public Scene createScene(int x, int y, HTMLEditor ht) {
        
        
        // Set the Height of the HTMLEditor
        ht.setPrefHeight(y);
        // Set the Width of the HTMLEditor
        ht.setPrefWidth(x);
        BorderPane pane = new BorderPane();
        pane.setCenter(ht);
        pane.setPrefSize(x,y);
        
        Scene scene = new Scene(pane);
        
        return scene;
    }
    

    
}