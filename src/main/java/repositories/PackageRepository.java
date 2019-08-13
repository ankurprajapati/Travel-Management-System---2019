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
import models.Cart;
import models.Cart_Package;
import models.Packages;

/**
 *
 * @author Alex Christian
 */
public class PackageRepository {

    public static List<Packages> getAllPackages() {
        try {
            List<Packages> packages = new ArrayList<>();
            List<GenericDAO.Condition> conditions = new ArrayList<>();
            conditions.add(GenericDAO.makeCondition("available_packages", GenericDAO.GREATER_THAN_EQUALS, 1));
            for (Object o : GenericDAO.objects(Packages.class, conditions)) {
                packages.add((models.Packages) o);
            }
            if (packages.size() == 0) {
                return null;
            }
            return packages;
        } catch (Exception ex) {
            return null;
        }
    }

    public static boolean addToCart(Packages packagz) {
        try {
            Cart cart = CartRepository.getCart();
            System.out.println(cart);
            if (packagz.getAvailablePackages() > 0) {
                packagz.setAvailablePackages(packagz.getAvailablePackages() - 1);
                GenericDAO.save(Packages.class, packagz);
                GenericDAO.save(Cart_Package.class, new Cart_Package(cart.getCartId(), packagz.getPackageID()));
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static int addToCart(List<Packages> packages) {
        int counter = 0;
        for (Packages packagez : packages) {
            if (addToCart(packagez)) {
                counter++;
            }
        }
        return counter;
    }

}
