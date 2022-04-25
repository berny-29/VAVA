package src.Model;

import src.Model.Plan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author: Spol XD, akt(Filo,)
 * describtion: ponechavam vasej predstavivosti
*/
public class User {
    //TODO nvm ci netreba tuto classu dedit z account?
    private String name;
    private int age, id;
    private Plan plan;
    private static User activeUser;
    //TODO ---> Kalendar kalendar;

    //TODO konstruktor
    //Tu neviem aku dame inicializaciu ci singleton,
    //alebo norm?

    public static void setActiveUser(String name,  String role) {
        if ( !role.equals("admin") ) {
            activeUser = new Parent(name);
        } else {
            activeUser = new User(name);
        }
    }

    public static User getActiveUser(){
        return activeUser;
    }


    public User(String name) {
        this.name = name;
    }

    //TOTO on login alebo register vytvorit noveho usera typu parent, potom parent.addChild()
    //public void setStaticUser(User user) {this.user = user;    }

  //  public User getStaticUser() {      return this.user;   }

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

    public void addChild(Child child) {
    }

    public ResultSet getUserData(String email){
        try {;
            Connection conn = Database.getInstance().getConnection();
            String statement = "SELECT * FROM account where email = ?";

            PreparedStatement query = conn.prepareStatement(statement);
            query.setString(1, email);


            ResultSet row = query.executeQuery();


            ResultSet r = query.executeQuery();
            return r;
        } catch (Exception e) {
            return null;
        }
    }
}
