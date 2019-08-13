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
@MapToTable("IATA")
public class IATA implements Serializable{
    @PrimaryKey("IATA_code")
    @MapToColumn("IATA_code")
    private String IATACode;
    @MapToColumn("IATA_name")
    private String IATAName;
    @MapToColumn("airport_country")
    private String airportCountry;
    @MapToColumn("airport_city")
    private String airportCity;

    public IATA() {
    }
    
    public IATA(String IATACode, String IATAName, String airportName, String airportCity) {
        this.IATACode = IATACode;
        this.IATAName = IATAName;
        this.airportCountry = airportCountry;
        this.airportCity = airportCity;
    }

    public String getIATACode() {
        return IATACode;
    }

    public void setIATACode(String IATACode) {
        this.IATACode = IATACode;
    }

    public String getIATAName() {
        return IATAName;
    }

    public void setIATAName(String IATAName) {
        this.IATAName = IATAName;
    }

    public String getAirportCountry() {
        return airportCountry;
    }

    public void setAirportCountry(String airportCountry) {
        this.airportCountry = airportCountry;
    }
    
    public String getAirportCity() {
        return airportCity;
    }

    public void setAirportCity(String airportCity) {
        this.airportCity = airportCity;
    }

    @Override
    public String toString() {
        return "IATA{" + "IATACode=" + IATACode + 
                ", IATAName=" + IATAName + 
                ", airportCountry=" + airportCountry + 
                ", airportCity=" + airportCity + '}';
    }  
}
