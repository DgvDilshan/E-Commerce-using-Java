package myPackage.admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import myPackage.DbUtil;

public class UpdateCategoryServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String catIdStr = request.getParameter("catId");
        String catName = request.getParameter("cat_name");
        String catSlug = request.getParameter("cat_slug");
        int catId = Integer.parseInt(catIdStr);
        
        updateCategory(catId, catName, catSlug);
                
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
    }
    
    private void updateCategory(int catId, String catName, String catSlug){
        try(Connection conn = DbUtil.getConnection()){
            String query = "UPDATE categories SET cat_slug = ?, category = ? WHERE cat_id = ?";
            
            try(PreparedStatement stmt = conn.prepareStatement(query)){
                stmt.setString(1, catSlug);
                stmt.setString(2, catName);
                stmt.setInt(3, catId);
                stmt.executeUpdate();
            }
        }catch (SQLException e){
            e.getMessage();
        }
    }


}
