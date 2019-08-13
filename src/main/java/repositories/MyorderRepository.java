/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import commons.Helper;
import dao.GenericDAO;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Button;
import models.Cart;
import models.Cart_Flight;
import models.Cart_Flight_Order;
import models.Cart_Package;
import models.Flight;
import models.Orders;
import models.Orders_Packages;
import models.Packages;

/**
 *
 * @author ankur
 */
public class MyorderRepository {

    public static Orders getOrders() {
        List<GenericDAO.Condition> conditions = new ArrayList<>();
        conditions.add(GenericDAO.makeCondition("user_id", GenericDAO.EQUALS, commons.Common.LOGGED_IN_USERID));
        Orders orders = null;
        try {
            orders = (Orders) GenericDAO.first(Orders.class, conditions);
            if (orders == null) {
                throw new NullPointerException("Orders Not Initialized");
            }
            return orders;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /*-----------------getPackages() method --> to get packages associated with current user_id----------------*/
    //Use of Orders_Packages to get package_id from package_package_id and order_order_id
    public static List<Packages> getPackages(String userID) throws Exception {
        List<GenericDAO.Condition> conditions = new ArrayList<>();
        conditions.add(GenericDAO.makeCondition("user_id", GenericDAO.EQUALS, userID));
        Orders orders = (Orders) GenericDAO.first(Orders.class, conditions);
        conditions = new ArrayList<>();
        conditions.add(GenericDAO.makeCondition("order_order_id", GenericDAO.EQUALS, orders.getOrderID()));
        List<Object> orders_package = GenericDAO.objects(Orders_Packages.class, conditions);
        List<Packages> packages = new ArrayList<>();
        for (Object op : orders_package) {
            conditions = new ArrayList<>();
            conditions.add(GenericDAO.makeCondition("package_id", GenericDAO.EQUALS, ((Orders_Packages) op).getPackages_packageID()));
            packages.add((Packages) GenericDAO.first(Packages.class, conditions));
        }
        return packages;
    }

    public static List<Packages> getOrderPackages(String userID) throws Exception {
        List<GenericDAO.Condition> conditions = new ArrayList<>();
        conditions.add(GenericDAO.makeCondition("user_id", GenericDAO.EQUALS, userID));
        Orders orders = (Orders) GenericDAO.first(Orders.class, conditions);
        conditions = new ArrayList<>();
        conditions.add(GenericDAO.makeCondition("order_order_id", GenericDAO.EQUALS, orders.getOrderID()));
        List<Object> orders_package = GenericDAO.objects(Orders_Packages.class, conditions);
        List<Packages> packages = new ArrayList<>();
        List<Packages> orderPackages = new ArrayList<>();
        for (Object op : orders_package) {
            conditions = new ArrayList<>();
            conditions.add(GenericDAO.makeCondition("package_package_id", GenericDAO.EQUALS, ((Orders_Packages) op).getPackages_packageID()));
            packages.add((Packages) GenericDAO.first(Packages.class, conditions));
        }

        for (Packages p : packages) {
            Packages opo = new Packages();
            opo.setPackageName(p.getPackageName());
            opo.setPackageDays(p.getPackageDays());
            opo.setPackagePrice(p.getPackagePrice());
            orderPackages.add(opo);
        }
        return orderPackages;
    }

}
