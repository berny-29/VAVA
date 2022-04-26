package src.Model;

import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;

public class Plan {
    private OffsetDateTime start;       
    private OffsetDateTime end;
    private ArrayList<Task> tasks;
    private String name;

    public Plan(){
        this.tasks = new ArrayList<Task>();
    }

    

    public Task addTask(String desc, LocalTime start, LocalTime end){
        Task task = new Task();
        task.setDesc(desc);
        task.setStart(start);
        task.setEnd(end);
        this.tasks.add(task);
        return task;
    }

    public void addTask(Task t) {
        this.tasks.add(t);
    }
    //Geters
    public OffsetDateTime getStart() {
        return start;
    }
    public OffsetDateTime getEnd() {
        return end;
    }
    public String getName(){ return this.name;}
    public ArrayList<Task> getTasks() { return this.tasks; }
    //Setters
    public void setStart(OffsetDateTime start) {
        this.start = start;
    }
    public void setEnd(OffsetDateTime end) {
        this.end = end;
    }

    public void setName(String s) {
        this.name = s;
    }
}
