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
@MapToTable("PromoCode")
public class PromoCode implements Serializable{
    @PrimaryKey("promo_code")
    @MapToColumn("promo_code")
    private String promoCode;
    @MapToColumn("discount")
    private double discount;

    public PromoCode() {
    }
    
    public PromoCode(String promoCode, double discount) {
        this.promoCode = promoCode;
        this.discount = discount;
    }

    public String getPromoCode() {
        return promoCode;
    }

    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "PromoCode{" + "promoCode=" + promoCode + ", discount=" + discount + '}';
    }
    
}
