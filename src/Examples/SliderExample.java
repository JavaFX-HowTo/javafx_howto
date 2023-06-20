import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SliderExample extends Application
{
    @Override
    public void start(Stage window) throws Exception
    {
        VBox root = new VBox();
        root.setSpacing(10);
        root.setPadding(new Insets(10));

        Slider slider = new Slider();
        Label valueLabel = new Label("Try to drag~");
        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            valueLabel.setText(String.valueOf(slider.getValue()));
        });

        root.getChildren().addAll(slider, valueLabel);

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