import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class CircleExample extends Application {

    private Parent createContent() {
        Group root = new Group();

        Circle circle = new Circle();
        circle.setCenterX(100);
        circle.setCenterY(100);
        circle.setRadius(50);
        circle.setStroke(Color.valueOf("#ff00ff"));
        circle.setStrokeWidth(5);
        circle.setFill(Color.TRANSPARENT);

        root.getChildren().add(circle);

        return root;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(createContent(), 400, 300));
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch();
    }
}
