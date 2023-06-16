import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HyperlinkExample extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        StackPane root = new StackPane();

        Hyperlink hyperlink = new Hyperlink("Click Me");
        hyperlink.setOnAction((e) -> {
            System.out.println("Clicked");
        });
        root.getChildren().add(hyperlink);

        Scene scene = new Scene(root, 400, 300);

        primaryStage.setTitle(this.getClass().getSimpleName());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
