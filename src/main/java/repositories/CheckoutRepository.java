/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import dao.GenericDAO;
import models.User;

/**
 *
 * @author Alex Christian
 */
public class CheckoutRepository {

    public static boolean updateUserBillingDetails(User user) {
        if (GenericDAO.save(User.class, user) == 0) {
            return false;
        } else {
            return true;
        }
    }
}
