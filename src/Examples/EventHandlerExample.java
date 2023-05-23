import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EventHandlerExample extends Application
{
    private void onButtonClick()
    {
        System.out.println("Button Clicked");
    }

    private Pane buildLayout()
    {
        VBox vBox = new VBox();

        Button button = new Button("Click Me");
        button.setOnAction( e -> onButtonClick() );
        vBox.getChildren().add(button);

        return vBox;
    }

    @Override
    public void start(Stage window) throws Exception
    {
        Scene scene = new Scene(this.buildLayout(), 400, 300);
        window.setScene(scene);
        window.setTitle(this.getClass().getSimpleName());
        window.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
