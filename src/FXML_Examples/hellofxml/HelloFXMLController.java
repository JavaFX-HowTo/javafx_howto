package hellofxml;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;

public class HelloFXMLController {
    public Label helloLabel;

    public void handleButtonClick(ActionEvent actionEvent) {
        helloLabel.setText("Welcome");
    }
}
