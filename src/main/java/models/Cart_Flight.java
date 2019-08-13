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
@MapToTable("Cart_Flight")
public class Cart_Flight implements Serializable {

    @PrimaryKey("id")
    @MapToColumn("id")
    private int id;

    @MapToColumn("cart_cart_id")
    private String cartID;
    @MapToColumn("flight_flight_number")
    private String flightID;

    public Cart_Flight() {
    }

    public Cart_Flight(String cartID, String flightID) {
        this.cartID = cartID;
        this.flightID = flightID;

    }

    public String getCartID() {
        return cartID;
    }

    public void setCartID(String cartID) {
        this.cartID = cartID;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getFlightID() {
        return flightID;
    }

    public void setFlightID(String flightID) {
        this.flightID = flightID;
    }

    @Override
    public String toString() {
        return "Cart_Flight{" + "cartID=" + cartID + ", flightID=" + flightID + '}';
    }

}
