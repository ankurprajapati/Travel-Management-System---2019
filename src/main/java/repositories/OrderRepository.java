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
import models.PromoCode;
import models.User;

/**
 *
 * @author gargi
 */
public class OrderRepository {

    public static String createOrder(Date orderDate, String promoCode, String user_id) {
        List<GenericDAO.Condition> conditions = new ArrayList<>();
        conditions.add(GenericDAO.makeCondition("user_id", GenericDAO.EQUALS, commons.Common.LOGGED_IN_USERID));
        String orderId = "ORD" + Helper.generateRandomNumber();
        String order_Id = "";
        try {
            Orders orders = new Orders(orderId, orderDate, promoCode, commons.Common.LOGGED_IN_USERID);
            if (GenericDAO.save(Orders.class, orders) != 0) {
                order_Id = orderId;
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return order_Id;
    }
}
