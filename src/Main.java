import javafx.application.Application; 
import javafx.scene.*; 
import javafx.scene.control.*; 
import javafx.scene.layout.*; 
import javafx.stage.*; 
import javafx.event.*; 
import javafx.scene.shape.*; 
import javafx.scene.paint.*; 
import javafx.scene.effect.*; 
import javafx.scene.text.*; 
import javafx.scene.image.*; 
import javafx.scene.transform.*; 
import javafx.animation.*;
import javafx.util.*;  
import javafx.fxml.*; 

public class Main extends Application {

    public static void main(String[] args){
        launch(args); 
    }

    @Override
    public void start(Stage stage) throws Exception {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("inputScene.fxml")); 
            Scene scene = new Scene(root); 
            
            stage.setScene(scene); 
            stage.show(); 
        }
        catch(Exception e){
            e.printStackTrace(); 
        }
    }
    
}
