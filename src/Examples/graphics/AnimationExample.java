import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AnimationExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();
        pane.setPrefWidth(600);
        pane.setPrefHeight(400);

        Circle circle = new Circle(50, 50, 50, Color.BLUE);
        pane.getChildren().add(circle);

        KeyValue keyValue = new KeyValue(circle.translateXProperty(), 200);
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(5), keyValue);
        Timeline timeline = new Timeline(keyFrame);
        timeline.play();

        primaryStage.setTitle(this.getClass().getSimpleName());
        primaryStage.setScene(new Scene(pane));
        primaryStage.show();
    }
}
