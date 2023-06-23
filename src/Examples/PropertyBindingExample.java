import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PropertyBindingExample extends Application {

    private Parent createContent() {
        VBox root = new VBox(10);

        CheckBox CheckBox = new CheckBox("CheckBox");
        Label label = new Label("Not checked");

        label.textProperty().bind(Bindings.when(CheckBox.selectedProperty()).then("Checked").otherwise("Not checked"));

        root.getChildren().addAll(CheckBox, label);

        return root;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle(this.getClass().getSimpleName());
        primaryStage.setScene(new Scene(createContent(), 400, 300));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
