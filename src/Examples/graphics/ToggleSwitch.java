import javafx.animation.FillTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.Parent;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class ToggleSwitch extends Parent {

    TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(0.25));
    FillTransition fillTransition = new FillTransition(Duration.seconds(0.25));
    ParallelTransition animation = new ParallelTransition(translateTransition, fillTransition);

    BooleanProperty switchOn = new SimpleBooleanProperty(false);

    public ToggleSwitch() {
        Rectangle rectangle = new Rectangle(100, 50);
        rectangle.setArcWidth(50);
        rectangle.setArcHeight(50);
        rectangle.setFill(Color.WHITE);
        rectangle.setStroke(Color.LIGHTGRAY);

        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(2);
        rectangle.setEffect(dropShadow);

        Circle circle = new Circle(25);
        circle.setTranslateX(25);
        circle.setTranslateY(25);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.LIGHTGRAY);
        circle.setEffect(dropShadow);

        translateTransition.setNode(circle);
        fillTransition.setShape(rectangle);

        this.getChildren().addAll(rectangle, circle);

        switchOn.addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                translateTransition.setToX(75);

                fillTransition.setFromValue(Color.WHITE);
                fillTransition.setToValue(Color.LIGHTGREEN);
                
                animation.play();
            } else {
                translateTransition.setToX(25);

                fillTransition.setFromValue(Color.LIGHTGREEN);
                fillTransition.setToValue(Color.WHITE);
                
                animation.play();
            }
        });

        this.setOnMouseClicked(e -> {
            switchOn.set(!switchOn.get());
        });
    }
}
