import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HTMLEditorExample extends Application
{
    @Override
    public void start(Stage window) throws Exception
    {
        VBox root = new VBox();
    
        LogArea logArea = new LogArea();
        root.getChildren().addAll(logArea.getNode());

        Button infoButton = new Button("add info");
        infoButton.setOnAction(e -> {
            logArea.logInfo("this is some info");
        });
        Button errorButton = new Button("add error");
        errorButton.setOnAction(e -> {
            logArea.logError("this is some error");
        });
        Button clearButton = new Button("clear");
        clearButton.setOnAction(e -> {
            logArea.clear();
        });
        Button printHTMLTextButton = new Button("print html");
        printHTMLTextButton.setOnAction(e -> {
            System.out.println(logArea.getHTMLText());
        });
        root.getChildren().addAll(infoButton, errorButton, clearButton, printHTMLTextButton);

        Scene scene = new Scene(root, 400, 300);

        window.setScene(scene);
        window.setTitle(this.getClass().getSimpleName());
        window.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}