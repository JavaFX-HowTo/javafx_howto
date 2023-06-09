import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.scene.Scene;
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
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10));
        vBox.setSpacing(10);

        TextField textField = new TextField();
        Label label = new Label();
        label.textProperty().bind(textField.textProperty());
        
        PropertiesFoo propertiesFoo = new PropertiesFoo();
        propertiesFoo.valueProperty().addListener(( v, oldValue, newValue ) -> {
            System.out.println(String.format("propertiesFoo's value changed: %s -> %s", oldValue, propertiesFoo.getValue()));
        } );
        propertiesFoo.valueProperty().bind(label.textProperty());
        
        vBox.getChildren().addAll(textField, label);

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