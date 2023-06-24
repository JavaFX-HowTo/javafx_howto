import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ToggleSwitchExample extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle(this.getClass().getSimpleName());
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();
    }

    private Parent createContent() {
        Pane pane = new Pane();
        pane.setPrefWidth(600);
        pane.setPrefHeight(400);

        ToggleSwitch toggleSwitch = new ToggleSwitch();
        toggleSwitch.setTranslateX(100);
        toggleSwitch.setTranslateY(100);
        pane.getChildren().addAll(toggleSwitch);

        return pane;
    }
}
