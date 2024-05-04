package myPackage.admin;

public class Order {
    int orderId;
    String orderCode;
    String userName;
    double total;
    String status;
    String date;
    
    public Order(int orderId, String orderCode, String userName, double total, String status, String date){
        this.orderId = orderId;
        this.orderCode = orderCode;
        this.userName = userName;
        this.total = total;
        this.status = status;
        this.date = date;
    }
    
    public int getOrderId(){
        return orderId;
    }
    
    public void setOrderId(int orderId){
        this.orderId = orderId;
    }
    
    public String getOrderCode(){
        return orderCode;
    }
    
    public void setOrderCode(String orderCode){
        this.orderCode = orderCode;
    }
    
    public String getUserName(){
        return userName;
    }
    
    public void setUserName(String userName){
        this.userName = userName;
    }
    
    public double getTotal(){
        return total;
    }
    
    public void setTotal(double total){
        this.total = total;
    }
    
    public String getStatus(){
        return status;
    }
    
    public void setStatus(String status){
        this.status = status;
    }
    
    public String getDate(){
        return date;
    }
    
    public void setDate(String date){
        this.date = date;
    }
}

