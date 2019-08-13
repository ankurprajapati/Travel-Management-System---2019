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
import models.User;

/**
 *
 * @author Alex Christian
 */
public class UserRepository {

    public static boolean registerOrUpdateUser(String givenName, String familyName, Date birthDate, String email, String phone, String password, String vercode) {
        List<GenericDAO.Condition> conditions = new ArrayList<>();
        conditions.add(GenericDAO.makeCondition("user_id", GenericDAO.EQUALS, email));
        try {
            User checkUser = (User) GenericDAO.first(User.class, conditions);
            if (checkUser != null) {
                return false;
            }
            User client = new User(email, email, phone, password, familyName, givenName, false, vercode);
            if (GenericDAO.save(User.class, client) == 0) {
                return false;
            }
            return true;
        } catch (NullPointerException ex) {
            return false;
        }

    }

    public static boolean updateUser(String givenName, String familyName, String email, String address, String postalCode, String country, String idNumber, Date passportExpDate) {
        List<GenericDAO.Condition> conditions = new ArrayList<>();
        conditions.add(GenericDAO.makeCondition("user_id", GenericDAO.EQUALS, email));
        try {
            User checkUser = (User) GenericDAO.first(User.class, conditions);
            String address1 = address + " " + country + " " + postalCode;
            User client = new User(email, email, checkUser.getMobileNumber(), checkUser.getPassword(), familyName, givenName, false, checkUser.getVercode(), address1, idNumber, passportExpDate);
            if (GenericDAO.save(User.class, client) == 0) {
                return false;
            }
            return true;
        } catch (NullPointerException ex) {
            return false;
        }

    }

    public static User getClient(String userID) {
        List<GenericDAO.Condition> conditions = new ArrayList<>();
        conditions.add(GenericDAO.makeCondition("user_id", GenericDAO.EQUALS, userID));
        return (User) GenericDAO.first(User.class, conditions);
    }

}
