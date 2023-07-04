import java.io.File;
import java.net.MalformedURLException;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class MediaExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle(this.getClass().getSimpleName());
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();
    }

    private Parent createContent() throws MalformedURLException {
        VBox root = new VBox(10);
        root.setPrefSize(600, 400);

        // java 运行目录的相对目录
        File file = new File("./resource/菊次郎的夏天.mp4");
        Media media = new Media(file.toURI().toURL().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);

        root.getChildren().add(mediaView);

        Button playBtn = new Button("play");
        playBtn.setOnAction(e->{
            mediaPlayer.play();
        });

        Button pauseBtn = new Button("pause");
        pauseBtn.setOnAction(e->{
            mediaPlayer.pause();
        });

        root.getChildren().addAll(new HBox(10, playBtn, pauseBtn));
        
        return root;
    }
    
}
