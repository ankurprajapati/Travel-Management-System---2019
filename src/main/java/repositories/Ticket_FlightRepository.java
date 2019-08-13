/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import commons.Helper;
import dao.GenericDAO;
import models.Ticket;
import models.Ticket_Flights;

/**
 *
 * @author gargi
 */
public class Ticket_FlightRepository {

    public static boolean createTicketFlight(String ticketNumber, String flightNumber) {

        boolean result = false;
        try {

            Ticket_Flights ticket_flights = new Ticket_Flights(ticketNumber, flightNumber);
            result = GenericDAO.save(Ticket_Flights.class, ticket_flights) == 0;

        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return result;
    }

}
