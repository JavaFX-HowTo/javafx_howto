import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TaskExample extends Application {

    private static class ProgressTask extends Task<Void> {

        @Override
        protected Void call() throws Exception {
            int progress = 0;
            int maxProgress = 100;

            while (progress < maxProgress) {
                progress += 10;

                try {
                    Thread.sleep(1000);
                }
                catch (Exception e) {
                }

                this.updateProgress(progress, maxProgress);
            }

            return null;
        }
        
    }

    private ProgressTask progressTask = new ProgressTask();

    @Override
    public void start(Stage window) throws Exception {
        VBox root = new VBox();

        ProgressBar progressBar = new ProgressBar(0);
        progressBar.progressProperty().bind(progressTask.progressProperty());

        Button beginButton = new Button("Begin");
        beginButton.setOnAction(e -> {
            Thread thread = new Thread(progressTask);
            //thread.setDaemon(true); // 程序可正常退出，无需等待线程结束
            thread.start();
        } );

        root.getChildren().addAll(progressBar, beginButton);

        Scene scene = new Scene(root, 400, 300);
        window.setTitle(this.getClass().getSimpleName());
        window.setScene(scene);
        window.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
