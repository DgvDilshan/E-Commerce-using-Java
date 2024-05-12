package myPackage.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import myPackage.DbUtil;

public class AddCategoryServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String catName = request.getParameter("cat_name").toLowerCase();
        String catSlug = request.getParameter("cat_slug");
        
        int catExists = checkCategoryExists(catName);
        
        if(catExists > 0){
            response.getWriter().write("Category already added");
        }else {
            insertCategory(catName, catSlug);
            response.getWriter().write("Category added successfully");
        }
        
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
    }
    
    private int checkCategoryExists(String catName){
        try(Connection conn = DbUtil.getConnection()){
            String query = "SELECT COUNT(*) FROM categories WHERE category = ?";
            
            try(PreparedStatement statement = conn.prepareStatement(query)){
                statement.setString(1, catName);
                
                try(ResultSet result = statement.executeQuery()){
                    if(result.next()){
                        int count = result.getInt(1);
                        return count;
                    }
                }
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        
        return -1;
    }
    
    private void insertCategory(String catName, String catSlug){
        try(Connection conn = DbUtil.getConnection()){
            String query = "INSERT INTO categories (cat_slug, category) VALUES (?, ?)";
            
            try(PreparedStatement statement = conn.prepareStatement(query)){
                statement.setString(1, catSlug);
                statement.setString(2, catName);
                
                statement.executeUpdate();
            }
        }catch(SQLException e){
            e.getMessage();
        }
    }


}
