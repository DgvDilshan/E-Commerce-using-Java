package myPackage.authentication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import myPackage.DbUtil;

public class AccountDao {
    
//    private static final String SELECT_USER_BY_ID = "select first_name,last_name, display_name,email,password,billing_phone,billing_address,shipping_phone,shipping_address, billing_name, shipping_name from user where user_id =?";
    private static final String SELECT_USER_BY_ID = "select * from users where user_id =?";
    private static final String UPDATE_USERS_SQL = "update users set user_fname=?, user_lname=?, user_display_name=?, user_email=?, user_password=?  WHERE user_id=?";
    private static final String SELECT_ALL_ORDERS = "SELECT * FROM orders WHERE user_id=?";
    private static final String SELECT_ADDRESS = "SELECT * FROM addresses WHERE user_id = ? AND address_type = ?";
    private static final String UPDATE_ADDRESS = "UPDATE addresses SET street_address = ?, city = ?, state = ?, postal_code = ?, country = ?, user_name = ?, phone_no = ? WHERE user_id = ? AND address_type = ?";
    private static final String INSERT_ADDRESS = "INSERT INTO addresses (user_id, address_type, street_address, city, state, postal_code, country, user_name, phone_no) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    
    public AccountDao() {}


//slect user by id
    public Account selectUser(int user_id) {
        Account account = null;
        try (Connection connection = DbUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setInt(1, user_id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String first_name = rs.getString("user_fname");
                String last_name = rs.getString("user_lname");
                String display_name = rs.getString("user_display_name");
                String email = rs.getString("user_email");
                String password = rs.getString("user_password");
                System.out.println("first_name: " + first_name);
                account = new Account(user_id, first_name, last_name, display_name, email, password);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return account;
    }

    public boolean updateUser(Account account) throws SQLException {
        boolean rowUpdated;
        System.out.println("hi this is Dao");
        try (Connection connection = DbUtil.getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            statement.setString(1, account.getFirst_name());
            statement.setString(2, account.getLast_name());
            statement.setString(3, account.getDisplay_name());
            statement.setString(4, account.getEmail());
            statement.setString(5, account.getPassword());
            statement.setInt(6, account.getUser_id());

            System.out.println("hi this is dao after seting values");
            rowUpdated = statement.executeUpdate() > 0;
            System.out.println("hi this is after raw update");

        }
        return rowUpdated;
    }
    
    public Address selectBillingAddress(int user_id) {
        Address address = null;
        try (Connection connection = DbUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ADDRESS);) {
            preparedStatement.setInt(1, user_id);
            preparedStatement.setString(2, "billing");
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String streetAddress = rs.getString("street_address");
                String city = rs.getString("city");
                String state = rs.getString("state");
                String postalCode = rs.getString("postal_code");
                String country = rs.getString("country");
                String user_name = rs.getString("user_name");
                String phone_no = rs.getString("phone_no");                
                address = new Address("billing", streetAddress, city,
                state, postalCode, country, user_name, phone_no);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return address;
    }
    
    public Address selectShippingAddress(int user_id) {
        Address address = null;
        try (Connection connection = DbUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ADDRESS);) {
            preparedStatement.setInt(1, user_id);
            preparedStatement.setString(2, "shipping");
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String streetAddress = rs.getString("street_address");
                String city = rs.getString("city");
                String state = rs.getString("state");
                String postalCode = rs.getString("postal_code");
                String country = rs.getString("country");
                String user_name = rs.getString("user_name");
                String phone_no = rs.getString("phone_no");                
                address = new Address("shipping", streetAddress, city,
                state, postalCode, country, user_name, phone_no);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return address;
    }
    
    public boolean updateAddress(Address address, int user_id) throws SQLException {
        boolean rowUpdated =false;
        System.out.println("hi this is Dao");
        
        try{
            Connection connection = DbUtil.getConnection(); 
            PreparedStatement selectStatement  = connection.prepareStatement(SELECT_ADDRESS);
            selectStatement.setInt(1, user_id); 
            selectStatement.setString(2, address.getAddressType()); 
            ResultSet resultSet = selectStatement.executeQuery();

             if (resultSet.next()) {
                PreparedStatement updateStatement   = connection.prepareStatement(UPDATE_ADDRESS);
                updateStatement.setString(1, address.getStreetAddress());
                updateStatement.setString(2, address.getCity());
                updateStatement.setString(3, address.getState());
                updateStatement.setString(4, address.getPostalCode());
                updateStatement.setString(5, address.getCountry());
                updateStatement.setString(6, address.getUser_name());
                updateStatement.setString(7, address.getPhone_no());
                updateStatement.setInt(8, user_id); 
                updateStatement.setString(9, address.getAddressType());
                System.out.println("Record updated successfully.");
                rowUpdated = updateStatement.executeUpdate() > 0;

             }
             else{
                PreparedStatement insertStatement  = connection.prepareStatement(INSERT_ADDRESS);
                insertStatement.setInt(1, user_id);
                insertStatement.setString(2, address.getAddressType()); 
                insertStatement.setString(3, address.getStreetAddress());
                insertStatement.setString(4, address.getCity());
                insertStatement.setString(5, address.getState());
                insertStatement.setString(6, address.getPostalCode());
                insertStatement.setString(7, address.getCountry());
                insertStatement.setString(8, address.getUser_name());
                insertStatement.setString(9, address.getPhone_no());
                System.out.println("Record inserted successfully.");
                rowUpdated = insertStatement.executeUpdate() > 0;
             }
        }catch (SQLException e){
            e.printStackTrace();
        }
        
        return rowUpdated;
    }
   
//    public boolean updateShippingAddress(Account account) throws SQLException {
//        boolean rowUpdated;
//        System.out.println("hi this is Dao");
//
//        try (Connection connection = DbUtil.getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_SHIPPING_ADDRESS);) {
//            statement.setString(1, account.getShipping_name());
//            statement.setString(2, account.getShipping_phone());
//            statement.setString(3, account.getShipping_address());
//            statement.setInt(4, account.getUser_id());
//
//            System.out.println("hi this is dao after seting values");
//            rowUpdated = statement.executeUpdate() > 0;
//            System.out.println("hi this is after raw update");
//        }
//        return rowUpdated;
//    }

    public List<Order> selectAllOrders(int user_id) {
        List<Order> myorders = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ORDERS)) {
            preparedStatement.setInt(1, user_id); // Set the user_id parameter
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int order_id = rs.getInt("order_id");
                String order_code = rs.getString("order_code");
                float total = rs.getFloat("total"); // Assuming total is a float type in the database
                String shipping_method = rs.getString("shipping_method");
                String order_date = rs.getString("ordered_date");

                // Create a new Order object and add it to the list
                Order order = new Order(order_id, order_code, total, shipping_method, order_date);
                myorders.add(order);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return myorders;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    boolean checkPassword(int id, String old_password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
