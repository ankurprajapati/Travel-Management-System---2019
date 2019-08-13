/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commons;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Alex Christian
 */
public class Common {

    private Common() {
    }
    /////////////////////////
    //ENVIRONMENT VARIABLES//
    /////////////////////////

    //GENERAL VARIABLES
    public final static String APP_VERSION = "1.0";
    public final static boolean VERBOSE = true;
    //DATABASE
    public final static String DATABASE = "tms_new";
    public final static String DRIVER_CLASS = "com.mysql.jdbc.Driver";
    public final static String DB_USERNAME = "alex";
    public final static String DB_PASSWORD = "alexevan";
    public final static String DB_HOST = "dev.whattha.app";
    public final static String DB_PORT = "3306";
    public final static boolean IS_DB_AUTH_ENABLED = true;
    public final static String DB_DRIVER_TECHNOLOGY = "jdbc";
    public final static String DB_TECHNOLOGY = "mysql";
    public final static String DB_URL = DB_DRIVER_TECHNOLOGY + ":" + DB_TECHNOLOGY + "://" + DB_HOST + ":" + DB_PORT + "/" + DATABASE;
    //ORM CONFIGS
    public final static boolean SHOW_SQL = true;
    //SECURITY CONFIGS
    public final static String AES_KEY = "Bar12345Bar12345";
    //EMAIL CONFIGS
    public final static String EMAIL_USERNAME = "plutomen2018";
    public final static String EMAIL_FROM = "plutomen2018@gmail.com";
    public final static String EMAIL_PASSWORD = "alexevan";
    
    public static String LOGGED_IN_USERID="";
    public static String TEMP_USER="";
    public static double CART_TOTAL_BEFORE_PROMO;
    public static double CART_TOTAL_AFTER_PROMO;
    //public static double PACKAGE_PRICE;
   
}

