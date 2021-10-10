import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class OutputController {
    @FXML
    Label nameLabel1;
    @FXML
    Label nameLabel2;
    @FXML
    Label nameLabel3;
    @FXML
    Label nameLabel4;

    public void displayCalories(int calculation){
        nameLabel1.setText(Integer.toString(calculation));
        nameLabel2.setText(Integer.toString(calculation - 100));
        nameLabel3.setText(Integer.toString(calculation - 250));
        nameLabel4.setText(Integer.toString(calculation - 500));
    }

}
