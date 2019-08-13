/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import commons.Helper;
import dao.GenericDAO;
import models.Ticket;
import models.Orders_Packages;

/**
 *
 * @author gargi
 */
public class OrderPackageRepository {
     public static boolean createOrderPackage(String orderId, int packageId) {
       
       boolean result = false;
        try {
            
           Orders_Packages  orderPackages = new Orders_Packages(packageId, orderId);
            if (GenericDAO.save(Orders_Packages.class, orderPackages) != 0) {
                result = true;
            }

        } catch (Exception ex) {
        }
        return result;
    }
    
}
