import javafx.animation.FillTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

// ParallelTransition 令多个动画同时进行
public class ParallelTransitionExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle(this.getClass().getSimpleName());
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();
    }
    
    private Parent createContent() {
        Pane pane = new Pane();
        pane.setPrefWidth(600);
        pane.setPrefHeight(400);

        Circle circle = new Circle(25);
        circle.setTranslateX(100);
        circle.setTranslateY(100);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);

        pane.getChildren().addAll(circle);

        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(3));
        translateTransition.setNode(circle);
        translateTransition.setToX(300);

        FillTransition fillTransition = new FillTransition(Duration.seconds(10));
        fillTransition.setShape(circle);
        fillTransition.setFromValue(Color.WHITE);
        fillTransition.setToValue(Color.RED);

        ParallelTransition parallelTransition = new ParallelTransition(translateTransition, fillTransition);
        parallelTransition.play();

        return pane;
    }
}
