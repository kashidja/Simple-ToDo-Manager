module jku.ssw.todo {
    requires javafx.controls;
    requires javafx.fxml;


    opens jku.ssw.todo to javafx.fxml;
    exports jku.ssw.todo;
    exports jku.ssw.todo.model;
    opens jku.ssw.todo.model to javafx.fxml;
}