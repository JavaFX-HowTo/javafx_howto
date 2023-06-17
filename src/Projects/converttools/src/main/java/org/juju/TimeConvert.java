package org.juju;

import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class TimeConvert
{
    private VBox root;

    private TextField timestampTextField;
    private TextField timestampToDescTextField;

    private TextField timeDescTextField;
    private TextField timeDescToTimestampTextField;

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

        {
            Label timestampLabel = new Label("时间戳");
            timestampTextField = new TextField();
            Button timestampConvertBtn = new Button("转时间描述");
            timestampConvertBtn.setOnAction( e -> convertTimestampToDesc() );
            timestampToDescTextField = new TextField();
            timestampToDescTextField.setEditable(false);
            HBox timestampHBox = new HBox(timestampLabel, timestampTextField, timestampConvertBtn, timestampToDescTextField);
            timestampHBox.setSpacing(10);

            root.getChildren().add(timestampHBox);
        }

        {
            Label timeDescLabel = new Label("时间描述");
            timeDescTextField = new TextField();
            Button timeDescConvertBtn = new Button("转时间戳");
            timeDescConvertBtn.setOnAction( e -> convertTimeDescToTimestamp() );
            timeDescToTimestampTextField = new TextField();
            timeDescToTimestampTextField.setEditable(false);
            HBox timeDescHBox = new HBox(timeDescLabel, timeDescTextField, timeDescConvertBtn, timeDescToTimestampTextField);
            timeDescHBox.setSpacing(10);

            root.getChildren().add(timeDescHBox);
        }


    }

    private void convertTimestampToDesc()
    {
        try
        {
            long timestamp = Long.parseLong(timestampTextField.getText());
            Date date = new Date(timestamp * 1000);

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            timestampToDescTextField.setText(sdf.format(date));
        }
        catch (Exception e)
        {
            Util.openExceptionWindow(e);
        }
    }

    private void convertTimeDescToTimestamp()
    {
        try
        {
            long timestamp = convertTimestampHelper(timeDescTextField.getText()) / 1000;
            timeDescToTimestampTextField.setText(String.valueOf(timestamp));
        }
        catch (Exception e)
        {
            Util.openExceptionWindow(e);
        }
    }

    public static ZoneOffset getDefaultZoneOffset()
    {
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime = ZonedDateTime.of(LocalDateTime.now(), zoneId);
        ZoneOffset zoneOffset = zoneId.getRules().getOffset(zonedDateTime.toInstant());

        return zoneOffset;
    }

    public static long convertTimestampHelper(String timestampDesc)
    {
        String[] patterns = {
                "yyyy-MM-dd HH:mm:ss",
        };

        LocalDateTime dateTime = null;
        for (String pattern : patterns)
        {
            try
            {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
                dateTime = LocalDateTime.parse(timestampDesc, formatter);
                break;
            }
            catch (DateTimeParseException e)
            {
                // 当前模式不匹配，尝试下一个模式
            }
        }

        if (dateTime != null)
        {
            return dateTime.toInstant(getDefaultZoneOffset()).toEpochMilli();
        }
        else
        {
            throw new IllegalArgumentException("无法解析时间描述：" + timestampDesc);
        }
    }
}
