import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

class PropertiesFoo
{
    public String getValue() {
        return value.get();
    }

    public StringProperty valueProperty() {
        return value;
    }

    public void setValue(String value) {
        this.value.set(value);
    }

    private StringProperty value = new SimpleStringProperty();
}

public class PropertiesExample extends Application
{
    @Override
    public void start(Stage window) throws Exception
    {
        PropertiesFoo propertiesFoo = new PropertiesFoo();
        propertiesFoo.valueProperty().addListener(( v, oldValue, newValue ) -> {
            System.out.println(String.format("value changed: %s -> %s", oldValue, newValue));
        } );

        VBox vBox = new VBox();

        TextField textField = new TextField();
        Button button = new Button("OK");
        button.setOnAction( e -> { propertiesFoo.setValue(textField.getText()); });
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