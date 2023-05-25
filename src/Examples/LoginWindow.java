import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class LoginWindow 
{
    private Stage window;
    private boolean isLoginSucc;

    private void confirmLogin(String userName, String password)
    {
        if (userName.equals("test") && password.equals("123456"))
        {
            isLoginSucc = true;
        }

        window.close();
    }

    public boolean open()
    {
        isLoginSucc = false;

        Label userNameLabel = new Label("UserName");
        TextField userNameTextField = new TextField();

        Label passwordLabel = new Label("Password");
        TextField passwordTextField = new TextField();

        Button confirmButton = new Button("Login");
        confirmButton.setOnAction(e -> confirmLogin(userNameTextField.getText(), passwordTextField.getText()));

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.add(userNameLabel, 0, 0);
        gridPane.add(userNameTextField, 1, 0);
        gridPane.add(passwordLabel, 0, 1);
        gridPane.add(passwordTextField, 1, 1);
        gridPane.add(confirmButton, 1, 2);

        Scene scene = new Scene(gridPane);

        window = new Stage();
        window.setScene(scene);
        window.initModality(Modality.APPLICATION_MODAL);
        window.showAndWait();

        return isLoginSucc;
    }
}
