package org.juju;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class NumberConvert
{
    private VBox root;
    private GridPane gridPane;
    private TextField textField_10;
    private TextField textField_2;
    private TextField textField_8;
    private TextField textField_16;
    private Label errorLabel;

    public Node getNode()
    {
        if (root == null)
        {
            this.init();
        }

        return root;
    }

    private void init()
    {
        root = new VBox();
        root.setSpacing(10);

        gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(5);
        root.getChildren().add(gridPane);

        Label label_10 = new Label("十进制");
        textField_10 = new TextField();
        textField_10.textProperty().addListener((observable, oldValue, newValue) -> doConvert() );
        
        Label label_2 = new Label("二进制");
        textField_2 = new TextField();
        textField_2.textProperty().addListener((observable, oldValue, newValue) -> doConvert() );

        Label label_8 = new Label("八进制");
        textField_8 = new TextField();
        textField_8.textProperty().addListener((observable, oldValue, newValue) -> doConvert() );

        Label label_16 = new Label("十六进制");
        textField_16 = new TextField();
        textField_16.textProperty().addListener((observable, oldValue, newValue) -> doConvert() );

        gridPane.add(label_10, 0, 0);
        gridPane.add(textField_10, 1, 0);
        gridPane.add(label_2, 0, 1);
        gridPane.add(textField_2, 1, 1);
        gridPane.add(label_8, 0, 2);
        gridPane.add(textField_8, 1, 2);
        gridPane.add(label_16, 0, 3);
        gridPane.add(textField_16, 1, 3);

        errorLabel = new Label();
        root.getChildren().add(errorLabel);
    }

    private void doConvert()
    {
        String decimal = "";
        String binary = "";
        String octal = "";
        String hex = "";
        errorLabel.setText("");

        try
        {
            int decimalNum = 0;

            if (textField_10.isFocused())
            {
                if (textField_10.getText().isEmpty())
                {
                    return;
                }
                decimalNum = Integer.parseInt(textField_10.getText());
            }
            else if (textField_2.isFocused())
            {
                if (textField_2.getText().isEmpty())
                {
                    return;
                }
                decimalNum = Integer.parseInt(textField_2.getText(), 2);
            }
            else if (textField_8.isFocused())
            {
                if (textField_8.getText().isEmpty())
                {
                    return;
                }
                decimalNum = Integer.parseInt(textField_8.getText(), 8);
            }
            else if (textField_16.isFocused())
            {
                if (textField_16.getText().isEmpty())
                {
                    return;
                }
                decimalNum = Integer.parseInt(textField_16.getText(), 16);
            }

            decimal = Integer.toString(decimalNum);
            binary = Integer.toBinaryString(decimalNum);
            octal = Integer.toOctalString(decimalNum);
            hex = Integer.toHexString(decimalNum);
        }
        catch (Exception e)
        {
            errorLabel.setText("wrong input: " + e.getMessage());
            return;
        }

        textField_10.setText(decimal);
        textField_2.setText(binary);
        textField_8.setText(octal);
        textField_16.setText(hex);
    }
}
