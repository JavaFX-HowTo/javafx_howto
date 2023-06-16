import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class UserDataExample extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        StackPane root = new StackPane();

        Button button = new Button("ok");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Map<String, String> userData = (Map<String, String>)button.getUserData();

                System.out.println(String.format("name: %s", userData.get("name")));
            }
        });
        root.getChildren().add(button);

        {
            Map<String, String> userData = new HashMap<>();
            userData.put("name", "Kobe");

            button.setUserData(userData);
        }

        Scene scene = new Scene(root, 400, 300);

        primaryStage.setTitle("UserDataExample");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
