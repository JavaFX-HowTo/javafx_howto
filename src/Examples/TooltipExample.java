import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TooltipExample extends Application
{
    @Override
    public void start(Stage window) throws Exception
    {
        VBox root = new VBox();

        Tooltip tooltip = new Tooltip("Click to log some message for test!");
        Button button = new Button("Click!");
        button.setTooltip(tooltip);
        button.setOnAction(e -> { System.out.println("Hello~"); });

        root.getChildren().add(button);

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