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

public class InputController {
    
    @FXML
    private TextField ageText1; 
    @FXML 
    private RadioButton maleButton1; 
    @FXML 
    private RadioButton femaleButton1; 
    @FXML 
    private TextField feetText; 
    @FXML 
    private TextField inchText; 
    @FXML 
    private TextField poundsText; 
    @FXML 
    private SplitMenuButton activityLevel1; 
    
    @FXML
    private TextField ageText2; 
    @FXML 
    private RadioButton maleButton2; 
    @FXML 
    private RadioButton femaleButton2; 
    @FXML 
    private TextField centimeterText; 
    @FXML 
    private TextField kilogramText; 
    @FXML 
    private SplitMenuButton activityLevel2; 

    @FXML
    private Button USButton; 
    @FXML 
    private Button metricButton;

    private Stage stage; 
    private Scene scene; 
    private Parent root;

    int age; 
    int centimeterHeight; 
    int kilogramsWeight; 
    int feetHeight; 
    int inchHeight; 
    int poundsWeight; 

    public boolean getGender(){
        if(maleButton1.isSelected() || maleButton2.isSelected()){
            return true; 
        } else if(femaleButton1.isSelected() || femaleButton2.isSelected()){
            return false; 
        } else {
            System.out.println("Click a gender"); 
        }
        return false; 
    }

    public void submitUS(ActionEvent event) throws IOException{
        try{
            age = Integer.parseInt(ageText1.getText()); 
            feetHeight = Integer.parseInt(feetText.getText()); 
            inchHeight = Integer.parseInt(inchText.getText()); 
            poundsWeight = Integer.parseInt(poundsText.getText()); 
        
        }
        catch(NumberFormatException e){
            System.out.println("Enter a number"); 
        }
        catch(Exception e){
            System.out.println(e); 
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("resultsScene.fxml")); 
        root = loader.load(); 
    
        OutputController outputController = loader.getController(); 
        outputController.displayCalories(Integer.toString(calculateUS(age, getGender(), feetHeight, inchHeight, kilogramsWeight, 4))); 


        stage = (Stage)((Node)event.getSource()).getScene().getWindow(); 
        scene = new Scene(root); 
        stage.setScene(scene); 
        stage.show(); 
    }

    public void submitMetric(ActionEvent event) throws IOException{
        try{
            age = Integer.parseInt(ageText2.getText()); 
            centimeterHeight = Integer.parseInt(centimeterText.getText()); 
            kilogramsWeight = Integer.parseInt(kilogramText.getText()); 
            
        }
        catch(NumberFormatException e){
            System.out.println("Enter a number"); 
        }
        catch(Exception e){
            System.out.println(e); 
        } 

        FXMLLoader loader = new FXMLLoader(getClass().getResource("resultsScene.fxml")); 
        root = loader.load(); 

        OutputController outputController = loader.getController(); 
        outputController.displayCalories(Integer.toString(calculateMetric(age, getGender(), centimeterHeight, kilogramsWeight, 2))); 
        
        root = FXMLLoader.load(getClass().getResource("resultsScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow(); 
        scene = new Scene(root); 
        stage.setScene(scene); 
        stage.show(); 
    }

    public int calculateUS(int age, boolean gender, int feetHeight, int inchHeight, int poundsWeight, int activity){
        int calculation;
        if(gender){
            calculation = (int)(66.47 + (6.24 * poundsWeight) + (12.7 * ((12 * feetHeight) + inchHeight)) - (6.755 * age)); 
        } else {
            calculation = (int)(655.1 + (4.35 * poundsWeight) + (4.7 * ((12 * feetHeight) + inchHeight)) - (4.7 * age));
        }
        return calculation; 

    }

    public int calculateMetric(int age, boolean gender, int centimeterHeight, int kilogramsWeight, int activity){
        int calculation;
        if(gender){
            calculation = (int) ((10 * kilogramsWeight) + (6.25 * centimeterHeight) - (5 * age) + 5);  
        }else {
            calculation = (int) ((10 * kilogramsWeight) + (6.25 * centimeterHeight) - (5 * age) - 161);  
        }
        
        return calculation; 
        
    }
}
