/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import dao.GenericDAO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import models.Aircraft;
import models.Airline_Aircraft;
import models.Cart;
import models.Cart_Flight;
import models.Flight;
import sun.java2d.loops.CompositeType;

/**
 *
 * @author Falak
 */
public class FlightRepository {

    public static List<Flight> getFlights() {
        List<Flight> flights = new ArrayList<Flight>();
        try {
            for (Object o : GenericDAO.objects(Flight.class)) {
                System.out.println(o);
                flights.add((Flight) o);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        if (flights.size() > 0) {
            return flights;
        }
        return null;
    }

    public static List<Flight> getFlights(Date departureDate, Date arrivalDate) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        
        //System.out.println(arrivalDate);
        List<Flight> flights = new ArrayList<>();
        String[] dDate = format.format(departureDate).split(" "), aDate = format.format(arrivalDate).split(" ");
        //System.out.println(dDate[0]);
        for (Flight flight : getFlights()) {
            System.out.println(flight.getArrivalDate().toString().split(" ")[0]);
            if (flight.getArrivalDate().toString().split(" ")[0].equals(aDate[0]) && flight.getDepartureDate().toString().split(" ")[0].equals(dDate[0])) {
                flights.add(flight);
            }
        }
        if (flights.size() > 0) {
            return flights;
        }
        return null;
    }

    public static List<Flight> getFlights(Date departureDate) {
        List<Flight> flights = new ArrayList<Flight>();
        String dDate = departureDate.toString().split(" ")[0];
        for (Flight flight : getFlights()) {
            if (dDate.equals(flight.getDepartureDate().toString().split(" ")[0])) {
                flights.add(flight);
            }
        }
        if (flights.size() > 0) {
            return flights;
        }
        return null;
    }

    public static List<Flight> getFlights(Date departureDate, Date arrivalDate, boolean isRoundTrip) {
        List<Flight> flights = new ArrayList<Flight>();
        for (Flight flight : getFlights(departureDate, arrivalDate)) {
            if (isRoundTrip) {
                flight.setEconomyPrice(flight.getEconomyPrice() * 2);
                flight.setBusinessClassPrice(flight.getBusinessClassPrice() * 2);
                flight.setFirstClassPrice(flight.getFirstClassPrice() * 2);
                flights.add(flight);
            }
            else{
                flights.add(flight);
            }
        }
        if (flights.size() > 0) {
            return flights;
        }
        return null;
    }

    public static List<Flight> getFlights(Date departureDate, Date arrivalDate, boolean isRoundTrip, int travellers, String className) {
        List<Flight> flights = new ArrayList<>();
        List<GenericDAO.Condition> conditions = new ArrayList<>();
        try {
            for (Flight flight : getFlights(departureDate, arrivalDate, isRoundTrip)) {
                conditions.add(GenericDAO.makeCondition("aircraft_model", GenericDAO.EQUALS, flight.getAircraftModel()));
                Aircraft aircraft = (Aircraft) GenericDAO.first(Aircraft.class, conditions);
                System.out.println(aircraft);
                System.out.println(flight);
                if (className.equalsIgnoreCase("first")) {
                    if (aircraft.getFirstClassCapacity() - flight.getFirstClassBookings() >= travellers) {
                        flights.add(flight);
                    }
                } else if (className.equalsIgnoreCase("business")) {
                    if (aircraft.getBusinessCapacity() - flight.getBusinessClassBookings() >= travellers) {
                        flights.add(flight);
                    }
                } else if (className.equalsIgnoreCase("economy")) {
                    if (aircraft.getEconomyCapacity() - flight.getEconomyClassBookings() >= travellers) {
                        flights.add(flight);
                    }
                }

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (flights.size() > 0) {
            return flights;
        }
        return null;
    }

    public static boolean addToCart(Flight flight) {
        try {
            Cart cart = CartRepository.getCart();
            Cart_Flight cf = new Cart_Flight(cart.getCartId(), flight.getFlightNumber());
            GenericDAO.save(Cart_Flight.class, cf);
            List<GenericDAO.Condition> conditions = new ArrayList<>();
            conditions.add(GenericDAO.makeCondition("aircraft_model", GenericDAO.EQUALS, flight.getAircraftModel()));
            Aircraft aircraft = (Aircraft) GenericDAO.first(Aircraft.class, conditions);
            if (aircraft.getEconomyCapacity() - flight.getEconomyClassBookings() <= 0 && aircraft.getBusinessCapacity() - flight.getBusinessClassBookings() <= 0 && aircraft.getFirstClassCapacity() - flight.getFirstClassBookings() <= 0) {
                flight.setIsFull(true);
            } else {
                flight.setIsFull(false);
            }
            GenericDAO.save(Flight.class, flight);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static List<Flight> getFlights(String destIATA, String arrIATA) {
        List<Flight> flights = new ArrayList<>();
        List<GenericDAO.Condition> conditions = new ArrayList<>();
        //
        conditions.add(GenericDAO.makeANDCondition(GenericDAO.makeCondition("arrivalIATA_IATACode", GenericDAO.EQUALS, arrIATA), GenericDAO.makeCondition("departureIATA_IATACode", GenericDAO.EQUALS, destIATA)));
        try {
            for (Object flight : GenericDAO.objects(Flight.class, conditions)) {
                flights.add((Flight) flight);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        if (flights.size() > 0) {
            return flights;
        }
        return null;
    }

    public static List<Flight> getFlights(String destIATA, String arrIATA, Date departureDate, Date arrivalDate, boolean isRoundTrip, int travellers, String className) {
        List<Flight> flights = new ArrayList<>();
        
        for (Flight flight : getFlights(departureDate, arrivalDate, isRoundTrip, travellers, className)) {
            if (flight.getArrivalIATACode().equals(arrIATA) && flight.getDepartureIATACode().equals(destIATA)) {
                flights.add(flight);
            }
        }
        if (flights.size() > 0) {
            return flights;
        }
        return null;
    }

}
