package myPackageContact;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContactDao {
    private static final String URL = "jdbc:mysql://localhost:3306/3legant";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public void insertContact(String name, String email, String message) throws SQLException {
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = conn.prepareStatement("INSERT INTO contact (name, email, message) VALUES (?, ?, ?)")) {
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, message);
            statement.executeUpdate();
        }
    }
}
