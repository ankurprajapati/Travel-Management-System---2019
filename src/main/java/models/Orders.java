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
import java.util.Date;
import java.util.List;

/**
 *
 * @author Alex Christian
 */
@MapToTable("Orders")
public class Orders implements Serializable {

    @PrimaryKey("order_id")
    @MapToColumn("order_id")
    private String orderID;
    @MapToColumn("ticket_number")
    private String ticketNumber;
    @MapToColumn("order_date")
    private Date orderDate;
    @MapToColumn("promocode_promocode")
    private String promoCode;
    @MapToColumn("user_id")
    private String userID;

    public Orders() {
    }

    public Orders(String orderID, String ticketNumber, Date orderDate, String promoCode) {
        this.orderID = orderID;
        this.ticketNumber = ticketNumber;
        this.orderDate = orderDate;
        this.promoCode = promoCode;
        this.orderDate = new Date();
    }

    public Orders(String orderID, Date orderDate, String promoCode, String userID) {
        this.orderID = orderID;
        this.ticketNumber = "NULL";
        this.orderDate = orderDate;
        if (promoCode.equalsIgnoreCase("")) {
            this.promoCode = "NULL";
        } else {
            this.promoCode = promoCode;
        }
        this.userID = userID;
        System.out.println(this.toString());

    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getPromoCode() {
        return promoCode;
    }

    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }

    public String getUserId() {
        return userID;
    }

    public void setuserId(String userId) {
        this.userID = userId;
    }

    @Override
    public String toString() {
        return "Orders{" + "orderID=" + orderID
                + ", ticketNumber=" + ticketNumber
                + ", orderDate=" + orderDate
                + ", promoCode=" + promoCode
                + ", userId=" + userID + '}';

    }
}
