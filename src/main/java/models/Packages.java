/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import alexevan.annotations.MapToColumn;
import alexevan.annotations.MapToTable;
import alexevan.annotations.PrimaryKey;
import java.io.Serializable;


/**
 *
 * @author Alex Christian
 */
@MapToTable("Package")
public class Packages implements Serializable{

    //private String orderID;
    @PrimaryKey("package_id")
    @MapToColumn("package_id")
    private String packageID;
    @MapToColumn("package_name")
    private String packageName;
    @MapToColumn("package_days")
    private int packageDays;
//   @MapToColumn("cart_cart_id")
//    private String cartID;
    @MapToColumn("hotel_hotel_id")
    private String hotelID;
    @MapToColumn("available_packages")
    private int availablePackages;
    @MapToColumn("package_price")
    private double packagePrice;

    public Packages() {
    }

    public Packages(String packageID, String packageName, int packageDays,String hotelID, int availablePackages, double packagePrice) {
        this.packageID = packageID;
        this.packageName = packageName;
        this.packageDays = packageDays;
        //this.cartID = cartID;
        this.hotelID = hotelID;
        this.availablePackages = availablePackages;
        this.packagePrice = packagePrice;
    }

    public String getPackageID() {
        return packageID;
    }

    public void setPackageID(String packageID) {
        this.packageID = packageID;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public int getPackageDays() {
        return packageDays;
    }

    public void setPackageDays(int packageDays) {
        this.packageDays = packageDays;
    }

//    public String getCartID() {
//        return cartID;
//    }
//
//    public void setCartID(String cartID) {
//        this.cartID = cartID;
//    }

    public String getHotelID() {
        return hotelID;
    }

    public void setHotelID(String hotelID) {
        this.hotelID = hotelID;
    }

    public int getAvailablePackages() {
        return availablePackages;
    }

    public void setAvailablePackages(int availablePackages) {
        this.availablePackages = availablePackages;
    }

    public double getPackagePrice() {
        return packagePrice;
    }

    public void setPackagePrice(double packagePrice) {
        this.packagePrice = packagePrice;
    }

    @Override
    public String toString() {
        return "Packages{" + "packageID=" + packageID + 
                ", packageName=" + packageName + 
                ", packageDays=" + packageDays + 
                ", hotelID=" + hotelID + 
                ", availablePackages=" + availablePackages + 
                ", packagePrice=" + packagePrice + '}';
    }    
}
