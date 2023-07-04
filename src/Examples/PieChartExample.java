import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PieChartExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle(this.getClass().getSimpleName());
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();
    }
    
    private Parent createContent() {
        VBox root = new VBox(10);
        root.setPrefSize(600, 400);

        ObservableList<PieChart.Data> pieDatas = FXCollections.observableArrayList();
        PieChart pieChart = new PieChart(pieDatas);
        pieDatas.add(new PieChart.Data("魏", 60));
        pieDatas.add(new PieChart.Data("蜀", 10));
        pieDatas.add(new PieChart.Data("吴", 30));

        root.getChildren().add(pieChart);

        return root;
    } 
}
