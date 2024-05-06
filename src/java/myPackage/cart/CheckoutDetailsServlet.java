package myPackage.cart;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import myPackage.DbUtil;

public class CheckoutDetailsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phoneNo = request.getParameter("phoneNo");
        String street = request.getParameter("street");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String postalCode = request.getParameter("postalCode");
        String country = request.getParameter("country");
        String orderIdStr = request.getParameter("orderId");
        String paymentMethod = request.getParameter("paymentMethod");
        
        int orderId = parseInt(orderIdStr);
        int userId = 2;
        
        try (Connection conn = DbUtil.getConnection()) {
            updateUser(conn, firstName, lastName, email, phoneNo, userId);
            updateAddress(conn, street, city, state, postalCode, country, userId);
            updateOrder(conn, paymentMethod, orderId);
            deleteCartItems(conn, userId);
            
            response.setContentType("text/plain");
            PrintWriter out = response.getWriter();
            out.print("Success: Order placed successfully!");
        }catch (SQLException e){
            e.getMessage();
        }
    }
    
    private void updateUser(Connection conn, String firstName, String lastName, String email, String phoneNo, int userId) throws SQLException {
        String query = "UPDATE users SET first_name = ?, last_name = ?, user_email = ?, user_phoneno = ? WHERE user_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setString(3, email);
            stmt.setString(4, phoneNo);
            stmt.setInt(5, userId);

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("User information updated successfully.");
            } else {
                System.out.println("No user found with ID: " + userId);
            }
        }
    }
    
    private void updateAddress(Connection conn, String street, String city, String state, String postalCode, String country, int userId) throws SQLException {
        String query = "UPDATE addresses SET street_address = ?, city = ?, state = ?, postal_code = ?, country = ? WHERE user_id = ?";
        try(PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setString(1, street);
            stmt.setString(2, city);
            stmt.setString(3, state);
            stmt.setString(4, postalCode);
            stmt.setString(5, country);
            stmt.setInt(6, userId);
            
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("User information updated successfully.");
            } else {
                System.out.println("No user found with ID: " + userId);
            }
        }
    }
    
    private void updateOrder(Connection conn, String paymentMethod, int orderId) throws SQLException {
        String query = "UPDATE orders SET payment_method = ? WHERE order_id = ?";
        try(PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setString(1, paymentMethod);
            stmt.setInt(2, orderId);
            
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("User information updated successfully.");
            } else {
                System.out.println("No user found with ID: " + orderId);
            }
        }
    }
    
    private void deleteCartItems(Connection conn, int userId) throws SQLException {
        String query = "DELETE FROM cart WHERE user_id = ?";      
        try(PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setInt(1, userId);
            stmt.executeUpdate();
        }
    }
    
    

}
