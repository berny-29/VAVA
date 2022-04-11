import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class Database {
    //TODO k tomuto budeme potrebovat singleton inicializaciu a nejaky subor obsahujuci vsetky udaje potrebne pre pripojenie
    private static Connection con = null;

    static
    {
        String url = "jdbc:postgresql:// localhost:5432/Vava";
        String user = "root";
        String pass = "root";
        try {
            Class.forName("com.postgresql.jdbc.Driver");
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

}
