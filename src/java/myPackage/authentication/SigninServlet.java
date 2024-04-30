package myPackage.authentication;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import myPackage.DbUtil;

public class SigninServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        System.out.println("amu pwd");
        System.out.println(password);

        
        boolean userExists = checkUserExists(email);
        
        if(userExists){
            try {
                String storedHashedPassword = getStoredHashedPassword(email);
                 System.out.println("storedHashedPassword");
                 System.out.println(storedHashedPassword);
               
                if (verifyPassword(password, storedHashedPassword)) {
                    int userId = getUserId(email);
                    String status = getStatus(email);
                    
                    HttpSession session = request.getSession();
                    
                    if (session != null) {
                        session.setAttribute("userId", userId);
                    
                        if(status.equals("admin")){
                            response.getWriter().write("Authentication successful as admin!");
                        }else {
                            response.getWriter().write("Authentication successful");
                        }
                    } else {
                      response.getWriter().write("An error occurred. Please try again.");
                    }
                   

                } else {
                    response.getWriter().write("Incorrect password!");
                }
                
            }catch (SQLException e){
                e.getMessage();
            }
        }else {
            response.getWriter().write("You Don't have an account, please register");
        }
    }
    
    private boolean checkUserExists(String email){
        try(Connection conn = DbUtil.getConnection()){
            String query = "SELECT COUNT(*) FROM users WHERE user_email = ?";
            try(PreparedStatement stmt = conn.prepareStatement(query)){
                stmt.setString(1, email);
                
                try(ResultSet rs = stmt.executeQuery()){
                    if(rs.next()){
                        int count = rs.getInt(1);
                        if(count > 0){
                            return true;
                        }
                    }
                }
            }
        }catch(SQLException e){
            e.getMessage();
        }
        return false;
    }
    
    private String getStoredHashedPassword(String email) throws SQLException {
        try (Connection conn = DbUtil.getConnection()) {
            String query = "SELECT user_password FROM users WHERE user_email = ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, email);

                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        return rs.getString("user_password");
                    }
                }
            }
        }
        return null;
    }
    
    private String getStatus(String email) throws SQLException {
        try (Connection conn = DbUtil.getConnection()){
            String query = "SELECT user_status FROM users WHERE user_email = ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, email);

                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        return rs.getString("user_status");
                    }
                }
            }
        }
        return null;
    }
    
    private int getUserId(String email) throws SQLException {
        try (Connection conn = DbUtil.getConnection()){
            String query = "SELECT user_id FROM users WHERE user_email = ?";
            try(PreparedStatement stmt = conn.prepareStatement(query)){
                stmt.setString(1, email);
                
                try(ResultSet rs = stmt.executeQuery()){
                    if(rs.next()){
                        return rs.getInt("user_id");
                    }
                }
            }
        }
        return -1;
    }
    
    
    private boolean verifyPassword(String password, String storedHashedPassword) {
        String hashedInputPassword = hashPassword(password);
         System.out.println("ape hashed pwd");
         System.out.println(hashedInputPassword);
      
        return hashedInputPassword.equals(storedHashedPassword);
    }
    
    private String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = digest.digest(password.getBytes());
            return bytesToHex(hashedBytes);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
        }
        return result.toString();
    }


}
