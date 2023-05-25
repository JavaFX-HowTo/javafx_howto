import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChoiceBoxExample extends Application
{
    static class CityItem
    {
        private int id;
        private String name;

        public CityItem(int id, String name)
        {
            this.id = id;
            this.name = name;
        }

        public int getId() { return id; }
        public String getName() { return name; }
        public String toString() { return name; }
    }

    private ChoiceBox<CityItem> countryChoiceBox;

    private void getChoice()
    {
        CityItem cityItem = countryChoiceBox.getValue();
        if (cityItem == null)
        {
            System.out.println("You haven't make a choice yet");
        }
        else
        {
            System.out.println(String.format("id: %d, name: %s", cityItem.getId(), cityItem.getName()));
        }
    }

    @Override
    public void start(Stage window) throws Exception
    {
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10));
        vBox.setSpacing(10);

        countryChoiceBox = new ChoiceBox<>();
        countryChoiceBox.getItems().add(new CityItem(1, "Beijing"));
        countryChoiceBox.getItems().add(new CityItem(2, "Shanghai"));
        countryChoiceBox.getItems().add(new CityItem(3, "Guangzhou"));

        Button button = new Button("Make Choice");
        button.setOnAction( e -> getChoice() );

        vBox.getChildren().addAll(countryChoiceBox, button);

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