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
@MapToTable("Package_Flight")
public class Packages_Flights implements Serializable{
    @MapToColumn("filghts_flight_number")
    private String filghts_flightNumber;
    @MapToColumn("package_package_id")
    private String packages_packageID;

    public Packages_Flights() {
    }
    
    public Packages_Flights(String filghts_flightNumber, String packages_packageID) {
        this.filghts_flightNumber = filghts_flightNumber;
        this.packages_packageID = packages_packageID;
    }

    public String getFilghts_flightNumber() {
        return filghts_flightNumber;
    }

    public void setFilghts_flightNumber(String filghts_flightNumber) {
        this.filghts_flightNumber = filghts_flightNumber;
    }

    public String getPackages_packageID() {
        return packages_packageID;
    }

    public void setPackages_packageID(String packages_packageID) {
        this.packages_packageID = packages_packageID;
    }

    @Override
    public String toString() {
        return "Packages_Flights{" + "filghts_flightNumber=" + filghts_flightNumber + 
                ", packages_packageID=" + packages_packageID + '}';
    }
    
}
