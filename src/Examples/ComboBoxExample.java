import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ComboBoxExample extends Application
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

    private ComboBox<CityItem> countryComboBox;

    private void getChoice()
    {
        String text = countryComboBox.getEditor().getText();
        for (CityItem cityItem : countryComboBox.getItems())
        {
            if (cityItem.getName().equals(text))
            {
                System.out.println(String.format("id: %d, name: %s", cityItem.getId(), cityItem.getName()));
                return;
            }
        }

        System.out.println("no such city: " + text);
    }

    @Override
    public void start(Stage window) throws Exception
    {
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10));
        vBox.setSpacing(10);

        countryComboBox = new ComboBox<>();
        countryComboBox.getItems().add(new CityItem(1, "Beijing"));
        countryComboBox.getItems().add(new CityItem(2, "Shanghai"));
        countryComboBox.getItems().add(new CityItem(3, "Guangzhou"));
        countryComboBox.setEditable(true);

        Button button = new Button("Make Choice");
        button.setOnAction( e -> getChoice() );

        vBox.getChildren().addAll(countryComboBox, button);

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