package myPackage.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import myPackage.DbUtil;

public class RemoveProductsServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int proId = Integer.parseInt(request.getParameter("proId"));
        removeItemFromProducts(proId);
        response.getWriter().write("Item removed successfully");
    }
    
    private void removeItemFromProducts(int proId){
        try (Connection conn = DbUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM products WHERE pro_id = ?")) {
            stmt.setInt(1, proId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.getMessage();
        }
    }


}
