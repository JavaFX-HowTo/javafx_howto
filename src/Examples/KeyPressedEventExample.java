import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class KeyPressedEventExample extends Application {

    private Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        primaryStage.setTitle(this.getClass().getSimpleName());
        Scene scene = new Scene(createContent());
        scene.setOnKeyPressed(this::onKeyPressedEvent);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private Parent createContent() {
        VBox root = new VBox(10);
        root.setPrefWidth(600);
        root.setPrefHeight(400);

        return root;
    }

    private void onKeyPressedEvent(KeyEvent keyEvent) {
        System.out.println(keyEvent.getCode().toString());

        if (keyEvent.getCode().equals(KeyCode.ESCAPE)) {
            window.close();
        }
    }
}
