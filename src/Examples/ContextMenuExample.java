import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ContextMenuExample extends Application {

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
        VBox root = new VBox(10);
        root.setPrefSize(600, 400);

        Label label = new Label("Hello");
        MenuItem menuItem = new MenuItem("Copy");
        menuItem.setOnAction(e -> {
            String content = label.getText();
            ClipboardContent clipboardContent = new ClipboardContent();
            clipboardContent.putString(content);

            Clipboard clipboard = Clipboard.getSystemClipboard();
            clipboard.setContent(clipboardContent);
        });
        ContextMenu contextMenu = new ContextMenu(menuItem);

        label.setContextMenu(contextMenu);

        root.getChildren().addAll(label, new TextField());

        return root;
    }
}
