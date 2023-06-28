package org.juju;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class LongIntConvert {

    private VBox root;
    private TextField longTextField;
    private TextField highIntTextField;
    private TextField lowInTextField;

    public Node getNode() {
        if (root == null) {
            this.init();
        }

        return root;
    }

    private void init() {
        HBox longHBox = new HBox(10);
        longTextField = new TextField();
        Button longTransBtn = new Button("trans to int");
        longTransBtn.setOnAction(e -> longToInt() );
        longHBox.getChildren().addAll(new Label("long:"), longTextField, longTransBtn);

        HBox intBox = new HBox(10);
        highIntTextField = new TextField();
        lowInTextField = new TextField();
        Button intTransBtn = new Button("trans to long");
        intTransBtn.setOnAction(e -> intToLong() );
        intBox.getChildren().addAll(new Label("high int:"), highIntTextField, new Label("low int:"), lowInTextField, intTransBtn);

        root = new VBox(10);
        root.getChildren().addAll(longHBox, intBox);

    }

    private void longToInt()
    {
        try
        {
            long l = Long.parseLong(longTextField.getText());
            int highInt = (int)(l >> 32);
            int lowInt = (int)(l & 0xffffffffl);

            highIntTextField.setText(String.valueOf(highInt));
            lowInTextField.setText(String.valueOf(lowInt));
        }
        catch (Exception e)
        {
            Util.openExceptionWindow(e);
        }

    }

    private void intToLong()
    {
        try
        {
            int highInt = Integer.parseInt(highIntTextField.getText());
            int lowInt = Integer.parseInt(lowInTextField.getText());

            long l = (long)highInt << 32 | lowInt;

            longTextField.setText(String.valueOf(l));
        }
        catch (Exception e)
        {
            Util.openExceptionWindow(e);
        }
    }
}
