package myPackage.shop;

public class Shop {
    int proId;
    String proName;
    String discountPrice;
    String proPrice;
    String proImg;
    double proReviews;
    
    public Shop (int proId, String proName, String discountPrice, String proPrice, String proImg) {
        this.proId = proId;
        this.proName = proName;
        this.discountPrice = discountPrice;
        this.proPrice = proPrice;
        this.proImg = proImg;
        this.proReviews = proReviews;
        
    }
    
    public int getProId(){
        return proId;
    }
    
    public void setProId(int proId){
        this.proId = proId;
    }
    
    public String getProName(){
        return proName;
    }
    
    public void setProName(String proName){
        this.proName = proName;
    }
    
      public String getDiscountPrice(){
          return discountPrice;
      }
      
      public void setDiscountPrice(String discountPrice){
          this.discountPrice = discountPrice;
      }
    
    public String getProPrice(){
        return proPrice;
    }
    
    public void setProPrice(String proPrice){
        this.proPrice = proPrice;
    }
    
    public String getProImg(){
        return proImg;
    }
    
    public void setProImg(String proImg){
        this.proImg = proImg;
    }
    
    /*public double getProReviews(){
        return proReviews;
    }
    
    public void setProReviews(double proReviews){
        this.proReviews = proReviews;
    }*/
}
