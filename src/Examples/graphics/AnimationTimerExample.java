import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import static java.lang.Math.*;

public class AnimationTimerExample extends Application {

    private static class CustomAnimationTimer extends AnimationTimer {

        private GraphicsContext graphicsContext2D;
        private double t = 0.0;

        public CustomAnimationTimer(GraphicsContext graphicsContext2D) {
            this.graphicsContext2D = graphicsContext2D;
        }

        @Override
        public void handle(long now) {

            // now 是纳秒级时间戳(不是当前时间)

            // 每帧调用 handle 一次，一帧的时间跟显示器刷新频率有关，可能是60帧每秒，即16毫秒一帧
            // System.out.println(System.currentTimeMillis() + " animation timer
            // handle...");

            t += 0.017;

            // Point2D point2d = circleFunction(t);
            Point2D point2d = curveFunction(t);

            double newX = 300 + point2d.getX();
            double newY = 200 + point2d.getY();

            graphicsContext2D.setStroke(Color.BLUE);
            graphicsContext2D.strokeOval(newX, newY, 1, 1);
        }

        private static Point2D circleFunction(double t) {
            // 圆形的动画参数方程
            double x = Math.cos(t);
            double y = Math.sin(t);

            return new Point2D(x, y).multiply(100); // 乘以100使其离圆心更远
        }

        private static Point2D curveFunction(double t) {
            // 一个画蝴蝶的动画参数方程 https://en.wikipedia.org/wiki/Butterfly_curve_(transcendental)
            double x = sin(t) * (pow(E, cos(t)) - 2 * cos(4 * t) - pow(sin(t / 12), 5));
            double y = cos(t) * (pow(E, cos(t)) - 2 * cos(4 * t) - pow(sin(t / 12), 5));

            return new Point2D(x, -y).multiply(50);
        }

    }

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle(this.getClass().getSimpleName());
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();
    }

    private Parent createContent() {
        Pane pane = new Pane();
        pane.setPrefSize(600, 400);

        Canvas canvas = new Canvas(600, 400);
        GraphicsContext graphicsContext2D = canvas.getGraphicsContext2D();
        pane.getChildren().add(canvas);

        CustomAnimationTimer animationTimer = new CustomAnimationTimer(graphicsContext2D);
        animationTimer.start();

        return pane;
    }
}
