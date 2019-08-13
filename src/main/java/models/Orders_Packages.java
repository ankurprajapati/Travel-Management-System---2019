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
 * @author Falak
 */
@MapToTable("Order_Package")
public class Orders_Packages implements Serializable{
    @MapToColumn("package_package_id")
    private int packages_packageID;
    @MapToColumn("order_order_id")
    private String orders_orderID;
    @PrimaryKey("id")
    @MapToColumn("id")
    private int id;
    
    public Orders_Packages() {
    }
    
    public Orders_Packages(int packages_packageID, String orders_orderID) {
        this.packages_packageID = packages_packageID;
        this.orders_orderID = orders_orderID;
    }

    public int getPackages_packageID() {
        return packages_packageID;
    }

    public void setPackages_packageID(int packages_packageID) {
        this.packages_packageID = packages_packageID;
    }

    public String getOrders_orderID() {
        return orders_orderID;
    }

    public void setOrders_orderID(String orders_orderID) {
        this.orders_orderID = orders_orderID;
    }

    @Override
    public String toString() {
        return "Orders_Packages{" + "packages_packageID=" + packages_packageID + 
                ", orders_orderID=" + orders_orderID + '}';
    }
}
