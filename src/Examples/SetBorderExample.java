import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SetBorderExample extends Application
{
    private static void setDebugBorderForPane(Pane pane)
    {
        BorderStroke borderStroke = new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, null, null);
        Border border = new Border(borderStroke);
        pane.setBorder(border);
    }

    private static void setDebugBorderForControl(Control control)
    {
        BorderStroke borderStroke = new BorderStroke(Color.BLUE, BorderStrokeStyle.SOLID, null, null);
        Border border = new Border(borderStroke);
        control.setBorder(border);
    }

    private Pane buildLayout()
    {
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10)); // 设置控件距离布局上下左右边的距离至少为10像素
        setDebugBorderForPane(vBox);

        Label label = new Label("Hello Border");
        setDebugBorderForControl(label);
        vBox.getChildren().add(label);

        return vBox;
    }

    @Override
    public void start(Stage window) throws Exception
    {
        Scene scene = new Scene(this.buildLayout(), 400, 300);
        window.setScene(scene);
        window.setTitle(this.getClass().getSimpleName());
        window.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
