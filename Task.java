import java.time.OffsetDateTime;
/**
 * @author: Spol XD, akt(Filo,)
 * describtion: ponechavam vasej predstavivosti
 */
public class Task {
    private String desc;
    private boolean stat = false, repetitiveTask = false;
    private OffsetDateTime start, end;

    //TODO konstruktor spustitelny z funkcie planu addTask()
    /**
     * repetitiveTask doesnt need setter beacuse
     *it is set in constructor, at least that is idea
     * Same with a start, it shoud be inicializated in constructor
     *
     * Or do you have better idea
     */



    //Geters
    public String getDesc() {
        return desc;
    }
    public boolean isStat() {
        return stat;
    }
    public boolean isRepetitiveTask() {
        return repetitiveTask;
    }
    public OffsetDateTime getEnd() {
        return end;
    }
    public OffsetDateTime getStart() {
        return start;
    }
    //Setters
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public void setStat(boolean stat) {
        this.stat = stat;
    }
    public void setEnd(OffsetDateTime end) {
        this.end = end;
    }



}
