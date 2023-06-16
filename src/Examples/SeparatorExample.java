import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SeparatorExample extends Application
{
    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();
        root.setPadding(new Insets(10));
        root.setSpacing(10);

        root.getChildren().addAll(
          new Button("button1"),
                new Separator(Orientation.HORIZONTAL),
          new Button("button2"),
                new Separator(Orientation.HORIZONTAL),
          new Button("button3")
        );

        Scene scene = new Scene(root, 400, 300);

        primaryStage.setTitle("SimpleWindow");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
