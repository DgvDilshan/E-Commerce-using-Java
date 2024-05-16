package myPackage.admin;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import myPackage.DbUtil;

public class addProduct {

    public void addProductde(String pn, String pd, InputStream pi, String pc, double pp) {
        String sql = "INSERT INTO product(pro_name, pro_desc, pro_img, pro_cat, pro_price) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DbUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, pn);
            ps.setString(2, pd);
            ps.setBlob(3, pi);
            ps.setString(4, pc);
            ps.setDouble(5, pp);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately, e.g., logging and notifying the user
        }
    }
}