package myPackage.admin;

public class Category {
    int catId;
    String catName;
    String catSlug;
    
    public Category(int catId, String catName, String catSlug){
        this.catId = catId;
        this.catName = catName;
        this.catSlug = catSlug;
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
    
    public String getCatSlug(){
        return catSlug;
    }
    
    public void setCatSlug(String catSlug){
        this.catSlug = catSlug;
    }
}
