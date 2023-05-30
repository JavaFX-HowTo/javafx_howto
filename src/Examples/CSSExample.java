import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CSSExample extends Application
{
    @Override
    public void start(Stage window) throws Exception
    {
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10));
        vBox.setSpacing(10);

        Label label = new Label("Label");
        vBox.getChildren().add(label);

        Label labelBlue = new Label("Label Blue");
        labelBlue.getStyleClass().add("label-blue");
        vBox.getChildren().add(labelBlue);

        Label labelBold = new Label("Label Bold");
        labelBold.setId("label-bold");
        vBox.getChildren().add(labelBold);

        Label labelRed = new Label("Label Red");
        labelRed.setStyle("-fx-text-fill: #A52A2A");
        vBox.getChildren().add(labelRed);

        Scene scene = new Scene(vBox);
        scene.getStylesheets().add("cssexample.css");

        window.setScene(scene);
        window.setTitle(this.getClass().getSimpleName());
        window.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}