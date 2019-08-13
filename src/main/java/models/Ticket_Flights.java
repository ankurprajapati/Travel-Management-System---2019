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
@MapToTable("Ticket_Flight")
public class Ticket_Flights implements Serializable{
    @MapToColumn("flight_flight_number")
    private String flights_flightNumber;
    @MapToColumn("ticket_ticket_number")
    private String ticket_ticketNumber;

    public Ticket_Flights() {
    }
    
    public Ticket_Flights(String flights_flightNumber, String ticket_ticketNumber) {
        this.flights_flightNumber = flights_flightNumber;
        this.ticket_ticketNumber = ticket_ticketNumber;
    }

    public String getFlights_flightNumber() {
        return flights_flightNumber;
    }

    public void setFlights_flightNumber(String flights_flightNumber) {
        this.flights_flightNumber = flights_flightNumber;
    }

    public String getTicket_ticketNumber() {
        return ticket_ticketNumber;
    }

    public void setTicket_ticketNumber(String ticket_ticketNumber) {
        this.ticket_ticketNumber = ticket_ticketNumber;
    }

    @Override
    public String toString() {
        return "Ticket_Flights{" + "flights_flightNumber=" + flights_flightNumber + 
                ", ticket_ticketNumber=" + ticket_ticketNumber + '}';
    }  
}
