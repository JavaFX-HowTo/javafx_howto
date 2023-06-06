import java.util.Optional;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AlertExample extends Application
{
    @Override
    public void start(Stage window) throws Exception
    {
        VBox root = new VBox();

        Button informationButton = new Button("Information Alert");
        informationButton.setOnAction(e -> {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Hi");
            alert.setHeaderText(null);
            alert.setContentText("Hi there");
            alert.showAndWait();
        });

        Button confirmButton = new Button("Confirm Alert");
        confirmButton.setOnAction(e -> {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirm");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure?");
            Optional<ButtonType> option = alert.showAndWait();
            System.out.println(option.get());
            if (option.get().equals(ButtonType.OK))
            {
                System.out.println("Choose OK");
            }
            else if (option.get().equals(ButtonType.CANCEL))
            {
                System.out.println("Choose CANCEL");
            }
        });

        Button errorButton = new Button("Error Alert");
        errorButton.setOnAction(e -> {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Your program has got an error");
            alert.showAndWait();
        });

        root.getChildren().addAll(informationButton, confirmButton, errorButton);

        Scene scene = new Scene(root, 400, 300);

        window.setScene(scene);
        window.setTitle(this.getClass().getSimpleName());
        window.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}