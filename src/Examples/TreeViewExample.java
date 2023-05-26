import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TreeViewExample extends Application
{
    private TreeView<String> animalTreeView;

    private void onSelectItem(String item)
    {
        System.out.println(item);
    }

    private void buildAnimalTreeView()
    {
        animalTreeView = new TreeView<>();
        TreeItem<String> root = new TreeItem<>("动物");
        animalTreeView.setRoot(root);

        // 监听当前的选择
        animalTreeView.getSelectionModel().selectedItemProperty().addListener( 
            (observable, oldValue, newValue) -> onSelectItem(newValue.getValue()) 
        );

        TreeItem<String> birdTree = new TreeItem<>("鸟类");
        birdTree.getChildren().add(new TreeItem<>("麻雀"));
        birdTree.getChildren().add(new TreeItem<>("乌鸦"));
        birdTree.getChildren().add(new TreeItem<>("燕子"));
        root.getChildren().add(birdTree);

        TreeItem<String> mammalTree = new TreeItem<>("哺乳类");
        mammalTree.getChildren().add(new TreeItem<String>("猫"));
        mammalTree.getChildren().add(new TreeItem<String>("狗"));
        mammalTree.getChildren().add(new TreeItem<String>("兔子"));
        root.getChildren().add(mammalTree);
    }

    @Override
    public void start(Stage window) throws Exception
    {
        VBox vBox = new VBox();

        this.buildAnimalTreeView();
        vBox.getChildren().add(animalTreeView);

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