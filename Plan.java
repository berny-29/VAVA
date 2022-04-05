import java.time.OffsetDateTime;
import java.util.ArrayList;

public class Plan {
    OffsetDateTime start;       //Ten start a end sme ako mysleli v tom plane?
    OffsetDateTime end;
    ArrayList<Task> tasks;

    Plan(){
        this.tasks = new ArrayList<Task>();
    }

    public Task pridajCiel(){
        Task task = new Task();
        this.tasks.add(task);
        return task;
    }
}
