package myPackage.cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import myPackage.DbUtil;


@WebServlet(name = "RemoveCartItemServlet", urlPatterns = {"/RemoveCartItemServlet"})
public class RemoveCartItemServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int cartId = Integer.parseInt(request.getParameter("cart_id"));
        removeItemFromCart(cartId);
        response.getWriter().write("Item removed successfully");
    }
    
    private void removeItemFromCart(int cartId){
        try (Connection conn = DbUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM cart WHERE cart_id = ?")) {
            stmt.setInt(1, cartId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.getMessage();
        }
    }


}
