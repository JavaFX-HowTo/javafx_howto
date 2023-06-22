import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ParentExample extends Application {

    private static class Input extends Parent {
        
        public Input(String notice) {
            HBox hBox= new HBox(5);
            hBox.setAlignment(Pos.CENTER);
            
            Label label = new Label(notice);
            TextField textField = new TextField();
            hBox.getChildren().addAll(label, textField);

            this.getChildren().add(hBox);
        }
    }

    private Parent createContent() {
        VBox root = new VBox();

        Input input = new Input("name");
        
        root.getChildren().add(input);

        return root;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle(this.getClass().getSimpleName());
        Scene scene = new Scene(createContent(), 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
