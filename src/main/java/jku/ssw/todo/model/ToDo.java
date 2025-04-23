package jku.ssw.todo.model;
import javafx.beans.binding.Bindings;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ToDo {
    private final StringProperty title;
    private final StringProperty priority;
    private final BooleanProperty doneCheck;
    private final StringProperty status;

    public ToDo(String title, String priority, boolean doneCheck) {
        this.title = new SimpleStringProperty(title);
        this.priority = new SimpleStringProperty(priority);
        this.doneCheck=new SimpleBooleanProperty(doneCheck);
        this.status = new SimpleStringProperty();

        this.status.bind(Bindings.when(this.doneCheck)
                .then("done")
                .otherwise("todo"));


    }
    public String getTitle(){
        return title.get();
    }
    public StringProperty titleProperty(){
        return title;
    }
    public String getPriority(){
        return priority.get();
    }
    public StringProperty priorityProperty(){
        return priority;
    }

    public boolean getDoneCheck(){
        return doneCheck.get();
    }
    public BooleanProperty doneProperty(){
        return doneCheck;
    }
    public String getStatus(){
        return status.get();
    }
    public StringProperty statusProperty(){
        return status;
    }

}
