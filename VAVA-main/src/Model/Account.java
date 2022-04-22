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

    public static void loginLogger(String email, String password,String status) throws SQLException{

        Connection conn = Database.getInstance().getConnection();

        String insert = "INSERT INTO logs (email,password,status,time) VALUES(?,?,?,?)";

        PreparedStatement pi = conn.prepareStatement(insert);
        pi.setString(1,email);
        pi.setString(2,password);
        pi.setString(3,status);
        pi.setTimestamp(4,java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));

        pi.executeUpdate();

    }

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


    public static boolean userLogin(String email, String password) throws SQLException {
        Connection conn = Database.getInstance().getConnection();

        String find = "SELECT * FROM accounts where email = ? and password = ?";
        PreparedStatement pf = conn.prepareStatement(find);

        pf.setString(1,email);
        pf.setString(2,password);
        ResultSet rowf = pf.executeQuery();
        if(!rowf.next()){
            return false;
        }else {
            return true;
        }
    }

    public static int changePassword(String email, String password, String newPassword) throws SQLException {

        Connection conn = Database.getInstance().getConnection();

        String sql = "Select * from Accounts where email=?";
        PreparedStatement pf = conn.prepareStatement(sql);
        if(!password.equals(newPassword)){
            return 2;
        }
        pf.setString(1,email);
        ResultSet rowf = pf.executeQuery();
        if(rowf.next()){
            String changePassword = "Update Accounts set password = ? where email = ?";
            PreparedStatement psp = conn.prepareStatement(changePassword);
            psp.setString(1,password);
            psp.setString(2,email);
            int rowp = psp.executeUpdate();
            if(rowp == 1){
                return 1;
            }
        }
        return 0;
    }
}
