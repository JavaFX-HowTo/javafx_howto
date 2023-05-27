import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RadioMenuItemExample extends Application
{
    private Stage window;
    private MenuBar menuBar;

    private void exitProgram()
    {
        this.window.close();
    }

    private void buildMenu()
    {
        menuBar = new MenuBar();

        Menu fileMenu = new Menu("_File");
        menuBar.getMenus().add(fileMenu);

        MenuItem newMenuItem = new MenuItem("_New File");
        fileMenu.getItems().add(newMenuItem);
        MenuItem openMenuItem = new MenuItem("_Open File");
        fileMenu.getItems().add(openMenuItem);
        fileMenu.getItems().add(new SeparatorMenuItem());
        MenuItem exitMenuItem = new MenuItem("_Exit");
        fileMenu.getItems().add(exitMenuItem);
        exitMenuItem.setOnAction( e-> exitProgram() );

        Menu difficultMenu = new Menu("难度选择(_D)");
        menuBar.getMenus().add(difficultMenu);

        ToggleGroup diffToggleGroup = new ToggleGroup();
        RadioMenuItem easy = new RadioMenuItem("简单");
        easy.setSelected(true);
        easy.setToggleGroup(diffToggleGroup);
        RadioMenuItem medium = new RadioMenuItem("中等");
        medium.setToggleGroup(diffToggleGroup);
        RadioMenuItem hard = new RadioMenuItem("困难");
        hard.setToggleGroup(diffToggleGroup);
        
        difficultMenu.getItems().addAll(easy, medium, hard);
    }

    @Override
    public void start(Stage window) throws Exception
    {
        this.window = window;

        VBox vBox = new VBox();

        this.buildMenu();
        vBox.getChildren().add(menuBar);

        Scene scene = new Scene(vBox, 400, 300);

        window.setScene(scene);
        window.setTitle(this.getClass().getSimpleName());
        window.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}