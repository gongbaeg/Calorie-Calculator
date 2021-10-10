package com.example.caloriecalc;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

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
    private Button USButton;
    @FXML
    private Button metricButton;

    @FXML
    private MenuButton USActivityMenu;
    @FXML
    private MenuButton metricActivityMenu;

    private Stage stage;
    private Scene scene;
    private Parent root;

    int age;
    int centimeterHeight;
    int kilogramsWeight;
    int feetHeight;
    int inchHeight;
    int poundsWeight;
    int USActivity;
    int metricActivity;

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

    public void submitUS(ActionEvent event) throws IOException {
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
        outputController.displayCalories(calculateUS(age, getGender(), feetHeight, inchHeight, kilogramsWeight, USActivity));

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
        outputController.displayCalories(calculateMetric(age, getGender(), centimeterHeight, kilogramsWeight, metricActivity));

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public int calculateUS(int age, boolean gender, int feetHeight, int inchHeight, int poundsWeight, int USActivity) {
        if(USActivity == 1) {
            if (gender) {
                return (int) (66.47 + (6.24 * poundsWeight) + (12.7 * ((12 * feetHeight) + inchHeight)) - (6.755 * age));
            } else {
                return (int) (655.1 + (4.35 * poundsWeight) + (4.7 * ((12 * feetHeight) + inchHeight)) - (4.7 * age));
            }
        }else if (USActivity == 2) {
            if (gender) {
                return (int) ((66.47 + (6.24 * poundsWeight) + (12.7 * ((12 * feetHeight) + inchHeight)) - (6.755 * age)) * 1.2);
            } else {
                return (int) ((655.1 + (4.35 * poundsWeight) + (4.7 * ((12 * feetHeight) + inchHeight)) - (4.7 * age)) * 1.2);
            }
        } else if(USActivity == 3) {
            if (gender) {
                return (int) (66.47 + ((6.24 * poundsWeight) + (12.7 * ((12 * feetHeight) + inchHeight)) - (6.755 * age)) * 1.4);
            } else {
                return (int) ((655.1 + (4.35 * poundsWeight) + (4.7 * ((12 * feetHeight) + inchHeight)) - (4.7 * age)) * 1.4);
            }
        }else if(USActivity == 4){
            if (gender) {
                return (int) ((66.47 + (6.24 * poundsWeight) + (12.7 * ((12 * feetHeight) + inchHeight)) - (6.755 * age)) * 1.6);
            } else {
                return (int) ((655.1 + (4.35 * poundsWeight) + (4.7 * ((12 * feetHeight) + inchHeight)) - (4.7 * age)) * 1.6);
            }
        }else if(USActivity == 5){
            if (gender) {
                return (int) ((66.47 + (6.24 * poundsWeight) + (12.7 * ((12 * feetHeight) + inchHeight)) - (6.755 * age)) * 1.8);
            } else {
                return (int) ((655.1 + (4.35 * poundsWeight) + (4.7 * ((12 * feetHeight) + inchHeight)) - (4.7 * age)) * 1.8);
            }
        }else if(USActivity == 6){
            if (gender) {
                return (int) ((66.47 + (6.24 * poundsWeight) + (12.7 * ((12 * feetHeight) + inchHeight)) - (6.755 * age)) * 2);
            } else {
                return (int) ((655.1 + (4.35 * poundsWeight) + (4.7 * ((12 * feetHeight) + inchHeight)) - (4.7 * age)) * 2);
            }
        }else if(USActivity == 7) {
            if (gender) {
                return (int) ((66.47 + (6.24 * poundsWeight) + (12.7 * ((12 * feetHeight) + inchHeight)) - (6.755 * age)) * 100);
            } else {
                return (int) ((655.1 + (4.35 * poundsWeight) + (4.7 * ((12 * feetHeight) + inchHeight)) - (4.7 * age)) * 100);
            }
        }
        return 2000;
    }

    public int calculateMetric(int age, boolean gender, int centimeterHeight, int kilogramsWeight, int metricActivity){
        if(metricActivity == 1) {
            if (gender) {
                return (int) (((10 * kilogramsWeight) + (6.25 * centimeterHeight) - (5 * age) + 5) * 1.2);
            } else {
                return (int) (((10 * kilogramsWeight) + (6.25 * centimeterHeight) - (5 * age) - 161) * 1.2);
            }
        } else if(metricActivity == 2){
            if (gender) {
                return (int) ((10 * kilogramsWeight) + (6.25 * centimeterHeight) - (5 * age) + 5);
            } else {
                return (int) ((10 * kilogramsWeight) + (6.25 * centimeterHeight) - (5 * age) - 161);
            }
        }else if(metricActivity == 3){
            if (gender) {
                return (int) ((10 * kilogramsWeight) + (6.25 * centimeterHeight) - (5 * age) + 5);
            } else {
                return (int) ((10 * kilogramsWeight) + (6.25 * centimeterHeight) - (5 * age) - 161);
            }
        }else if(metricActivity == 4){
            if (gender) {
                return (int) ((10 * kilogramsWeight) + (6.25 * centimeterHeight) - (5 * age) + 5);
            } else {
                return (int) ((10 * kilogramsWeight) + (6.25 * centimeterHeight) - (5 * age) - 161);
            }
        }else if(metricActivity == 5){
            if (gender) {
                return (int) ((10 * kilogramsWeight) + (6.25 * centimeterHeight) - (5 * age) + 5);
            } else {
                return (int) ((10 * kilogramsWeight) + (6.25 * centimeterHeight) - (5 * age) - 161);
            }
        }else if(metricActivity == 6){
            if (gender) {
                return (int) ((10 * kilogramsWeight) + (6.25 * centimeterHeight) - (5 * age) + 5);
            } else {
                return (int) ((10 * kilogramsWeight) + (6.25 * centimeterHeight) - (5 * age) - 161);
            }
        }else if(metricActivity == 7){
            if (gender) {
                return (int) ((10 * kilogramsWeight) + (6.25 * centimeterHeight) - (5 * age) + 5);
            } else {
                return (int) ((10 * kilogramsWeight) + (6.25 * centimeterHeight) - (5 * age) - 161);
            }
        }
        return 2000;
    }

    public void USActivity1(ActionEvent event){
        USActivity = 1;
        USActivityMenu.setText("Basal Metabolic Rate (BMR)");
    }

    public void USActivity2(ActionEvent event){
        USActivity = 2;
        USActivityMenu.setText("Sedentary: Little to no exercise");
    }
    public void USActivity3(ActionEvent event){
        USActivity = 3;
        USActivityMenu.setText("Light: Exercise 1-3 times/week");
    }
    public void USActivity4(ActionEvent event){
        USActivity = 4;
        USActivityMenu.setText("Moderate: Exercise 4-5 times/week");
    }
    public void USActivity5(ActionEvent event){
        USActivity = 5;
        USActivityMenu.setText("Active: Daily exercise or intense exercise 3-4 times/week");
    }
    public void USActivity6(ActionEvent event){
        USActivity = 6;
        USActivityMenu.setText("Very Active: Intense exercise 6-7 times/week");
    }
    public void USActivity7(ActionEvent event){
        USActivity = 7;
        USActivityMenu.setText("ABSOLUTE CHAD MODE: David Goggins type stuff");
    }


    public void MetricActivity1(ActionEvent event){
        metricActivity = 1;
        metricActivityMenu.setText("Basal Metabolic Rate (BMR)");
    }
    public void MetricActivity2(ActionEvent event){
        metricActivity = 2;
        metricActivityMenu.setText("Sedentary: Little to no exercise");
    }
    public void MetricActivity3(ActionEvent event){
        metricActivity = 3;
        metricActivityMenu.setText("Light: Exercise 1-3 times/week");
    }
    public void MetricActivity4(ActionEvent event){
        metricActivity = 4;
        metricActivityMenu.setText("Moderate: Exercise 4-5 times/week");
    }
    public void MetricActivity5(ActionEvent event){
        metricActivity = 5;
        metricActivityMenu.setText("Active: Daily exercise or intense exercise 3-4 times/week");
    }
    public void MetricActivity6(ActionEvent event){
        metricActivity = 6;
        metricActivityMenu.setText("Very Active: Intense exercise 6-7 times/week");
    }
    public void MetricActivity7(ActionEvent event){
        metricActivity = 7;
        metricActivityMenu.setText("ABSOLUTE CHAD MODE: David Goggins type stuff");
    }
}
