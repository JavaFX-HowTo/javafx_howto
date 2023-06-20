import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SplitPaneExample extends Application
{
    @Override
    public void start(Stage window) throws Exception
    {
        SplitPane splitPane = new SplitPane();
        splitPane.setOrientation(Orientation.VERTICAL); // 设置分割类型为垂直分割
        splitPane.setDividerPositions(0.2, 0.8); // 设置区域的分割比例，垂直则从上到下，水平则从左到右

        VBox vBoxLeft = new VBox();
        VBox vBoxRight = new VBox();

        splitPane.getItems().addAll(vBoxLeft, vBoxRight);

        Scene scene = new Scene(splitPane, 400, 300);

        window.setScene(scene);
        window.setTitle(this.getClass().getSimpleName());
        window.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}