/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import commons.Common;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Alex Christian
 */
public class Database {

    public static Connection connection = null;

    private Database() {
    }
    //PROVIDES SINGLETON OBJECT OF CONNECTION
    public final static Connection getConnection() {
        try {
            if (connection == null) {
                Class.forName(Common.DRIVER_CLASS);
                connection = DriverManager.getConnection(Common.DB_URL, Common.DB_USERNAME, Common.DB_PASSWORD);
            }
            return connection;
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;

    }
}
