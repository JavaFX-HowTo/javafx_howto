import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class IconExample extends Application
{
    @Override
    public void start(Stage window) throws Exception
    {
        // Image 的 url 是 classpath 的相对目录，也可以是一个绝对目录
        Image image = new Image("resource/icon.png");
        window.getIcons().add(image);
        StackPane root = new StackPane();

        Scene scene = new Scene(root, 400, 300);

        window.setTitle(this.getClass().getSimpleName());
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
