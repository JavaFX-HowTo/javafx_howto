import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ValidationTextFieldExample extends Application
{
    @Override
    public void start(Stage window) throws Exception
    {
        window.setTitle(this.getClass().getSimpleName());
        
        VBox root = new VBox();
        
        ValidationTextField validationTextField = new ValidationTextField((s) -> { return s.contains("abc"); });
        Button submitBtn = new Button("Submit");
        submitBtn.disableProperty().bind(validationTextField.booleanProperty().not());

        root.getChildren().addAll(validationTextField, submitBtn);

        Scene scene = new Scene(root, 400, 300);
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args)
    {
        launch();
    }
    
}
