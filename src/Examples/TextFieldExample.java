import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TextFieldExample extends Application
{
    private void handleInput(String input)
    {
        System.out.println(input);
    }

    @Override
    public void start(Stage window) throws Exception
    {
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10));
        vBox.setSpacing(10);
        Platform.runLater(() -> vBox.requestFocus() ); // 在显示窗口后，取消所有可视控件的焦点

        TextField textField = new TextField();
        textField.setPromptText("Input some content");

        Button button = new Button("OK");
        button.setOnAction(e -> handleInput(textField.getText()) );

        vBox.getChildren().addAll(textField, button);

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