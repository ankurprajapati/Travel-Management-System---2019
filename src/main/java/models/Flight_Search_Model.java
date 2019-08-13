/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;
import javafx.scene.control.Button;

/**
 *
 * @author Falak
 */
public class Flight_Search_Model {

    private String flightNumber, departure, arrival;
    private Date departureDate, arrivalDate;
    private int travellers;
    private double price;
    private Button book;

    public Flight_Search_Model(String flightNumber, String departure, String arrival, Date departureDate, Date arrivalDate, int travellers, double price, Button book) {
        this.flightNumber = flightNumber;
        this.departure = departure;
        this.arrival = arrival;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.travellers = travellers;
        this.price = price*travellers;
        this.book = new Button("Add To Cart");
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
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

    public int getTravellers() {
        return travellers;
    }

    public void setTravellers(int travellers) {
        this.travellers = travellers;
    }

    @Override
    public String toString() {
        return "Flight_Search_Model{" + "flightNumber=" + flightNumber + ", departure=" + departure + ", arrival=" + arrival + ", departureDate=" + departureDate + ", arrivalDate=" + arrivalDate + ", travellers=" + travellers + ", price=" + price + ", book=" + book + '}';
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Button getBook() {
        return book;
    }

    public void setBook(Button book) {
        this.book = book;
    }

}
