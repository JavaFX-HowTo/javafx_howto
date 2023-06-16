import javafx.application.Application;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontSmoothingType;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TextExample extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        StackPane root = new StackPane();

        Text text = new Text("Hello World");
        text.setFont(Font.font("Arial", FontWeight.BOLD, 36)); // 字体
        text.setFill(Color.RED); // 填充颜色
        text.setStroke(Color.GREEN); // 描边颜色
        //text.setWrappingWidth(100); // 设置宽度，如果文字超过了宽度，那么会自动换行
        //text.setStrikethrough(true); // 删除线
        //text.setUnderline(true); // 下划线

        // 两种字体平滑技术 即抗锯齿
        //text.setFontSmoothingType(FontSmoothingType.GRAY);
        //text.setFontSmoothingType(FontSmoothingType.LCD);

        root.getChildren().add(text);

        Scene scene = new Scene(root, 400, 300);

        primaryStage.setTitle(this.getClass().getSimpleName());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
