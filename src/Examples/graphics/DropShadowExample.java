import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

// 为控件添加阴影效果的例子
public class DropShadowExample extends Application {

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

        Rectangle rectangle = new Rectangle();
        rectangle.setX(50);
        rectangle.setY(50);
        rectangle.setWidth(100);
        rectangle.setHeight(100);
        rectangle.setStroke(Color.BLUE);
        rectangle.setFill(Color.TRANSPARENT);

        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(2);
        rectangle.setEffect(dropShadow);

        pane.getChildren().add(rectangle);

        return pane;
    }
    
}
