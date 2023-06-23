import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Transform;
import javafx.stage.Stage;

// 平移测试
public class TranslateExample extends Application {

    private Rectangle rectangle;

    private Parent createContent() {

        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.getStylesheets().add("debug.css");

        HBox operaHBox = new HBox(10);
        Button left = new Button("turn left");
        left.setOnAction(e -> {
            Transform translate = Transform.translate(-10, 0);
            rectangle.getTransforms().add(translate);
         });
        Button right = new Button("turn right");
        right.setOnAction(e -> {
            Transform translate = Transform.translate(10, 0);
            rectangle.getTransforms().add(translate);
        } );
        operaHBox.getChildren().addAll(left, right);

        Pane pane = new Pane();
        pane.setPrefHeight(500);
        pane.setPrefWidth(500);
        pane.getStyleClass().add("debug-border");
        rectangle = new Rectangle();
        rectangle.setX(0);
        rectangle.setY(0);
        rectangle.setWidth(100);
        rectangle.setHeight(100);
        rectangle.setFill(Color.TRANSPARENT);
        rectangle.setStroke(Color.BLUE);
        pane.getChildren().add(rectangle);

        root.getChildren().addAll(operaHBox, pane);

        return root;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle(this.getClass().getSimpleName());
        primaryStage.setScene(new Scene(createContent(), 400, 300));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
