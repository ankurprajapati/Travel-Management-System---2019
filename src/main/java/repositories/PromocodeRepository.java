/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import dao.GenericDAO;
import java.util.ArrayList;
import java.util.List;

import models.PromoCode;

/**
 *
 * @author gargi
 */
public class PromocodeRepository {

    public static PromoCode getPromoCode(String promoCode) {
        PromoCode promocode = new PromoCode();
        List<GenericDAO.Condition> conditions = new ArrayList<>();
        try {
            conditions.add(GenericDAO.makeCondition("promo_code", GenericDAO.EQUALS, promoCode));
            return (PromoCode) GenericDAO.first(PromoCode.class, conditions);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
//        return promocode;
    }

}
