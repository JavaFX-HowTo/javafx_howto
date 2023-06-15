import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SwitchCSSExample extends Application
{
    private Scene scene;
    private ComboBox<String> switchCSSBox;
    private ObservableList<String> cssList;

    private void buildSwitchCSSBox()
    {
        cssList = FXCollections.observableArrayList();
        switchCSSBox = new ComboBox<>(cssList);

        cssList.addAll("Default", "Black");
        switchCSSBox.getSelectionModel().selectedItemProperty().addListener((Observable, oldValue, newValue) -> {
            if (newValue.equals("Black"))
            {
                System.out.println("Choose Black");

                scene.getRoot().getStylesheets().clear();
                scene.getRoot().getStylesheets().add("black.css");
            }
            else if (newValue.equals("Default"))
            {
                System.out.println("Choose Default");

                scene.getRoot().getStylesheets().clear();
            }
        });
    }

    @Override
    public void start(Stage window) throws Exception
    {
        VBox root = new VBox();
        root.setSpacing(10);
        root.setPadding(new Insets(10));

        Label label = new Label("Label Example");
        Button button = new Button("Button Example");
        Button defaultButton = new Button("Default Button Example");
        defaultButton.setDefaultButton(true);
        TextField textField = new TextField();
        textField.setPromptText("TextField Prompt");
        Separator separator = new Separator(Orientation.HORIZONTAL);
        TableViewExample tableViewExample = new TableViewExample();
        tableViewExample.buildStudentTableView();

        root.getChildren().addAll(
            label, 
            defaultButton, 
            button, 
            textField,
            separator,
            tableViewExample.studentTableView);
        
        this.buildSwitchCSSBox();
        root.getChildren().add(switchCSSBox);

        scene = new Scene(root, 400, 300);

        window.setScene(scene);
        window.setTitle(this.getClass().getSimpleName());
        window.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}