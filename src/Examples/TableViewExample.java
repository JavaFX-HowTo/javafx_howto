import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
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
    
    public TableView<Student> studentTableView;
    private ObservableList<Student> studentList;
    private TextField nameTextField;
    private TextField ageTextField;

    private void onSelectItem(Student item)
    {
        if (item != null)
        {
            System.out.println(String.format("name: %s, age: %d", item.getName(), item.getAge()));
        }
    }

    private void addStudent()
    {
        String name = nameTextField.getText();
        int age = Integer.parseInt(ageTextField.getText());

        Student student = new Student(name, age);
        studentList.add(student);

        nameTextField.clear();
        ageTextField.clear();
    }

    private void delStudent()
    {
        Student selectedItem = studentTableView.getSelectionModel().getSelectedItem();
        studentList.remove(selectedItem);
    }

    public void buildStudentTableView()
    {
        studentList = FXCollections.observableArrayList();

        studentTableView = new TableView<>();
        studentTableView.setItems(studentList);
        studentTableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> onSelectItem(newValue) );
        
        TableColumn<Student, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<Student, String> ageColumn = new TableColumn<>("Age");
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        
        studentTableView.getColumns().add(nameColumn);
        studentTableView.getColumns().add(ageColumn);

        studentList.add(new Student("Tom", 21));
        studentList.add(new Student("Jim", 23));
        studentList.add(new Student("Micle", 18));
        studentList.add(new Student("Lucy", 32));
    }

    private HBox buildInputLayout()
    {
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        
        nameTextField = new TextField();
        nameTextField.setPromptText("Name");
        nameTextField.setPrefWidth(100);
        ageTextField = new TextField();
        ageTextField.setPromptText("Age");
        ageTextField.setPrefWidth(100);

        Button addButton = new Button("ADD");
        addButton.setOnAction(e -> addStudent() );
        Button delButton = new Button("DEL");
        delButton.setOnAction(e -> delStudent() );

        hBox.getChildren().addAll(nameTextField, ageTextField, addButton, delButton);

        return hBox;
    }

    @Override
    public void start(Stage window) throws Exception
    {
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10));
        vBox.setSpacing(10);

        this.buildStudentTableView();
        vBox.getChildren().add(studentTableView);

        HBox inputLayout = this.buildInputLayout();
        vBox.getChildren().add(inputLayout);

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