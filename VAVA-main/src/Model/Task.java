package src.Model;

import java.time.OffsetDateTime;
/**
 * @author: Spol XD, akt(Filo,)
 * describtion: ponechavam vasej predstavivosti
 */
public class Task {
    private boolean stat = false, repetitiveTask = false;
    private String desc;
    private LocalTime start, end;

    //TODO konstruktor spustitelny z funkcie planu addTask()
    /**
     * repetitiveTask doesnt need setter beacuse
     *it is set in constructor, at least that is idea
     * Same with a start, it shoud be inicializated in constructor
     *
     * Or do you have better idea
     */
    //

    public Task() {

    }

    public Task(String desc) {
        this.desc = desc;
    }


    public boolean isStat() {
        return stat;
    }
    public boolean isRepetitiveTask() {
        return repetitiveTask;
    }
    //Geters
    public String getDesc() {
        return desc;
    }
    public LocalTime getEnd() {
        return end;
    }
    public LocalTime getStart() {
        return start;
    }
    //Setters
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public void setStat(boolean stat) {
        this.stat = stat;
    }
    public void setStart(LocalTime start) {
        this.start = start;
    }
    public void setEnd(LocalTime end) {
        this.end = end;
    }



}
