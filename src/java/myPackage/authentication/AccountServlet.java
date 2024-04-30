package myPackage.authentication;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/myaccount")
public class AccountServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static int currentUserId=5;
    private AccountDao accountDao;

    public AccountServlet() {
        this.accountDao = new AccountDao();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    HttpSession session = request.getSession(false); // Pass false to avoid creating a new session if one doesn't exist
    if(session != null){
        Integer userId = (Integer) session.getAttribute("userId"); // Use Integer to handle possible null value
        if(userId != null) {
            currentUserId = userId;
        } else {
            currentUserId=5;
            // Handle case where "userId" attribute is not found in session
        }
    } else {
         currentUserId=5;
        // Handle case where session is not available
    }
    String requestType = request.getParameter("requestType");
    try {
        switch (requestType) {
            case "update":
                updateUser(request, response);
                break;
            case "up_billing_addr":
                updateBillingAddr(request, response);
                break;
            case "up_shipping_addr":
               updateShippingAddr(request, response);
                break;       
        }
    } catch (SQLException ex) {
        Logger.getLogger(AccountServlet.class.getName()).log(Level.SEVERE, null, ex);
    }
        System.out.println("In Do Post");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    HttpSession session = request.getSession(false); // Pass false to avoid creating a new session if one doesn't exist
    if(session != null){
        Integer userId = (Integer) session.getAttribute("userId"); // Use Integer to handle possible null value
        if(userId != null) {
            currentUserId = userId;
        } else {
            currentUserId=1;
            // Handle case where "userId" attribute is not found in session
        }
    } else {
         currentUserId=1;
        // Handle case where session is not available
    }
        String action = request.getParameter("action");
        System.out.println(action);
        try {
            if(action!=null){
                if(action.equals("details")){
                    getDetails(request, response);
                }
                else if(action.equals("address")){
                    getAddress(request, response);           
                }                 
                
                else if(action.equals("my_orders")){
                    listOrder(request, response);           
                }                 
            }          
        } catch (SQLException ex) {
            Logger.getLogger(AccountServlet.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }

    private void getDetails(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
         Account user = accountDao.selectUser(currentUserId);
        request.setAttribute("user", user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("includes/AccountProfile/accountProfileForm.jsp");
        dispatcher.forward(request, response);
    }
    
    private void getAddress(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
//        Account user = accountDao.selectUser(currentUserId);
//        request.setAttribute("user", user);
        
        Address billing_address = accountDao.selectBillingAddress(currentUserId);
        Address shipping_address = accountDao.selectShippingAddress(currentUserId);

        request.setAttribute("billing_address", billing_address);
        request.setAttribute("shipping_address", shipping_address);
        
        request.setAttribute("currentUserId", currentUserId);

        RequestDispatcher dispatcher = request.getRequestDispatcher("includes/AccountProfile/accountAddressForm.jsp");
        dispatcher.forward(request, response);
    }
    private void listOrder(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
    List<Order> orders = accountDao.selectAllOrders(currentUserId);
    request.setAttribute("orders", orders); // Changed attribute name to "orders"
    RequestDispatcher dispatcher = request.getRequestDispatcher("includes/AccountProfile/accountOrderList.jsp");
    dispatcher.forward(request, response);
}


    private void updateUser(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        int user_id = Integer.parseInt(request.getParameter("user_id"));
        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String display_name = request.getParameter("display_name");
        String email = request.getParameter("email");
        String new_password = request.getParameter("new_password");
        String confirmPassword = request.getParameter("confirm_password");
        String real_password = request.getParameter("real_password");
        String old_password = request.getParameter("old_password");
        
        String hashed_old_password = hashPassword(old_password);
        String hashed_new_password = hashPassword(new_password);
        
        System.out.println("ABC");
        System.out.println(hashed_old_password);     
        System.out.println("ABC");
        System.out.println("XYZ");
        System.out.println(real_password);     
        System.out.println("XYZ");


        if (!real_password.equals(hashed_old_password)) {
           request.setAttribute("error", "Old password is incorrect!");
           RequestDispatcher dispatcher = request.getRequestDispatcher("includes/AccountProfile/accountProfileForm.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(AccountServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            return; 
        }
        if (!new_password.equals(confirmPassword)) {
            request.setAttribute("error", "Passwords do not match!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("includes/AccountProfile/accountProfileForm.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(AccountServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            return;
        }
        System.out.println("hi this is servlet");
        Account account = new Account(user_id,first_name, last_name, display_name, email,hashed_new_password);
        accountDao.updateUser(account);
        response.sendRedirect("myaccount?action=details"); 
    }
    
    private void updateBillingAddr(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        int user_id = Integer.parseInt(request.getParameter("user_id"));
        System.out.println(user_id); 
        String address_type = "billing";
        String billing_street = request.getParameter("billing_street");
        String billing_city = request.getParameter("billing_city");
        String billing_state = request.getParameter("billing_state");
        String billing_postal_code = request.getParameter("billing_postal_code");
        String billing_country = request.getParameter("billing_country");
        String billing_name = request.getParameter("billing_name");
        String billing_phone = request.getParameter("billing_phone");

//        Account account = new Account(user_id,billing_name,billing_phone, billing_address,true);
        Address adress = new Address(address_type, billing_street, billing_city,
                billing_state, billing_postal_code, billing_country, billing_name, billing_phone);
        System.out.println("this is servlet and after making object");
        accountDao.updateAddress(adress, user_id);
        response.sendRedirect("myaccount?action=address");
    }
    
    private void updateShippingAddr(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        int user_id = Integer.parseInt(request.getParameter("user_id"));
        System.out.println(user_id); 
        String address_type = "shipping";
        String shipping_street = request.getParameter("shipping_street");
        String shipping_city = request.getParameter("shipping_city");
        String shipping_state = request.getParameter("shipping_state");
        String shipping_postal_code = request.getParameter("shipping_postal_code");
        String shipping_country = request.getParameter("shipping_country");
        String shipping_name = request.getParameter("shipping_name");
        String shipping_phone = request.getParameter("shipping_phone");

//        Account account = new Account(user_id,shipping_name,shipping_phone, shipping_address,true);
        Address adress = new Address(address_type, shipping_street, shipping_city,
                shipping_state, shipping_postal_code, shipping_country, shipping_name, shipping_phone);
        System.out.println("this is servlet and after making object");
        accountDao.updateAddress(adress, user_id);
        response.sendRedirect("myaccount?action=address");
    }
//    private void updateShippingAddr(HttpServletRequest request, HttpServletResponse response)
//    throws SQLException, IOException {
//        int user_id = Integer.parseInt(request.getParameter("user_id"));
//        System.out.println(user_id); 
//        String address_type = "shipping";
//        String shipping_name = request.getParameter("shipping_name");
//        String shipping_phone = request.getParameter("shipping_phone");
//        String shipping_address = request.getParameter("shipping_address");
//        Account account = new Account(user_id,shipping_name,shipping_phone, shipping_address,false);
//        System.out.println("this is servlet and after making object");
//        accountDao.updateShippingAddress(account);
//        response.sendRedirect("myaccount?action=address");
//    }
//    
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