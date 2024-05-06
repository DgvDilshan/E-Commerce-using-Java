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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import myPackage.DbUtil;

@WebServlet(name = "OrderServlet", urlPatterns = {"/OrderServlet"})
public class OrderServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ArrayList<Order> orders = getOrdersFromDb();
        String json = new Gson().toJson(orders);
        
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        response.getWriter().write(json);
    }
    
    private ArrayList<Order> getOrdersFromDb(){
        ArrayList<Order> orders = new ArrayList<>();
        
        try(Connection conn = DbUtil.getConnection()){
            String query = "SELECT o.*, u.first_name, u.last_name FROM orders o JOIN users u ON o.user_id = u.user_id";
            PreparedStatement stmt = conn.prepareStatement(query);
            
            try(ResultSet rs = stmt.executeQuery()){
                while(rs.next()){
                    int orderId = rs.getInt("order_id");
                    String orderCode = rs.getString("order_code");
                    String firstName = rs.getString("first_name");
                    String lastName = rs.getString("last_name");
                    double total = rs.getDouble("total");
                    String status = rs.getString("status");
                    String orderDate = rs.getString("ordered_date");
                    
                    String userName = firstName + " " + lastName;
                    orders.add(new Order(orderId, orderCode, userName, total, status, orderDate));
                }
            }
        }catch(SQLException e){
            e.getMessage();
        }
        return orders;
    }


}
