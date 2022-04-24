package src.Model;

import java.util.ArrayList;

public class Parent extends User{
    ArrayList<Child> children = new ArrayList<>();

    public Parent(String name, int age) {
        super(name, age);
    }


    public void addChild(Child child) {
        this.children.add(child);
    }

    public void setChildTask(Child c, Task t) {
        c.getPlan().addTask(t);
    }
}
