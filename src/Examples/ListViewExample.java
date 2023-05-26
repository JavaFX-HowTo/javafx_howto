import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ListViewExample extends Application
{
    private ListView<String> fruitsListView;

    private void getOrder()
    {
        ObservableList<String> selectedItems = fruitsListView.getSelectionModel().getSelectedItems();
        if (selectedItems.isEmpty())
        {
            System.out.println("You haven't make order yet");
        }
        else
        {
            System.out.println("Your order is:");
            for (String item : selectedItems)
            {
                System.out.println(item);
            }
        }
    }

    @Override
    public void start(Stage window) throws Exception
    {
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10));
        vBox.setSpacing(10);

        fruitsListView = new ListView<>();
        fruitsListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE); // 设置可多选
        fruitsListView.getItems().addAll("Apple", "Orange", "Banana");

        Button button = new Button("Make Order");
        button.setOnAction( e -> getOrder() );

        vBox.getChildren().addAll(fruitsListView, button);

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