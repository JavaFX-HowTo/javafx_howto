package org.juju;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.apache.commons.text.StringEscapeUtils;

import java.nio.charset.StandardCharsets;

public class UnicodeConvert
{
    private VBox root;
    private TextArea stringTextArea;
    private TextArea unicodeTextArea;

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

        Label stringLabel = new Label("字符串");
        stringTextArea = new TextArea();

        Label unicodeLabel = new Label("Unicode");
        unicodeTextArea = new TextArea();

        Button stringToUnicodeButton = new Button("字符串转Unicode");
        stringToUnicodeButton.setOnAction( e -> stringToUnicode() );
        Button unicodeToStringButton = new Button("Unicode转字符串");
        unicodeToStringButton.setOnAction( e -> unicodeToString() );
        Button octUnicodeToStringButton = new Button("8进制Unicode转字符串");
        octUnicodeToStringButton.setOnAction( e -> octUnicodeToString() );

        HBox buttonHBox = new HBox();
        buttonHBox.setSpacing(10);
        buttonHBox.getChildren().addAll(stringToUnicodeButton, unicodeToStringButton, octUnicodeToStringButton);

        root.getChildren().addAll(stringLabel, stringTextArea,
                buttonHBox,
                unicodeLabel, unicodeTextArea);
    }

    private void stringToUnicode()
    {
        unicodeTextArea.clear();
        for (int i = 0; i < stringTextArea.getText().length(); i++)
        {
            char c = stringTextArea.getText().charAt(i);

            String unicode = ( "\\u" + Integer.toHexString(c | 0x10000).substring(1) );
            unicodeTextArea.appendText(unicode);
        }
    }

    private void unicodeToString()
    {
        try
        {
            String str = StringEscapeUtils.unescapeJava(unicodeTextArea.getText());
            stringTextArea.setText(str);
        }
        catch (Exception e)
        {
            Util.openExceptionWindow(e);
        }
    }

    private void octUnicodeToString()
    {
        try
        {
            String unicodeToConvert = StringEscapeUtils.unescapeJava(unicodeTextArea.getText());
            byte[] c = unicodeToConvert.getBytes(StandardCharsets.ISO_8859_1);
            String str = new String (c,StandardCharsets.UTF_8);

            stringTextArea.setText(str);
        }
        catch (Exception e)
        {
            Util.openExceptionWindow(e);
        }
    }
}
