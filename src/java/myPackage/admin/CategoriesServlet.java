package myPackage.admin;

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

public class CategoriesServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ArrayList<Category> categories = getCategoriesFromDb();
        String json = new Gson().toJson(categories);
        
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        response.getWriter().write(json);
    }
    
    private ArrayList<Category> getCategoriesFromDb() {
        ArrayList<Category> categories = new ArrayList<>();
        
        try(Connection conn = DbUtil.getConnection()){
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM categories");
            try (ResultSet rs = statement.executeQuery()){
                while (rs.next()) {
                    int catId = rs.getInt("cat_id");
                    String catSlug = rs.getString("cat_slug");
                    String catName = rs.getString("category");
                    
                    categories.add(new Category(catId, catName, catSlug));
                }
            }
        }catch(SQLException e){
            e.getMessage();
        }
        
        return categories;
    }


}
