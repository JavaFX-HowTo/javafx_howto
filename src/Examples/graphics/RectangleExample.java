import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class RectangleExample extends Application {

    private Parent createContent() {
        Pane root = new Pane();

        Rectangle rectangle = new Rectangle();
        rectangle.setX(10);
        rectangle.setY(0);
        rectangle.setWidth(100);
        rectangle.setHeight(50);
        rectangle.setStroke(Color.TRANSPARENT);
        rectangle.setFill(Color.valueOf("#00ffff"));

        Rectangle rectangle2 = new Rectangle();
        rectangle2.setX(10);
        rectangle2.setY(60);
        rectangle2.setWidth(100);
        rectangle2.setHeight(50);
        rectangle2.setStroke(Color.BLUE);
        rectangle2.setFill(Color.TRANSPARENT);
        rectangle2.setArcWidth(50); // 设置圆角半径 为50像素，使矩形的半径变成圆角
        rectangle2.setArcHeight(50);

        root.getChildren().addAll(rectangle, rectangle2);
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
