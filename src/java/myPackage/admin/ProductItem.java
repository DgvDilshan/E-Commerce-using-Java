package myPackage.admin;

public class ProductItem {
    int proId;
    int catId;
    String catName;
    String proName;
    double proPrice;
    String proImg;
    String proDesc;
    double proReviews;
    String date;
    
    public ProductItem(int proId, int catId, String catName, String proName, double proPrice, String proImg, String proDesc, double proReviews, String date){
        this.proId = proId;
        this.catId = catId;
        this.catName = catName;
        this.proName = proName;
        this.proPrice = proPrice;
        this.proImg = proImg;
        this.proDesc = proDesc;
        this.proReviews = proReviews;
        this.date = date;
    }
    
    public int getProId(){
        return proId;
    }
    
    public void setProId(int proId){
        this.proId = proId;
    }
    
    public int getCatId(){
        return catId;
    }
    
    public void setCatId(int catId){
        this.catId = catId;
    }
    
    public String getCatName(){
        return catName;
    }
    
    public void setCatName(String catName){
        this.catName = catName;
    }
    
    public String getProName(){
        return proName;
    }
    
    public void setProName(String proName){
        this.proName = proName;
    }
    
    public double getProPrice(){
        return proPrice;
    }
    
    public void setProPrice(double proPrice){
        this.proPrice = proPrice;
    }
    
    public String getProImg(){
        return proImg;
    }
    
    public void setProImg(String proImg){
        this.proImg = proImg;
    }
    
    public String getProDesc(){
        return proDesc;
    }
    
    public void setProDesc(String proDesc){
        this.proDesc = proDesc;
    }
    
    public double getProReviews(){
        return proReviews;
    }
    
    public void setProReviews(double proReviews){
        this.proReviews = proReviews;
    }
    
    public String getDate(){
        return date;
    }
    
    public void setDate(String date){
        this.date = date;
    }
    
}
