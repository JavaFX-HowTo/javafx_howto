import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

class ConfirmWindow
{
    private boolean isConfirmed;
    private Stage confirmWindow;

    public boolean open(String content)
    {
        isConfirmed = false;

        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10));
        vBox.setSpacing(10);

        Label contentLabel = new Label(content);
        vBox.getChildren().add(contentLabel);

        HBox confirmHBox = new HBox();
        confirmHBox.setSpacing(10);
        {
            // 添加确认、取消两个按钮
            Button confirmButton = new Button("确认");
            confirmButton.setDefaultButton(true);
            Button cancelButton = new Button("取消");
            confirmHBox.getChildren().addAll(confirmButton, cancelButton);

            confirmButton.setOnAction(e -> {
                isConfirmed = true;
                confirmWindow.close();
            });

            cancelButton.setOnAction(e -> {
                isConfirmed = false;
                confirmWindow.close();
            });
        }
        vBox.getChildren().add(confirmHBox);

        Scene scene = new Scene(vBox);

        confirmWindow = new Stage();
        confirmWindow.initModality(Modality.APPLICATION_MODAL);
        confirmWindow.setScene(scene);
        confirmWindow.showAndWait(); // 执行代码在此处暂停，当窗口关闭后继续执行后面的代码，即 return 一个确认状态

        return isConfirmed;
    }
}