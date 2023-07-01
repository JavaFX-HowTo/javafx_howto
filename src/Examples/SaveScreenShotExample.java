import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SaveScreenShotExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle(this.getClass().getSimpleName());
        Scene scene = new Scene(createContent());
        scene.setOnKeyReleased(e->saveScreenShot(scene));
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private Parent createContent() {
        VBox root = new VBox(10);
        root.setPrefWidth(600);
        root.setPrefHeight(400);

        root.getChildren().add(new Label("Hello World"));

        return root;
    }

    private void saveScreenShot(Scene scene) {
        System.out.println("saving screenshot...");

        // 保存当前场景的快照 文件名为 类名.png
        WritableImage fxImage = scene.snapshot(null);

        BufferedImage awtImage = SwingFXUtils.fromFXImage(fxImage, null);

        try {
            ImageIO.write(awtImage, "png", new File(this.getClass().getSimpleName() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("saved screenshot");
    }
}
