import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PathTransitionExample extends Application {

    private Pane root;
    private Circle circle;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(createContent());
        scene.setOnKeyPressed(this::handleKeyPressedEvent);
        primaryStage.setTitle(this.getClass().getSimpleName());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Parent createContent() {
        root = new Pane();
        root.setPrefWidth(600);
        root.setPrefHeight(400);

        circle = new Circle(100);
        circle.setTranslateX(300);
        circle.setTranslateY(200);
        circle.setFill(Color.TRANSPARENT);
        circle.setStroke(Color.BLACK);

        root.getChildren().add(circle);

        return root;
    }
    
    private void handleKeyPressedEvent(KeyEvent keyEvent) {
        Text text = new Text(keyEvent.getCode().toString());
        text.setFont(Font.font(22));
        root.getChildren().add(text);

        PathTransition pathTransition = new PathTransition(Duration.seconds(5), circle, text);
        //pathTransition.setAutoReverse(true);
        pathTransition.setCycleCount(Animation.INDEFINITE);
        pathTransition.play();
    }
}
