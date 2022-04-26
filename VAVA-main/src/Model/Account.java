package src.Model;


import src.Controllers.ProfileController;

import java.sql.*;
import java.net.*;
import java.io.*;
import java.time.LocalDateTime;


public class Account {
    private int id ;
    private String name, password, email;

    public static void loginLogger(String email, String password,String status) throws Exception {

        Connection conn = Database.getInstance().getConnection();

        String insert = "INSERT INTO logs (email,password,ip,status,time) VALUES(?,?,?,?,?)";

        PreparedStatement pi = conn.prepareStatement(insert);
        pi.setString(1,email);
        pi.setString(2,password);
        pi.setString(3,getIp());
        pi.setString(4,status);
        pi.setTimestamp(5,java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));

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

        }else {
            return false;
        }
        return true;
    }


    public static String userLogin(String email, String password, String role) throws SQLException {
        Connection conn = Database.getInstance().getConnection();

        String find = "SELECT * FROM accounts where email = ? and password = ?";
        PreparedStatement pf = conn.prepareStatement(find);

        pf.setString(1,email);
        pf.setString(2,password);
        ResultSet rowf = pf.executeQuery();
        if(!rowf.next()){
            return "false";
        }else {
            return role;
        }
    }

    public static ResultSet getUserData(String email){
        try {
            Connection conn = Database.getInstance().getConnection();

            String find = "SELECT * FROM accounts where email = ?";
            PreparedStatement pf = conn.prepareStatement(find);

            pf.setString(1, email);
            ResultSet rowf = pf.executeQuery();
            return rowf;
        } catch(Exception e) {
            return null;
        }


    }

    public static StringBuilder getLogs() throws SQLException {
        LocalDateTime ldt = LocalDateTime.now();
        LocalDateTime yesterday = ldt.minusDays(1);
        Timestamp timestamp = Timestamp.valueOf(yesterday);


        Connection conn = Database.getInstance().getConnection();
        StringBuilder str = new StringBuilder();

        String sql = "select * from  logs where time  > cast(? as timestamp)";
        PreparedStatement pi = conn.prepareStatement(sql);
        pi.setString(1, String.valueOf(timestamp));

        ResultSet rs = pi.executeQuery();
        while (rs.next()){
            str.append(rs.getString(6));
            str.append("\n");
            str.append(rs.getString(2));
            str.append("\n");
            str.append(rs.getString(3));
            str.append("\n");
            str.append(rs.getString(4));
            str.append("\n");
            str.append(rs.getString(5));
            str.append("\n");
            str.append("\n");
        }

        return str;
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

    /**
     * getIp() from https://stackoverflow.com/questions/2939218/getting-the-external-ip-address-in-java by bakkal
     *
     */
    public static String getIp() throws Exception
    {
        URL whatismyip = new URL("http://checkip.amazonaws.com/%22");
        BufferedReader in = new BufferedReader(new InputStreamReader(whatismyip.openStream()));

        String ip = in.readLine(); //you get the IP as a String
        return ip;
    }

}
