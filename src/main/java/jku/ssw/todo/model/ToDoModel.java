package jku.ssw.todo.model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ToDoModel {
    private final ObservableList<ToDo> toDos;

    public ToDoModel() {
        toDos = FXCollections.observableArrayList(TestData.createData());
    }

    public ObservableList<ToDo> getToDos() {
        return toDos;
    }

}
