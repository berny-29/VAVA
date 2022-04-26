package src.Model;

import src.Model.Plan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class User {
    
    private String name;
    private int age, id;
    private Plan plan;
    private static User activeUser = new User();
    private ArrayList<Child> childs = new ArrayList<>();
    private ArrayList<String> names = new ArrayList<>();
    

    public User(){}

    public String getName(){
        return this.name;
    }

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

    public int findChildId(String firstName) throws SQLException {
        Connection conn = Database.getInstance().getConnection();
        int childId = 0;
        String sql = "select a.id from accounts a where firstname = ?";
        PreparedStatement pf = conn.prepareStatement(sql);
        pf.setString(1, firstName);

        ResultSet rowf = pf.executeQuery();
        while (rowf.next()){
            childId = rowf.getInt(1);
        }
        return childId;
    }




    public User(String name) {
        this.name = name;
    }

    public ArrayList<Child> getChilds(String email) throws SQLException {

        int id = User.getActiveUser().getUserID(email);


        Connection conn = Database.getInstance().getConnection();

        String sql = "select c.id from children c join accounts a on c.parent_id = a.id where a.id = ?";
        PreparedStatement pf = conn.prepareStatement(sql);
        pf.setInt(1, id);
        StringBuilder sb = new StringBuilder();
        ResultSet rowf = pf.executeQuery();
        if (rowf.next()) {
             do {
                sb.append(rowf.getInt(1));
                sb.append(",");
            }while (rowf.next());

            String[] array = sb.toString().split(",");

            for (String s : array) {
                String sql1 = "select * from accounts where id = ?";
                pf = conn.prepareStatement(sql1);
                int i = Integer.parseInt(s);
                pf.setInt(1, i);
                ResultSet rowf1 = pf.executeQuery();
                while (rowf1.next()) {

                    Child child = new Child(rowf1.getString(2));
                    childs.add(child);
                }

            }


        }
        return childs;
    }

    public ArrayList<Child> getChilds() {
        return childs;
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

    public int addChild(String email) throws SQLException {
        int id = User.getActiveUser().getId();


        Connection conn = Database.getInstance().getConnection();

        String sql = "Select * from Accounts where email=?";
        PreparedStatement pf = conn.prepareStatement(sql);
        pf.setInt(1, id);
        pf.setString(1,email);
        ResultSet rowf = pf.executeQuery();
        if(rowf.next()){
            int child_id = rowf.getInt(1);
            String sql2 = "insert into children values(?,?)";
            PreparedStatement pf2 = conn.prepareStatement(sql2);
            pf2.setInt(1,child_id);
            pf2.setInt(2,id);
            int rowp = pf2.executeUpdate();
            if(rowp == 1){
                return 1;
            }
        }
        return 0;
    }

    public String getUserName(String email){
        try {
            Connection conn = Database.getInstance().getConnection();
            String statement = "SELECT * FROM accounts where email = ?";

            PreparedStatement query = conn.prepareStatement(statement);
            query.setString(1, email);


            ResultSet r = query.executeQuery();

            String result = "";

            while ( r.next() ) {
                result = r.getString("firstname") + " " + r.getString("lastname");
            }



            return result;
        } catch (Exception e) {
            return null;
        }
    }

    public int getUserID(String email){
        try {
            Connection conn = Database.getInstance().getConnection();
            String statement = "SELECT * FROM accounts where email = ?";

            PreparedStatement query = conn.prepareStatement(statement);
            query.setString(1, email);


            ResultSet r = query.executeQuery();

            int result = 0;

            while ( r.next() ) {
                result = r.getInt("id");
            }



            return result;
        } catch (Exception e) {
            return -1;
        }
    }



    public ArrayList<String> getChildsName(){
        ArrayList<String> names2 = new ArrayList<>();
        for(Child c: childs){
            names2.add(c.getName());
        }
        return names2;
    }

}
