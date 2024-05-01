package myPackage.cart;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import myPackage.DbUtil;

@WebServlet(name = "CartDetailsServlets", urlPatterns = {"/CartDetailsServlets"})
public class CartDetailsServlets extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String total = request.getParameter("total_price");

        float totalFloat = Float.parseFloat(total);
        
        if(Float.isNaN(totalFloat)){
            totalFloat = (float) 0.11;
        }
        
        String cartItemsJson = request.getParameter("cart_items");
        String shippingMethod = request.getParameter("shipping_method");
        int userId = getUserIdFromSession();
        
        try (Connection conn = DbUtil.getConnection()) {
            conn.setAutoCommit(false);

            conn.setAutoCommit(false); 

            
            int orderId = insertOrder(conn, userId, totalFloat, shippingMethod);
            
            if (orderId != -1) {
                insertOrderItems(conn, orderId, cartItemsJson);               
                conn.commit();

                insertOrderItems(conn, orderId, cartItemsJson);
                
                conn.commit(); 


                response.setContentType("text/plain");
                PrintWriter out = response.getWriter();
                out.print("Success: Order placed successfully!");
            } else {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to insert order.");
            }
        }catch(SQLException e){
            e.getMessage();
        }
    }
    
    private int insertOrder(Connection conn, int userId, float totalFloat, String shippingMethod) throws SQLException {
        String query = "INSERT INTO orders (order_code, user_id, total, shipping_method, status, payment_method, ordered_date) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            String code = generateUniqueOrderCode(conn);
            statement.setString(1, code);
            statement.setInt(2, userId);
            statement.setFloat(3, totalFloat);
            statement.setString(4, shippingMethod);
            statement.setString(5, "pending");
            statement.setString(6, "null");
            statement.setTimestamp(7, new java.sql.Timestamp(System.currentTimeMillis()));
            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                return -1;
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    return -1;
                }
            }
        }
    }

    private void insertOrderItems(Connection conn, int orderId, String cartItemsJson) throws SQLException {
        Gson gson = new Gson();
        CartItem[] cartItems = gson.fromJson(cartItemsJson, CartItem[].class);

        String query = "INSERT INTO order_items (order_id, pro_id, quantity) VALUES (?, ?, ?)";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            for (CartItem item : cartItems) {
                statement.setInt(1, orderId);
                statement.setInt(2, item.getProductId());
                statement.setInt(3, item.getQuantity());
                statement.addBatch();
            }
            statement.executeBatch();
        }
    }
    
    private String generateUniqueOrderCode(Connection conn) throws SQLException {
        String orderCode;
        do {
          int random3Digit = (int) (Math.random() * 900) + 100;
          int random8Digit = (int) (Math.random() * 100000000);

          orderCode = "#" + random3Digit + "_" + random8Digit;

          
        } while (orderCodeAlreadyExists(conn, orderCode)); 

         return orderCode;
    }
    
    private boolean orderCodeAlreadyExists(Connection conn, String orderCode)throws SQLException {
          String checkQuery = "SELECT * FROM orders WHERE order_code = ?";
          try (PreparedStatement checkStatement = conn.prepareStatement(checkQuery)) {
            checkStatement.setString(1, orderCode);
            try(ResultSet result = checkStatement.executeQuery()){
                if(result.next()){
                    int count = result.getInt(1);
                    if(count > 0){
                        return true;
                    }
                }
            }
          }
          
          return false;
    }
    
    private int getUserIdFromSession() {
        return 2;
    }
    
}


