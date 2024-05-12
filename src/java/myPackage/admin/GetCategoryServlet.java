package myPackage.admin;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
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

public class GetCategoryServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String catIdStr = request.getParameter("catId");
        int catId = Integer.parseInt(catIdStr);
        
        ArrayList<Category> categoryItem = getCategoryFromDb(catId);
        String json = new Gson().toJson(categoryItem);
        
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        response.getWriter().write(json);
    }
    
    private ArrayList<Category> getCategoryFromDb(int catId){
        ArrayList<Category> categoryItem = new ArrayList<>();
        
        try(Connection conn = DbUtil.getConnection()){
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM categories WHERE cat_id = ?");
            statement.setInt(1, catId);
            try (ResultSet rs = statement.executeQuery()){
                while (rs.next()) {
                    String catSlug = rs.getString("cat_slug");
                    String catName = rs.getString("category");
                    
                    categoryItem.add(new Category(catId, catName, catSlug));
                }
            }
        }catch(SQLException e){
            e.getMessage();
        }
        
        return categoryItem;
    }


}
