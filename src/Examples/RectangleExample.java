import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class RectangleExample extends Application {

    private Parent createContent() {
        Group root = new Group();

        Rectangle rectangle = new Rectangle();
        rectangle.setX(100);
        rectangle.setY(100);
        rectangle.setWidth(100);
        rectangle.setHeight(50);
        rectangle.setStroke(Color.TRANSPARENT);
        rectangle.setFill(Color.valueOf("#00ffff"));

        root.getChildren().add(rectangle);
        return root;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(createContent(), 400, 300));
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
