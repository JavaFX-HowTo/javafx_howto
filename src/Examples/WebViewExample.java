import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class WebViewExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle(this.getClass().getSimpleName());
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();
    }
    
    private Parent createContent() {
        VBox root = new VBox(10);
        root.setPrefSize(800, 600);

        WebView webView = new WebView();
        webView.getEngine().load("https://www.bing.com");

        TextField addressTextField = new TextField("https://www.bing.com");
        addressTextField.setOnAction(e-> {
            webView.getEngine().load(addressTextField.getText());
        });

        root.getChildren().addAll(addressTextField, webView);

        return root;
    }
}
