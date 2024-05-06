package myPackage.cart;

public class AddressItem {
    private String addressType;
    private String streetAddress;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    
    public AddressItem(String addressType, String streetAddress, String city, String state, String postalCode, String country){
        this.addressType = addressType;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
    }
    
    public String getAddressType(){
        return addressType;
    }
    
    public void setAddressType(String addressType){
        this.addressType = addressType;
    }
    
    public String getStreetAddress(){
        return streetAddress;
    }
    
    public void setStreetAddress(String streetAddress){
        this.streetAddress = streetAddress;
    }
    
    public String getCity(){
        return city;
    }
    
    public void setCity(String city){
        this.city = city;
    }
    
    public String getState(){
        return state;
    }
    
    public void getState(String state){
        this.state = state;
    }
    
    public String getPostalCode(){
        return postalCode;
    }
    
    public void setPostalCode(String postalCode){
        this.postalCode = postalCode;
    }
    
    public String getCountry(){
        return country;
    }
    
    public void setCountry(String country){
        this.country = country;
    }
}
