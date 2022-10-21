package controller;

import com.example.loginscreen4.ToDo;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ToDoController implements Initializable {


    @FXML
    private TableView<ToDo> myTable;

    @FXML
    private TableColumn<ToDo, CheckBox> completedColumn;

    @FXML
    private TableColumn<ToDo, String> toDoColumn;

    @FXML
    private TextField sistemeGirilecekToDo;


    @FXML
    void secilenToDoSil(ActionEvent event) throws SQLException {
        ToDo secilmisToDo = myTable.getSelectionModel().getSelectedItem();
        myTable.getItems().removeAll(myTable.getSelectionModel().getSelectedItem());
        DataAccess.getInstance().deleteTodo(secilmisToDo);
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
        completedColumn.setCellValueFactory(new PropertyValueFactory<ToDo, CheckBox>("isCheckBox"));
        toDoColumn.setCellValueFactory(new PropertyValueFactory<ToDo, String>("todo"));
        myTable.setItems(todoList);
        try {
            ArrayList<ToDo> todoListDb = DataAccess.getInstance().getToDoList();
            todoList.addAll(todoListDb);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

