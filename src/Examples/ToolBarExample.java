import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ToolBarExample extends Application
{
    @Override
    public void start(Stage window) throws Exception
    {
        VBox root = new VBox();

        ToolBar toolBar = new ToolBar();
        root.getChildren().add(toolBar);

        {
            Button btn1 = new Button("Button 1");
            Button btn2 = new Button("Button 2");

            toolBar.getItems().addAll(btn1, btn2);
        }

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