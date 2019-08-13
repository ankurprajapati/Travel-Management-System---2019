/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import alexevan.annotations.MapToColumn;
import alexevan.annotations.PrimaryKey;
import java.util.Date;
import javafx.scene.control.Button;

/**
 *
 * @author gargi
 */
public class Cart_Flight_Order {
    
    private String flightNumber;
    //private String cartID;  
   
    private Date departureDate;
   
   
    private Date arrivalDate;
    
    private String departureIATACode;
   
    private String arrivalIATACode;
   
    private String airlineID;
   
   
    private double firstClassPrice;
  
    private double businessClassPrice;
    
    private double economyPrice;
   
    private boolean isFull;
    private Button removeBtn;
    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getDepartureIATACode() {
        return departureIATACode;
    }

    public void setDepartureIATACode(String departureIATACode) {
        this.departureIATACode = departureIATACode;
    }

    public String getArrivalIATACode() {
        return arrivalIATACode;
    }

    public void setArrivalIATACode(String arrivalIATACode) {
        this.arrivalIATACode = arrivalIATACode;
    }

    public String getAirlineID() {
        return airlineID;
    }

    public void setAirlineID(String airlineID) {
        this.airlineID = airlineID;
    }

    public double getFirstClassPrice() {
        return firstClassPrice;
    }

    public void setFirstClassPrice(double firstClassPrice) {
        this.firstClassPrice = firstClassPrice;
    }

    public double getBusinessClassPrice() {
        return businessClassPrice;
    }

    public void setBusinessClassPrice(double businessClassPrice) {
        this.businessClassPrice = businessClassPrice;
    }

    public double getEconomyPrice() {
        return economyPrice;
    }

    public void setEconomyPrice(double economyPrice) {
        this.economyPrice = economyPrice;
    }

    public boolean isIsFull() {
        return isFull;
    }

    public void setIsFull(boolean isFull) {
        this.isFull = isFull;
    }

    public Button getRemoveBtn() {
        return removeBtn;
    }

    public void setRemoveBtn(Button removeBtn) {
        this.removeBtn = removeBtn;
    }

     public Cart_Flight_Order() {
       
       
    }
     
    
     public Cart_Flight_Order(String flightNumber, String departureIATACode, String arrivalIATACode, Date departureDate, Date arrivalDate) {
        this.flightNumber = flightNumber;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.departureIATACode = departureIATACode;
        this.arrivalIATACode = arrivalIATACode;
        this.removeBtn = new Button("Remove");
       
    }
     
    
}
