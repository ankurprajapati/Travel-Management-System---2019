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
@MapToTable("Airline")
public class Airline implements Serializable{
    @PrimaryKey("airline_id")
    @MapToColumn("airline_id")
    private String airlineID;
    @MapToColumn("airline_name")
    private String airlineName;

    public Airline() {
    }
    
    public Airline(String airlineID, String airlineName) {
        this.airlineID = airlineID;
        this.airlineName = airlineName;
    }

    public String getAirlineID() {
        return airlineID;
    }

    public void setAirlineID(String airlineID) {
        this.airlineID = airlineID;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    @Override
    public String toString() {
        return "Airline{" + "airlineID=" + airlineID + ", airlineName=" + airlineName + '}';
    }

    

    
}
