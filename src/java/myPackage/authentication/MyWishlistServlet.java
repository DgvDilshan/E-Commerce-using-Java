package myPackage.authentication;

import myPackage.authentication.WishlistItem;
import com.google.gson.Gson;

import myPackage.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MyWishlistServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int userId = getUserIdFromSession(request);

        if (userId == -1) {
            response.getWriter().write("User Not Authenticated");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        ArrayList<WishlistItem> wishlistItems = getWishlistItemsFromDb(userId);
        String json = new Gson().toJson(wishlistItems);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        response.getWriter().write(json);
    }

    private ArrayList<WishlistItem> getWishlistItemsFromDb(int userId) {
        ArrayList<WishlistItem> wishlistItems = new ArrayList<>();
        String query = "SELECT wishlist_id, pro_id, pro_name, pro_img, price FROM wishlist WHERE user_id = ?";
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int wishlist_id = rs.getInt("wishlist_id");
                    int pro_id = rs.getInt("pro_id");
                    String product_name = rs.getString("pro_name");
                    String pro_img = rs.getString("pro_img");
                    double price = rs.getDouble("price");
                    wishlistItems.add(new WishlistItem(wishlist_id, pro_id, product_name, pro_img, price));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return wishlistItems;
    }

    private int getUserIdFromSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            Object userIdObj = session.getAttribute("userId");
            if (userIdObj instanceof Integer) {
                return (Integer) userIdObj;
            }
        }
        return -1;
    }
}
