package org.juju;

import javafx.scene.control.Alert;

public class Util
{
    public static void openExceptionWindow(Exception e)
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("转换失败");
        alert.setHeaderText(null);
        alert.setContentText(e.getClass().getSimpleName() + ": " + e.getMessage());
        alert.showAndWait();
    }
}
