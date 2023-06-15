import java.io.File;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FileChooserExample extends Application
{
    private Stage window;
    private Label fileLabel;

    private void chooseFile()
    {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("."));
        fileChooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("Java Files", "*.java")
        );
        
        File choosenFile = fileChooser.showOpenDialog(window);
        if (choosenFile != null)
        {
            fileLabel.setText(choosenFile.getAbsolutePath());
        }
    }

    @Override
    public void start(Stage window) throws Exception
    {
        this.window = window;
        VBox root = new VBox();

        fileLabel = new Label("UnChoosen");

        Button chooseBtn = new Button("Choose a File");
        chooseBtn.setOnAction( e -> chooseFile() );

        root.getChildren().addAll(fileLabel, chooseBtn);

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
