package myPackage.cart;

public class OrderItem {
    private int orderId;
    private String orderCode;
    private double total;
    private String shippingMethod;
    private String status;
    private String paymentMethod;
    private String orderedDate;
    private int proId;
    private int quantity;
    private String productName;
    private String productImg;
    private double productPrice;
    
    public OrderItem(int orderId, String orderCode, double total, String shippingMethod, String status, String paymentMethod, String orderedDate, int proId, int quantity, String productName, String productImg, double productPrice){
        this.orderId = orderId;
        this.orderCode = orderCode;
        this.total = total;
        this.shippingMethod = shippingMethod;
        this.status = status;
        this.paymentMethod = paymentMethod;
        this.orderedDate = orderedDate;
        this.proId = proId;
        this.quantity = quantity;
        this.productName = productName;
        this.productImg = productImg;
        this.productPrice = productPrice;
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
    
    public double getTotal(){
        return total;
    }
    
    public void setTotal(double total){
        this.total = total;
    }
    
    public String getShippingMethod(){
        return shippingMethod;
    }
    
    public void setShippingMethod(String shippingMethod){
        this.shippingMethod = shippingMethod;
    }
    
    public String getStatus(){
        return status;
    }
    
    public void setStatus(String status){
        this.status = status;
    }
    
    public String getPaymentMethod(){
        return paymentMethod;
    }
    
    public void setPaymentMethod(String paymentMethod){
        this.paymentMethod = paymentMethod;
    }
    
    public String getOrderedDate(){
        return orderedDate;
    }
    
    public void setOrderedDate(String orderedDate){
        this.orderedDate = orderedDate;
    }
    
    public int getProId(){
        return proId;
    }
    
    public void setProId(int proId){
        this.proId = proId;
    }
    
    public int getQuantity(){
        return quantity;
    }
    
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    
    public String getProductName(){
        return productName;
    }
    
    public void setProductName(String productName){
        this.productName = productName;
    }
    
    public String getProductImg(){
        return productImg;
    }
    
    public void setProductImg(String productImg){
        this.productImg = productImg;
    }
    
    public double getProductPrice(){
        return productPrice;
    }
    
    public void setProductPrice(double productPrice){
        this.productPrice = productPrice;
    }
}
