package src.Model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
/**
 * @author: Spol XD, akt(Filo,)
 * describtion: ponechavam vasej predstavivosti
*/
public class Plan {
    private OffsetDateTime start;       //Ten start a end sme ako mysleli v tom plane?
    private OffsetDateTime end;
    private ArrayList<Task> tasks;

    Plan(){
        this.tasks = new ArrayList<Task>();
    }

    //TODO este chyba geter a setter pre tasks, ale tam treba uvazovat ako budeme pristupovat k jednotlivim elementom?
    // funkica nato je array.get(), ale ako ich budeme identifikovat?

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
    //Setters
    public void setStart(OffsetDateTime start) {
        this.start = start;
    }
    public void setEnd(OffsetDateTime end) {
        this.end = end;
    }
}
