import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WindowCloseEventExample extends Application
{
    @Override
    public void start(Stage window) throws Exception
    {
        VBox vBox = new VBox();

        Scene scene = new Scene(vBox, 400, 300);

        window.setScene(scene);
        window.setTitle(this.getClass().getSimpleName());
        window.setOnCloseRequest(e ->
        {
            e.consume(); // 告诉 JavaFX 我们想自己处理窗口的关闭
            boolean isConfirmed = new ConfirmWindow().open("确认关闭窗口吗？");
            if (isConfirmed)
            {
                window.close();
            }
        });
        window.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
