import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LabelExample extends Application
{
    // 之所以 prefHeight 设置25，是因为这个高度和button之类的控件放一起看起来比较合适
    private static Label buildNormalLabel(String labelText)
    {
        Label label = new Label(labelText);
        label.setPrefHeight(25);
        return label;
    }

    private static void setLabelTextColorRed(Label label)
    {
        label.setStyle("-fx-text-fill: red;");
    }

    private static void setLabelTextColorGreen(Label label)
    {
        label.setStyle("-fx-text-fill: green;");
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        VBox root = new VBox();
        root.setPadding(new Insets(10));
        root.setSpacing(10);
        root.setAlignment(Pos.CENTER);

        Label normalLabel = buildNormalLabel("Normal Label");
        root.getChildren().add(normalLabel);

        Label redLabel = buildNormalLabel("Red Label");
        setLabelTextColorRed(redLabel);
        root.getChildren().add(redLabel);

        Label greenLabel = buildNormalLabel("Green Label");
        setLabelTextColorGreen(greenLabel);
        root.getChildren().add(greenLabel);

        Scene scene = new Scene(root, 400, 300);

        primaryStage.setTitle(this.getClass().getSimpleName());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
