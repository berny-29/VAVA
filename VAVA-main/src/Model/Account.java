package src.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author: Spol XD, akt(Filo,Gajdos,Mark)
 * describtion: ponechavam vasej predstavivosti
*/
public class Account {
    private int id ;
    private String name, password, email;

    public static boolean accountRegistration(String firstname,String lastname,String sex,String date, String password, String email) throws SQLException {

        Connection conn = Database.getInstance().getConnection();

        String find = "SELECT * FROM accounts where email = ?";
        PreparedStatement pf = conn.prepareStatement(find);

        pf.setString(1,email);
        ResultSet rowf = pf.executeQuery();


        if(!rowf.next()){
            String insert = "INSERT INTO accounts (firstname,lastname,password,email,sex,date) VALUES(?,?,?,?,?,?)";

            PreparedStatement pi = conn.prepareStatement(insert);
            pi.setString(1,firstname);
            pi.setString(2,lastname);
            pi.setString(3,password);
            pi.setString(4,email);
            pi.setString(5,sex);
            pi.setString(6,date);

            int rowi = pi.executeUpdate();
                System.out.println(rowi);
        }else {
            return false;
        }
        return true;
    }


    public static void userLogin(String email, String password) throws SQLException {
        Connection conn = Database.getInstance().getConnection();

        String find = "SELECT * FROM accounts where email = ? and password = ?";
        PreparedStatement pf = conn.prepareStatement(find);

        pf.setString(1,email);
        pf.setString(2,password);
        ResultSet rowf = pf.executeQuery();
        if(!rowf.next()){
            System.out.println("Wrong email or password");
        }else {
            System.out.println("Welcome");
        }
    }
}
