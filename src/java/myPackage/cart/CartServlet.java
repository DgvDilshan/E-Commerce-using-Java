package myPackage.cart;

import com.google.gson.Gson;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import myPackage.DbUtil;

public class CartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ArrayList<CartItem> cartItems = getCartItemsFromDb();
        String json = new Gson().toJson(cartItems);
        
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        response.getWriter().write(json);
    }
    
    private ArrayList<CartItem> getCartItemsFromDb() {
        ArrayList<CartItem> cartItems = new ArrayList<>();
        int userId = 2;
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM cart WHERE user_id = ?")) {
            stmt.setInt(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                    int cartId = rs.getInt("cart_id");
                    int productId = rs.getInt("pro_id");
                    int quantity = rs.getInt("quantity");
                    double sub_total = rs.getDouble("sub_total");
                    try (PreparedStatement stmtPro = conn.prepareStatement("SELECT * FROM products WHERE pro_id = ?")) {
                        stmtPro.setInt(1, productId);
                        try (ResultSet result = stmtPro.executeQuery()) {
                            while (result.next()) {
                                String productName = result.getString("pro_name");
                                String productImage = result.getString("pro_img");
                                double price = result.getDouble("pro_price");

                                cartItems.add(new CartItem(cartId, productId, productName, productImage, quantity, price, sub_total));
                            }
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cartItems;
    }


}
