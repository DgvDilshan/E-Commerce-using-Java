package myPackage.shop;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import myPackage.DbUtil;


@WebServlet(name = "ShopServlet", urlPatterns = {"/ShopServlet"})
public class ShopServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ArrayList<Shop> shops = getShopsFromDb();
        String json = new Gson().toJson(shops);
        
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        response.getWriter().write(json);
    }

    private ArrayList<Shop> getShopsFromDb() {
        ArrayList<Shop> shops = new ArrayList<>();
        
        try(Connection conn = DbUtil.getConnection()){
           PreparedStatement statement = conn.prepareStatement("SELECT * FROM products");
           try(ResultSet rs = statement.executeQuery()){
               while(rs.next()){
                   int proId = rs.getInt("pro_id");
                   String proName = rs.getString("pro_name");
                   String discountPrice = rs.getString("discount_price");
                   String proPrice = rs.getString("pro_price");
                   String proImg = rs.getString("pro_img");
                   
                   Shop shop = new Shop(proId, proName, discountPrice, proPrice, proImg);
                   shops.add(shop);
               }
           }
        } catch (SQLException e) {
            e.getMessage();
        }
        
        return shops;
    }
}
