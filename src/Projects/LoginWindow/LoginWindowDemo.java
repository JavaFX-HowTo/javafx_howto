import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Objects;

public class LoginWindowDemo extends Application
{
    private double offsetX;
    private double offsetY;

    @Override
    public void start(Stage window) throws Exception
    {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("LoginWindow.fxml")));

        {
            root.setOnMousePressed(e -> {
                offsetX = e.getSceneX();
                offsetY = e.getSceneY();
            });

            root.setOnMouseDragged(e -> {
                window.setX(e.getScreenX() - offsetX);
                window.setY(e.getScreenY() - offsetY);

                window.setOpacity(0.9);
            });

            root.setOnMouseReleased(e -> {
                window.setOpacity(1.0);
            });
        }

        Scene scene = new Scene(root);

        window.initStyle(StageStyle.TRANSPARENT);
        window.setScene(scene);
        window.setTitle(this.getClass().getSimpleName());
        window.show();
    }

    public static void main(String[] args)
    {
        launch();
    }
}
