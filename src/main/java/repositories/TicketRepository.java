/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import commons.Helper;
import dao.GenericDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import models.Orders;
import models.Ticket;

/**
 *
 * @author gargi
 */
public class TicketRepository {
    
    public static String createTicket(double ticketPrice, String promoCode, String user_id, String order_id) {
       
        String ticketNumber = "TKT" + Helper.generateRandomNumber();
        String ticket_Number = "";
        try {
            
            Ticket tickets = new Ticket(ticketNumber, user_id, order_id,ticketPrice);
            if (GenericDAO.save(Ticket.class, tickets) == 0) {
                ticket_Number = ticketNumber;
            }

        } catch (Exception ex) {
        }
        return ticket_Number;
    }
    
}
