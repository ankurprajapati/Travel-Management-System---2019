/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import alexevan.annotations.MapToColumn;
import javafx.scene.control.Button;

/**
 *
 * @author gargi
 */
public class Cart_Packages_Order {
      
    private String packageID;
    private String packageName;   
    private int packageDays;    
    private String hotelID;   
    private int availablePackages;   
    private double packagePrice;
    private Button removeBtn;

    public Cart_Packages_Order() {
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

    public Button getRemoveBtn() {
        return removeBtn;
    }

    public void setRemoveBtn(Button removeBtn) {
        this.removeBtn = removeBtn;
    }

//    public Cart_Packages_Order(String packageName, int packageDays, double packagePrice) {
//        this.packageName = packageName;
//        this.packageDays = packageDays;
//        this.packagePrice = packagePrice;
//        this.removeBtn = new Button("Remove");
//    }
    
    
    
}
