package myPackage.cart;

public class CartItem {
    private int cartId;
    private int productId;
    private String productName;
    private String productImage;
    private int quantity;
    private double price;
    private double subTotal;

    public CartItem(int cartId, int productId, String productName, String productImage, int quantity, double price, double subTotal) {
        this.cartId = cartId;
        this.productId = productId;
        this.productName = productName;
        this.productImage = productImage;
        this.quantity = quantity;
        this.price = price;
        this.subTotal = subTotal;
    }

    // Getters and setters
    public int getCartId(){
        return cartId;
    }
    
    public void setCartId(int cartId){
        this.cartId = cartId;
    }
    
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
    
    public String getProductName(){
        return productName;
    }
    
    public void setProductName(String productName){
        this.productName = productName;
    }
    
    public String getProductImage(){
        return productImage;
    }
    
    public void setProductImage(String productImage){
        this.productImage = productImage;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public double getSubTotal(){
        return subTotal;
    }
    
    public void setSubTotal(double subTotal){
        this.subTotal = subTotal;
    }
}
