
package myPackage.authentication;
public class Account {

    protected int user_id;
    protected String first_name;
    protected String last_name;
    protected String display_name;
    protected String email;
    protected String password;
    protected String billing_phone;
    protected String billing_address;
    protected String shipping_phone;
    protected String shipping_address;
    protected String billing_name;
    protected String shipping_name;

//    public Account(int user_id, String first_name, String last_name, String display_name, String email, String password, String billing_phone, String billing_address, String shipping_phone, String shipping_address, String billing_name, String shipping_name) {
//        this.user_id = user_id;
//        this.first_name = first_name;
//        this.last_name = last_name;
//        this.display_name = display_name;
//        this.email = email;
//        this.password = password;
//        this.billing_phone = billing_phone;
//        this.billing_address = billing_address;
//        this.shipping_phone = shipping_phone;
//        this.shipping_address = shipping_address;
//        this.billing_name = billing_name;
//        this.shipping_name = shipping_name;
//    }

    public Account(int user_id, String first_name, String last_name, String display_name, String email, String password) {
        this.user_id = user_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.display_name = display_name;
        this.email = email;
        this.password = password;
    }

    public Account(int user_id, String name, String phone, String address,boolean is_billing) {
        if(is_billing){
            this.user_id = user_id;
            this.billing_name = name;
            this.billing_phone = phone;
            this.billing_address = address;
        } else {
            this.user_id = user_id;
            this.shipping_name = name;
            this.shipping_phone = phone;
            this.shipping_address = address;
        }  
    }
    
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBilling_phone(String billing_phone) {
        this.billing_phone = billing_phone;
    }

    public void setBilling_address(String billing_address) {
        this.billing_address = billing_address;
    }

    public void setShipping_phone(String shipping_phone) {
        this.shipping_phone = shipping_phone;
    }

    public void setShipping_address(String shipping_address) {
        this.shipping_address = shipping_address;
    }

    public void setBilling_name(String billing_name) {
        this.billing_name = billing_name;
    }

    public void setShipping_name(String shipping_name) {
        this.shipping_name = shipping_name;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getBilling_phone() {
        return billing_phone;
    }

    public String getBilling_address() {
        return billing_address;
    }

    public String getShipping_phone() {
        return shipping_phone;
    }

    public String getShipping_address() {
        return shipping_address;
    }

    public String getBilling_name() {
        return billing_name;
    }

    public String getShipping_name() {
        return shipping_name;
    }

}