import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class DragWindowExample extends Application
{
    private Stage window;
    private VBox root;
    private double offsetX;
    private double offsetY;

    private void makeRootDraggeble()
    {
        // 鼠标场景位置(offset) = 鼠标屏幕位置 - 窗口屏幕位置
        // 拖拽鼠标移动窗口，实质上就是鼠标场景位置(offset)不变，同时修改窗口屏幕位置
        // 因此拖拽时，令 窗口屏幕位置 = 鼠标屏幕位置 - 鼠标场景位置(offset)
        root.setOnMousePressed(e -> {
            offsetX = e.getSceneX();
            offsetY = e.getSceneY();
        });

        root.setOnMouseDragged(e -> {
            window.setX(e.getScreenX() - offsetX);
            window.setY(e.getScreenY() - offsetY);

            window.setOpacity(0.9);
        });

        root.setOnMouseReleased(e -> {
            window.setOpacity(1.0);
        });
    }

    @Override
    public void start(Stage window) throws Exception
    {
        this.window = window;

        root = new VBox();
        this.makeRootDraggeble();

        Button closeButton = new Button("X");
        closeButton.setOnAction(e -> window.close() );
        root.getChildren().add(closeButton);

        Scene scene = new Scene(root, 400, 300);

        window.setScene(scene);
        window.initStyle(StageStyle.TRANSPARENT);
        window.setTitle(this.getClass().getSimpleName());
        window.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}