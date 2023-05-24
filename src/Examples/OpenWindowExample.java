import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class OpenWindowExample extends Application
{
    private void openWindow()
    {
        VBox vBox = new VBox();

        Scene scene = new Scene(vBox, 200, 100);

        Stage newWindow = new Stage();
        newWindow.initModality(Modality.APPLICATION_MODAL); // 设置此模式，则窗口打开时，其他窗口无法操作
        newWindow.setScene(scene);
        newWindow.show();
    }

    @Override
    public void start(Stage window) throws Exception
    {
        VBox vBox = new VBox();

        Button openButton = new Button("Open Window");
        openButton.setOnAction( e -> openWindow() );
        vBox.getChildren().add(openButton);

        Scene scene = new Scene(vBox, 400, 300);

        window.setScene(scene);
        window.setTitle(this.getClass().getSimpleName());
        window.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
