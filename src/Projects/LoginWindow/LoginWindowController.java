import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginWindowController implements Initializable
{

    @FXML
    private Button close;

    @FXML
    private Button login;

    @FXML
    private AnchorPane mainForm;

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;

    public void close()
    {
        System.exit(0);
    }

    public void login()
    {
        System.out.println("user login...");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        Platform.runLater(() -> mainForm.requestFocus() );
    }
}
