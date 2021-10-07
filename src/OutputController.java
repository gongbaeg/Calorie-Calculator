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
import java.io.IOException;
import javafx.animation.*;
import javafx.util.*;  
import javafx.fxml.*; 

import javafx.fxml.FXML; 
import javafx.scene.control.Label; 

public class OutputController {
    @FXML 
    Label nameLabel1;
    Label nameLabel2; 
    Label nameLabel3; 
    Label nameLabel4; 
    
    public void displayCalories(String calculation){
        nameLabel1.setText(calculation); 
        nameLabel2.setText(Integer.toString(Integer.parseInt(calculation) - 100)); 
        nameLabel3.setText(Integer.toString(Integer.parseInt(calculation) - 250));
        nameLabel4.setText(Integer.toString(Integer.parseInt(calculation) - 500));
    }
}