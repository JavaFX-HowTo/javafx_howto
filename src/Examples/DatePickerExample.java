import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DatePickerExample extends Application
{
    @Override
    public void start(Stage window) throws Exception
    {
        VBox root = new VBox();
        root.setSpacing(10);

        DatePicker datePicker = new DatePicker();

        Button button = new Button("Click Me");
        Label dateLabel = new Label("UnChoosen");
        button.setOnAction(e -> {
            LocalDate localDate = datePicker.getValue();
            dateLabel.setText(localDate.toString());
        } );

        root.getChildren().addAll(datePicker, button, dateLabel);

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