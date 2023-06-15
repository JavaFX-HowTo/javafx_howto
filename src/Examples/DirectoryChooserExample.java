import java.io.File;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class DirectoryChooserExample extends Application
{
    private Stage window;
    private Label fileLabel;

    private void chooseDirectory()
    {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setInitialDirectory(new File("."));
        
        File choosenDirectory = directoryChooser.showDialog(window);
        if (choosenDirectory != null)
        {
            fileLabel.setText(choosenDirectory.getAbsolutePath());
        }
    }

    @Override
    public void start(Stage window) throws Exception
    {
        this.window = window;
        VBox root = new VBox();

        fileLabel = new Label("UnChoosen");

        Button chooseBtn = new Button("Choose a Directory");
        chooseBtn.setOnAction( e -> chooseDirectory() );

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
