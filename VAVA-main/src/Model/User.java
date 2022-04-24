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
    private User user;
    //TODO ---> Kalendar kalendar;

    //TODO konstruktor
    //Tu neviem aku dame inicializaciu ci singleton,
    //alebo norm?

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //TOTO on login alebo register vytvorit noveho usera typu parent, potom parent.addChild()
    public void setStaticUser(User user) {
        this.user = user;
    }

    public User getStaticUser() {
        return this.user;
    }

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
