import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class LifeCycleExample extends Application
{
    @Override
    public void init() throws Exception
    {
        System.out.println("init");
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        System.out.println("start");

        Scene scene = new Scene(new StackPane(), 400, 300);

        primaryStage.setTitle("LifeCycleExample");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception
    {
        System.out.println("stop");

        System.exit(0);
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
