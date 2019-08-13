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
@MapToTable("Ticket")
public class Ticket implements Serializable{
    @PrimaryKey("ticket_number")
    @MapToColumn("ticket_number")
    private String ticketNumber;
    @MapToColumn("ticket_price")
    private double ticketPrice;
    @MapToColumn("client_user_id")
    private String userID;
    @MapToColumn("order_id")
    private String orderID;

    public Ticket() {
    }
    
    public Ticket(String ticketNumber, String userID, String orderID, double ticketPrice) {
        this.ticketNumber = ticketNumber;
        this.userID = userID;
        this.orderID = orderID;
        this.ticketPrice = ticketPrice;
    }
    
    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    @Override
    public String toString() {
        return "Ticket{" + "ticketNumber=" + ticketNumber + 
                ", ticketPrice=" + ticketPrice + 
                ", userID=" + userID + ", orderID=" + orderID + '}';
    }
}
