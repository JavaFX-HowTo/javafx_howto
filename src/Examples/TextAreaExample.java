import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class TextAreaExample extends Application
{
    private void test1(Stage primaryStage)
    {
        VBox root = new VBox();
        root.setPadding(new Insets(10));
        root.setSpacing(10);

        // 创建一个TextArea控件
        TextArea textArea = new TextArea();

        // 设置成只读
        //textArea.setEditable(false);

        // 自动换行显示
        textArea.setWrapText(true);

        // 设置TextArea的宽度和高度
        //textArea.setPrefWidth(300);
        //textArea.setPrefHeight(200);
        // 随时保持高度为 VBox 高度的一半
        textArea.prefHeightProperty().bind(root.heightProperty().divide(2));

        root.getChildren().add(textArea);

        {
            // 添加一个按钮测试
            Button button = new Button("OK");
            button.setOnAction((event) -> { textArea.appendText("button clicked\n"); });

            root.getChildren().add(button);
        }

        Scene scene = new Scene(root, 400, 300);

        primaryStage.setTitle("TextAreaExample");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        test1(primaryStage);
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
