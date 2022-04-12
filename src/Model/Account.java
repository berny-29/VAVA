package src;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: Spol XD, akt(Filo,Gajdos,Mark)
 * describtion: ponechavam vasej predstavivosti
*/
public class Account {
    private int id ;
    private String name, password, email;

    public static void accountRegistration(String firstname,String lastname,String sex,String date, String password, String email) throws SQLException {
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

        Pattern pattern = Pattern.compile(regex);


        Matcher matcher = pattern.matcher(email);
        if(!matcher.matches()){
            //toto bude handlovat nejaky alert
            System.out.println("Wrong email");
        }else{
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
                //toto bude handlovat nejaky alert
                System.out.println("Email already registered");
            }

        }

    }
    public static void pouzivatelLogin(String email, String password) throws SQLException {
        Connection conn = Database.getInstance().getConnection();

        String find = "SELECT * FROM accounts where email = ? and password = ?";
        PreparedStatement pf = conn.prepareStatement(find);

        pf.setString(1,email);
        pf.setString(2,password);
        ResultSet rowf = pf.executeQuery();
        if(rowf.wasNull()){
            System.out.println("Wrong email or password");
        }else {
            System.out.println("Welcome");
        }
    }
}
