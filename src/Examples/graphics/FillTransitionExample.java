import javafx.animation.FillTransition;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FillTransitionExample extends Application {

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

        Rectangle rectangle = new Rectangle(100, 50);
        rectangle.setTranslateX(50);
        rectangle.setTranslateY(50);
        rectangle.setStroke(Color.BLUE);
        rectangle.setFill(Color.WHITE);

        FillTransition fillTransition = new FillTransition(Duration.seconds(3));
        fillTransition.setShape(rectangle);
        fillTransition.setFromValue(Color.WHITE);
        fillTransition.setToValue(Color.LIGHTGREEN);
        fillTransition.play();

        pane.getChildren().add(rectangle);

        return pane;
    }
    
}
