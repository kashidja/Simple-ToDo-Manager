package jku.ssw.todo;


import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import jku.ssw.todo.model.ToDo;
import jku.ssw.todo.model.ToDoModel;


public class TodoController {
    @FXML
    private TextField titleField;
    @FXML
    private TextField priorityField;
    @FXML
    private CheckBox doneBox;
    @FXML
    private TableView<ToDo> tableView;

    @FXML
    private TableColumn<ToDo, String> titleColumn;

    @FXML
    private TableColumn<ToDo, String> priorityColumn;

    @FXML
    private TableColumn<ToDo, Boolean> doneColumn;

    @FXML
    private TableColumn<ToDo, String> statusColumn;

    private final ToDoModel model = new ToDoModel();

    @FXML
    protected void initialize() {
        tableView.setItems(model.getToDos());
        tableView.setEditable(true);
        tableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        titleColumn.setCellValueFactory(data -> data.getValue().titleProperty());
        priorityColumn.setCellValueFactory(data -> data.getValue().priorityProperty());
        statusColumn.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
        doneColumn.setCellValueFactory(cellData -> cellData.getValue().doneProperty());

        doneColumn.setCellFactory(CheckBoxTableCell.forTableColumn(doneColumn));
        doneColumn.setEditable(true);

        tableView.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldTodo, newTodo) -> {
                    if (oldTodo != null) {
                        titleField.textProperty().unbindBidirectional(oldTodo.titleProperty());
                        priorityField.textProperty().unbindBidirectional(oldTodo.priorityProperty());
                        doneBox.selectedProperty().unbindBidirectional(oldTodo.doneProperty());
                    }
                    if (newTodo != null) {
                        titleField.textProperty().bindBidirectional(newTodo.titleProperty());
                        priorityField.textProperty().bindBidirectional(newTodo.priorityProperty());
                        doneBox.selectedProperty().bindBidirectional(newTodo.doneProperty());
                    }
                }
        );

    }


    @FXML
    protected void addToDo() {
        ToDo newTodo = new ToDo("", "", false);
        model.getToDos().add(newTodo);
        tableView.getSelectionModel().select(newTodo); // select it and change it
    }

    @FXML
    protected void removeToDo() {
        final ToDo d = tableView.getSelectionModel().getSelectedItem();
        if (d != null) {
            model.getToDos().remove(d);
        }
    }

}