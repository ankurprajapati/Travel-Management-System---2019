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
@MapToTable("Cart")
public class Cart implements Serializable {
    @PrimaryKey("cart_id")
    @MapToColumn("cart_id")
    private String cartId;
    @MapToColumn("user_id")
    private String userID;

    public Cart() {
    }

    public Cart(String cartId, String userID) {
        this.cartId = cartId;
        this.userID = userID;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "Cart{" + "cartId=" + cartId + ", userID=" + userID + '}';
    }

}
