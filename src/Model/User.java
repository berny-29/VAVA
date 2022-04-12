package src.Model;

import src.Model.Plan;

/**
 * @author: Spol XD, akt(Filo,)
 * describtion: ponechavam vasej predstavivosti
*/
public class User {
    //TODO nvm ci netreba tuto classu dedit z account?
    private String name;
    private int age, id;
    private Plan plan;
    //TODO ---> Kalendar kalendar;

    //TODO konstruktor
    //Tu neviem aku dame inicializaciu ci singleton,
    //alebo norm?



    //Geters
    public int getAge() {
        return age;
    }
    public int getId() {
        return id;
    }

    public Plan getPlan() {
        return plan;
    }
    //Seters
    public void setAge(int age) {
        this.age = age;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setPlan(Plan plan) {
        this.plan = plan;
    }
}
