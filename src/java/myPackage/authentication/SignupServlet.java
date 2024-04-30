package myPackage.authentication;

import java.io.IOException;
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
import myPackage.DbUtil;;

public class SignupServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String firstName = request.getParameter("fname");
        String lastName = request.getParameter("lname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phoneNumber = request.getParameter("pno");
        
        String hashedPassword = hashPassword(password);
        
        boolean userExists = checkUserExists(email);
        
        if(userExists){
            response.getWriter().write("You Already Registered, Login please");
        }else {
            createUser(firstName, lastName, email, hashedPassword, phoneNumber);
            response.getWriter().write("Successfully Registered");
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
    
    private void createUser(String firstName, String lastName, String email, String password, String phoneNumber){
        try(Connection conn = DbUtil.getConnection()){
            String query = "INSERT INTO users (user_fname, user_lname, user_email, user_password, user_pno, user_status) VALUES(?, ?, ?, ?, ?, ?)";
            
            try(PreparedStatement stmt = conn.prepareStatement(query)){
                stmt.setString(1, firstName);
                stmt.setString(2, lastName);
                stmt.setString(3, email);
                stmt.setString(4, password);
                stmt.setString(5, phoneNumber);
                stmt.setString(6, "user");
                stmt.executeUpdate();
            }
        }catch(SQLException e){
            e.getMessage();
        }
    }
    
    private String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = digest.digest(password.getBytes());
            return bytesToHex(hashedBytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
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
