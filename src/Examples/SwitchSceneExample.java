import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SwitchSceneExample extends Application
{
    private Scene scene1;
    private Scene scene2;

    @Override
    public void start(Stage window) throws Exception
    {
        Pane root1 = new VBox();
        Button button1 = new Button("switch to scene 2");
        button1.setOnAction((e) -> { window.setScene(scene2); });
        root1.getChildren().add(button1);
        scene1 = new Scene(root1, 400, 300);

        Pane root2= new VBox();
        Button button2 = new Button("switch to scene 1");
        button2.setOnAction((e) -> { window.setScene(scene1); });
        root2.getChildren().add(button2);
        scene2 = new Scene(root2, 800, 600);

        window.setTitle(this.getClass().getSimpleName());
        window.setScene(scene1);
        window.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
