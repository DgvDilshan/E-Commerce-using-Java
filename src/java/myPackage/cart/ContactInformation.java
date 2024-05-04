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

public class ContactInformation extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ArrayList<ContactItem> contactItem = getContactInfoFromDb();
        String json = new Gson().toJson(contactItem);
        
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");       
        response.getWriter().write(json);
    }
    
    private ArrayList<ContactItem> getContactInfoFromDb(){
        ArrayList<ContactItem> contactItem = new ArrayList<>();
        int userId = 1;
        
        try (Connection conn = DbUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE user_id = ?")){
                stmt.setInt(1, userId);
                try(ResultSet result = stmt.executeQuery()){
                    while(result.next()){
                        String firstName = result.getString("first_name");
                        String lastName = result.getString("last_name");
                        String email = result.getString("user_email");
                        String phoneNo = result.getString("user_phoneno");
                        
                        contactItem.add(new ContactItem(firstName, lastName, email, phoneNo));
                    }
                }
        }catch (SQLException e) {
           e.getMessage();
        }
        return contactItem;
    }
}
