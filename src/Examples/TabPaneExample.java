import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TabPaneExample extends Application
{
    @Override
    public void start(Stage window) throws Exception
    {
        TabPane tabPane = new TabPane();
        Tab tab1 = new Tab("tab1");
        tab1.setContent(new VBox(new Label("Label 1")));
        Tab tab2 = new Tab("tab2");
        Tab tab3 = new Tab("tab3");

        tabPane.getTabs().addAll(tab1, tab2, tab3);

        Scene scene = new Scene(tabPane, 400, 300);

        window.setScene(scene);
        window.setTitle(this.getClass().getSimpleName());
        window.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}