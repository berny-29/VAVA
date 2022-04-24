package src.Model;

import java.util.ArrayList;

public class Parent extends User{
    ArrayList<Child> children = new ArrayList<>();


    public void addChild(Child child) {
        this.children.add(child);
    }

    public void setChildTask(Child c, Task t) {
        c.getPlan().addTask(t);
    }
}
