package src.Model;

import java.util.ArrayList;

public class Parent extends User{
    private ArrayList<Child> children = new ArrayList<>();

    public Parent(String name) {
        super(name);
    }

    public ArrayList<Child> getChildren(){return this.children;}

    public void addChild(Child child) {
        this.children.add(child);
    }

    public void setChildTask(Child c, Task t) {
        c.getPlan().addTask(t);
    }
}
