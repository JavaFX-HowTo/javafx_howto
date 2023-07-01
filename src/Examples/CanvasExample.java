import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CanvasExample extends Application {

    private GraphicsContext graphicsContext2D;

    @Override
    public void start(Stage window) throws Exception {
        VBox root = new VBox();
        root.getChildren().add(createOperaBox());

        Canvas canvas = new Canvas(512, 512);
        graphicsContext2D = canvas.getGraphicsContext2D();

        graphicsContext2D.setFill(Color.valueOf("#ff0000"));
        graphicsContext2D.fillRect(100, 100, 200, 200);

        graphicsContext2D.setStroke(Color.valueOf("#0000ff"));
        graphicsContext2D.strokeRect(200, 200, 200, 200);

        root.getChildren().add(canvas);

        Scene scene = new Scene(root);
        window.setTitle(this.getClass().getSimpleName());
        window.setScene(scene);
        window.show();
    }

    private HBox createOperaBox() {

        Button drawLineBtn = new Button("Draw Line");
        drawLineBtn.setOnAction(e -> {
            graphicsContext2D.setStroke(Color.valueOf("#0000ff"));
            graphicsContext2D.strokeLine(200, 50, 300, 50);
        });

        HBox hBox = new HBox(10, drawLineBtn);
        return hBox;
    }

    public static void main(String[] args) {
        launch();
    }
}
