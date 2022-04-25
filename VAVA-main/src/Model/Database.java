package src.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class Database {
    //TODO k tomuto budeme potrebovat singleton inicializaciu a nejaky subor obsahujuci vsetky udaje potrebne pre pripojenie
    private static Database instance = null;
    private static Connection con = null;

    static
    {
        String url = "jdbc:postgresql://localhost:5432/Vava";
        String user = "postgres";

        String pass = System.getenv("PASS");
        //String pass = "uuclespo2";

        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, user, pass);
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection()
    {
        return con;
    }
    public static Database getInstance(){
        if(instance == null){
            instance = new Database();
        }
        return instance;
    }
}
