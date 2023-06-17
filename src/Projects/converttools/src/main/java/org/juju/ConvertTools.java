package org.juju;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ConvertTools extends Application
{
    private VBox root;
    private MenuBar menuBar;
    private StackPane functionView;

    private void buildMenuBar()
    {
        menuBar = new MenuBar();

        Menu functionMenu = new Menu("功能");
        menuBar.getMenus().add(functionMenu);

        MenuItem numberConvertMenuItem = new MenuItem("进制转换");
        numberConvertMenuItem.setOnAction( e -> setFunctionView(new NumberConvert().getNode(), "进制转换") );
        functionMenu.getItems().add(numberConvertMenuItem);

        MenuItem timeConvertMenuItem = new MenuItem("时间转换");
        timeConvertMenuItem.setOnAction( e -> setFunctionView(new TimeConvert().getNode(), "时间转换") );
        functionMenu.getItems().add(timeConvertMenuItem);

        MenuItem unicodeConvertMenuItem = new MenuItem("Unicode转换");
        unicodeConvertMenuItem.setOnAction( e -> setFunctionView(new UnicodeConvert().getNode(), "Unicode转换") );
        functionMenu.getItems().add(unicodeConvertMenuItem);
    }

    private void setFunctionView(Node node, String functionName)
    {
        functionView.getChildren().clear();

        VBox rootVBox = new VBox();
        rootVBox.setPadding(new Insets(10));
        rootVBox.setSpacing(10);

        rootVBox.getChildren().add(new Label(functionName));
        rootVBox.getChildren().add(new Separator());
        rootVBox.getChildren().add(node);

        functionView.getChildren().add(rootVBox);
        rootVBox.requestFocus();
    }

    @Override
    public void start(Stage window) throws Exception
    {
        root = new VBox();

        this.buildMenuBar();
        root.getChildren().add(menuBar);

        functionView = new StackPane();
        root.getChildren().add(functionView);

        Scene scene = new Scene(root, 600, 400);

        window.setScene(scene);
        window.setTitle(this.getClass().getSimpleName());
        window.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}