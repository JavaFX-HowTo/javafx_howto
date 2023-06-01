import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RunLaterExample extends Application
{
    private ProgressBar progressBar;

    private void updateProgress(String message, int percent)
    {
        System.out.println(message);
        Platform.runLater(() -> progressBar.setProgress(percent * 0.01) );
    }

    private static void sleepSecond(int second)
    {
        try
        {
            Thread.sleep(second * 1000);
        }
        catch (Exception e)
        {
        }
    }

    private void startInitThread()
    {
        new Thread(() -> {

            sleepSecond(2);
            this.updateProgress("Init step 1...", 30);
            
            sleepSecond(2);
            this.updateProgress("Init step 2...", 50);

            sleepSecond(2);
            this.updateProgress("Init step 3...", 70);
            
            sleepSecond(2);
            this.updateProgress("Init finish", 100);

        }).start();
    }

    @Override
    public void start(Stage window) throws Exception
    {
        startInitThread();

        VBox vBox = new VBox();

        progressBar = new ProgressBar(0);

        vBox.getChildren().add(progressBar);

        Scene scene = new Scene(vBox, 400, 300);

        window.setScene(scene);
        window.setTitle(this.getClass().getSimpleName());
        window.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}