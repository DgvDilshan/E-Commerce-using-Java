package myPackage.authentication;

import myPackage.DbUtil; // Correct import statement for DbUtil

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RemoveFromWishlistServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int wishlistId = Integer.parseInt(request.getParameter("wishlist_id"));
        int userId = getUserIdFromSession(request);

        if (userId == -1) {
            response.getWriter().write("User Not Authenticated");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        try {
            removeFromWishlist(userId, wishlistId, response);
        } catch (SQLException ex) {
            // Log the exception or handle it appropriately
            response.getWriter().write("Error: " + ex.getMessage());
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    private int getUserIdFromSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            Object userIdObj = session.getAttribute("user_id");
            if (userIdObj instanceof Integer) {
                return (Integer) userIdObj;
            }
        }
        return -1;
    }

    private void removeFromWishlist(int userId, int wishlistId, HttpServletResponse response) throws IOException, SQLException {
        try (Connection conn = DbUtil.getConnection()) {
            String query = "DELETE FROM wishlist WHERE wishlist_id = ? AND user_id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setInt(1, wishlistId);
                stmt.setInt(2, userId);
                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected > 0) {
                    response.getWriter().write("Product removed from wishlist successfully");
                } else {
                    response.getWriter().write("Product not found in wishlist");
                }
            }
        }
    }
}
