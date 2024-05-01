package myPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {

//    private static final String DB_NAME = "";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/3legant?useSSL=false";
    
    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            System.out.println("Conntected");
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Database Connection Error" + e.getMessage());
        }
        return connection;
    }
}
