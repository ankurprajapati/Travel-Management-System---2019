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
@MapToTable("Aircraft")
public class Aircraft implements Serializable{
    @PrimaryKey("aircraft_model")
    @MapToColumn("aircraft_model")
    private String aircraftModel;
    @MapToColumn("aircraft_make")
    private String aircraftMake;
    @MapToColumn("firstclass_capacity")
    private int firstClassCapacity;
    @MapToColumn("business_capacity")
    private int businessCapacity;
    @MapToColumn("economy_capacity")
    private int economyCapacity;

    public Aircraft() {
    }

    @Override
    public String toString() {
        return "Aircraft{" + "aircraftModel=" + aircraftModel + ", aircraftMake=" + aircraftMake + ", firstClassCapacity=" + firstClassCapacity + ", businessCapacity=" + businessCapacity + ", economyCapacity=" + economyCapacity + '}';
    }
    
    
    
    public Aircraft(String aircraftModel, String aircraftMake, int firstClassCapacity, int businessCapacity, int economyCapacity) {
        this.aircraftModel = aircraftModel;
        this.aircraftMake = aircraftMake;
        this.firstClassCapacity = firstClassCapacity;
        this.businessCapacity = businessCapacity;                   
        this.economyCapacity = economyCapacity;
    }

    public String getAircraftModel() {
        return aircraftModel;
    }

    public void setAircraftModel(String aircraftModel) {
        this.aircraftModel = aircraftModel;
    }

    public String getAircraftMake() {
        return aircraftMake;
    }

    public void setAircraftMake(String aircraftMake) {
        this.aircraftMake = aircraftMake;
    }

    public int getFirstClassCapacity() {
        return firstClassCapacity;
    }

    public void setFirstClassCapacity(int firstClassCapacity) {
        this.firstClassCapacity = firstClassCapacity;
    }

    public int getBusinessCapacity() {
        return businessCapacity;
    }

    public void setBusinessCapacity(int businessCapacity) {
        this.businessCapacity = businessCapacity;
    }

    public int getEconomyCapacity() {
        return economyCapacity;
    }

    public void setEconomyCapacity(int economyCapacity) {
        this.economyCapacity = economyCapacity;
    }
    
}
