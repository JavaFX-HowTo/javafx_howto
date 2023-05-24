import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ConfirmWindowExample extends Application
{
    @Override
    public void start(Stage window) throws Exception
    {
        VBox vBox = new VBox();

        Button button = new Button("Open Confirm Window");
        button.setOnAction(e -> 
        {
            boolean isConfirmed = new ConfirmWindow().open("你确认吗？"); // 执行代码在此处暂停，等待 openConfirmWindow 返回
            if (isConfirmed)
            {
                System.out.println("Confirmed");
            }
            else
            {
                System.out.println("Not Confirmed");
            }
        });

        vBox.getChildren().add(button);

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
