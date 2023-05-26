import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TableViewExample extends Application
{
    public static class Student 
    {
        private String name;
        private int age;
    
        public Student(String name, int age)
        {
            this.name = name;
            this.age = age;
        }
    
        public String getName() { return name; }
        public int getAge() { return age; }
    }
    

    private TableView<Student> studentTableView;

    private void onSelectItem(Student item)
    {
        System.out.println(String.format("name: %s, age: %d", item.getName(), item.getAge()));
    }

    private void buildStudentTableView()
    {
        studentTableView = new TableView<>();
        studentTableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> onSelectItem(newValue) );
        
        TableColumn<Student, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<Student, String> ageColumn = new TableColumn<>("Age");
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        
        studentTableView.getColumns().add(nameColumn);
        studentTableView.getColumns().add(ageColumn);

        studentTableView.getItems().add(new Student("Tom", 21));
        studentTableView.getItems().add(new Student("Jim", 23));
        studentTableView.getItems().add(new Student("Micle", 18));
    }

    @Override
    public void start(Stage window) throws Exception
    {
        VBox vBox = new VBox();

        this.buildStudentTableView();
        vBox.getChildren().add(studentTableView);

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