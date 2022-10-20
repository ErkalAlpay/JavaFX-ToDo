package controller;

import com.example.loginscreen4.ToDo;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ToDoController implements Initializable {



    @FXML
    private TableView<ToDo> myTable;

    @FXML
    private TableColumn<ToDo, Boolean> completedColumn;

    @FXML
    private TableColumn<ToDo, String> toDoColumn;

    @FXML
    private TextField sistemeGirilecekToDo;

    @FXML
    void secilenToDoSil(ActionEvent event) {

    }

    @FXML
    void toDoEkle(ActionEvent event) throws SQLException {

        ToDo todo = new ToDo();
        todo.setTodo(sistemeGirilecekToDo.getText());
        todoList.add(todo);
        DataAccess.getInstance().saveTodo(todo);

    }

    ObservableList<ToDo> todoList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
   // toDoColumn.setCellFactory(new PropertyValueFactory<ToDo, String>());









    }
}

