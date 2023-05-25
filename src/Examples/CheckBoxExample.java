import java.util.Map;
import java.util.TreeMap;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CheckBoxExample extends Application
{
    private Map<Integer, CheckBox> orderMap; // id -> CheckBox

    private void getOrder()
    {
        Map<Integer, String> orderedFruits = new TreeMap<>();
        for (Map.Entry<Integer, CheckBox> entry : orderMap.entrySet())
        {
            CheckBox checkBox = entry.getValue();
            int id = entry.getKey();
            if (checkBox.isSelected())
            {
                orderedFruits.put(id, checkBox.getText());
            }
        }

        if (orderedFruits.isEmpty())
        {
            System.out.println("You have no order");
        }
        else
        {
            System.out.println("Your order is: " + orderedFruits);
        }
    }

    @Override
    public void start(Stage window) throws Exception
    {
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10));
        vBox.setSpacing(10);

        CheckBox appleCheckBox = new CheckBox("Apple");
        CheckBox orangeCheckBox = new CheckBox("Orange");
        CheckBox bananaCheckBox = new CheckBox("Banana");
        
        orderMap = new TreeMap<>();
        orderMap.put(1, appleCheckBox);
        orderMap.put(2, orangeCheckBox);
        orderMap.put(3, bananaCheckBox);

        Button orderButton = new Button("Make Order");
        orderButton.setOnAction(e -> getOrder() );

        vBox.getChildren().addAll(
            appleCheckBox,
            orangeCheckBox,
            bananaCheckBox,
            orderButton);

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