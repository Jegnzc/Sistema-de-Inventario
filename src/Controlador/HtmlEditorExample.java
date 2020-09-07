
package Controlador;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;
 
public class HtmlEditorExample extends Application
{
    public static void main(String[] args)
    {
        Application.launch(args);
    }
 
    @Override
    public void start(Stage stage)
    {
        // Create the HTMLEditor
        HTMLEditor htmlEditor = new HTMLEditor();
        // Set the Height of the HTMLEditor
        htmlEditor.setPrefHeight(300);
        // Set the Width of the HTMLEditor
        htmlEditor.setPrefWidth(600);
 
        // Create the Scene
        Scene scene = new Scene(htmlEditor);
        // Add the Scene to the Stage
        stage.setScene(scene);
        // Set the Title of the Stage
        stage.setTitle("Prueba");
        // Display the Stage
        stage.show();
    }
}