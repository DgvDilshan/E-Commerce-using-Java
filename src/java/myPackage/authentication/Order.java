
package myPackage.authentication;

public class Order {
    protected int order_id;
    protected int user_id;
    protected String order_code;
    protected float total;
    protected String shipping_method;
    protected String order_date;

    public Order(int order_id, String order_code, float total, String shipping_method, String order_date) {
        this.order_id = order_id;
        this.order_code = order_code;
        this.total = total;
        this.shipping_method = shipping_method;
        this.order_date = order_date;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setOrder_code(String order_code) {
        this.order_code = order_code;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public void setShipping_method(String shipping_method) {
        this.shipping_method = shipping_method;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public int getOrder_id() {
        return order_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getOrder_code() {
        return order_code;
    }

    public float getTotal() {
        return total;
    }

    public String getShipping_method() {
        return shipping_method;
    }

    public String getOrder_date() {
        return order_date;
    }

   
}
