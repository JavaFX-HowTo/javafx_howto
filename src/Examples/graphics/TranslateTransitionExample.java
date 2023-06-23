import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TranslateTransitionExample extends Application {

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
        circle.setTranslateX(50);
        circle.setTranslateY(50);
        circle.setStroke(Color.BLUE);
        circle.setFill(Color.TRANSPARENT);

        // 令圆移动到一个点
        TranslateTransition transition = new TranslateTransition(Duration.seconds(3));
        transition.setNode(circle);
        transition.setToX(300);
        transition.play();

        pane.getChildren().add(circle);

        return pane;
    }
}
