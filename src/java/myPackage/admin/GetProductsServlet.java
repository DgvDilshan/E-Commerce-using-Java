package myPackage.admin;

import com.google.gson.Gson;
import java.io.IOException;
import static java.lang.Integer.parseInt;
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

public class GetProductsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int proId = parseInt(request.getParameter("proId"));
        
        ArrayList<ProductItem> product = getProductFromDb(proId);
        String json = new Gson().toJson(product);
        
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        response.getWriter().write(json);
    }
    
    private ArrayList<ProductItem> getProductFromDb(int proId){
        ArrayList<ProductItem> product = new ArrayList<>();
        
        try(Connection conn = DbUtil.getConnection()){
            String query = "SELECT p.*, c.category FROM products p JOIN categories c ON p.cat_id = c.cat_id WHERE p.pro_id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, proId);
            
            try(ResultSet rs = stmt.executeQuery()){
                while(rs.next()){
                    int catId = rs.getInt("cat_id");
                    String catName = rs.getString("category");
                    String proName = rs.getString("pro_name");
                    double proPrice = rs.getDouble("pro_price");
                    String proImg = rs.getString("pro_img");
                    String proDesc = rs.getString("pro_desc");
                    double reviews = rs.getDouble("reviews");
                    String date = rs.getString("date");
                    product.add(new ProductItem(proId, catId, catName, proName, proPrice, proImg, proDesc, reviews, date));
                }
            }
        }catch (SQLException e){
            e.getMessage();
        }
        
        return product;
    }


}
