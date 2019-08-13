/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import alexevan.annotations.MapToColumn;
import alexevan.annotations.MapToTable;
import java.io.Serializable;

/**
 *
 * @author Falak
 */
@MapToTable("Airline_Aircraft")
public class Airline_Aircraft implements Serializable{
    @MapToColumn("aircraft_aircraft_model")
    private String Aircraft_aircraftModel;
    @MapToColumn("airline_airline_id")
    private String Airline_airlineID;

    public Airline_Aircraft() {
    }

    public Airline_Aircraft(String Aircraft_aircraftModel, String Airline_airlineID) {
        this.Aircraft_aircraftModel = Aircraft_aircraftModel;
        this.Airline_airlineID = Airline_airlineID;
    }

    public String getAircraft_aircraftModel() {
        return Aircraft_aircraftModel;
    }

    public void setAircraft_aircraftModel(String Aircraft_aircraftModel) {
        this.Aircraft_aircraftModel = Aircraft_aircraftModel;
    }

    public String getAirline_airlineID() {
        return Airline_airlineID;
    }

    public void setAirline_airlineID(String Airline_airlineID) {
        this.Airline_airlineID = Airline_airlineID;
    }

    @Override
    public String toString() {
        return "Airline_Aircraft{" + "Aircraft_aircraftModel=" + Aircraft_aircraftModel + ", Airline_airlineID=" + Airline_airlineID + '}';
    }
    
}
