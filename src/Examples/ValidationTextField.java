import java.util.function.Predicate;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.control.TextField;

public class ValidationTextField extends TextField
{
    private BooleanProperty booleanProperty = new SimpleBooleanProperty();

    public ValidationTextField(Predicate<String> predicate)
    {
        textProperty().addListener((observable, oldValue, newValue) -> {
            booleanProperty.set(predicate.test(newValue));
        });
    }

    public BooleanProperty booleanProperty()
    {
        return booleanProperty;
    }
}