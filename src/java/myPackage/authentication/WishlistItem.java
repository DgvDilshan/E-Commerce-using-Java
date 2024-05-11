/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myPackage.authentication;

/**
 *
 * @author DELL-LAP
 */
public class WishlistItem {
    private int wishlist_id;
    private int pro_id;
    private String pro_name;
    private String pro_img;
    private double price;

    public WishlistItem(int wishlist_id, int pro_id, String pro_name, String pro_img, double price) {
        this.wishlist_id = wishlist_id;
        this.pro_id = pro_id;
        this.pro_name = pro_name;
        this.pro_img = pro_img;
        this.price = price;
    }

    public int getWishlist_id() {
        return wishlist_id;
    }

    public void setWishlist_id(int wishlist_id) {
        this.wishlist_id = wishlist_id;
    }

    public int getPro_id() {
        return pro_id;
    }

    public void setPro_id(int pro_id) {
        this.pro_id = pro_id;
    }

    public String getPro_name() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }

    public String getPro_img() {
        return pro_img;
    }

    public void setPro_img(String pro_img) {
        this.pro_img = pro_img;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}