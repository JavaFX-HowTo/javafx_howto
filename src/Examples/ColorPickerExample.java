import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ColorPickerExample extends Application
{
    @Override
    public void start(Stage window) throws Exception
    {
        VBox root = new VBox();

        ColorPicker colorPicker = new ColorPicker();
        Button button = new Button("Click Me");
        Label colorLabel = new Label("UnChoosen");
        button.setOnAction(e -> {
            Color color = colorPicker.getValue();
            colorLabel.setText(color.toString());
        });

        root.getChildren().addAll(colorPicker, button, colorLabel);

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