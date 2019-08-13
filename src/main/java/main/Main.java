/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import commons.Helper;
import dao.Database;
import dao.GenericDAO;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import models.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Alex Christian
 */
public class Main extends Application {

    static {
        GenericDAO.addAnnotatedClass(Aircraft.class);
        GenericDAO.addAnnotatedClass(Airline.class);
        GenericDAO.addAnnotatedClass(Airline_Aircraft.class);
        GenericDAO.addAnnotatedClass(Cart.class);
        GenericDAO.addAnnotatedClass(Cart_Flight.class);
        GenericDAO.addAnnotatedClass(Cart_Package.class);
        //GenericDAO.addAnnotatedClass(FAQ.class);
        GenericDAO.addAnnotatedClass(Flight.class);
        GenericDAO.addAnnotatedClass(Hotel.class);
        GenericDAO.addAnnotatedClass(IATA.class);
        GenericDAO.addAnnotatedClass(Orders.class);
        GenericDAO.addAnnotatedClass(Orders_Packages.class);
        GenericDAO.addAnnotatedClass(Packages.class);
        GenericDAO.addAnnotatedClass(Packages_Flights.class);
        GenericDAO.addAnnotatedClass(PromoCode.class);
        GenericDAO.addAnnotatedClass(Survey.class);
        GenericDAO.addAnnotatedClass(SurveyQuestions.class);
        GenericDAO.addAnnotatedClass(Ticket.class);
        GenericDAO.addAnnotatedClass(Ticket_Flights.class);
        GenericDAO.addAnnotatedClass(User.class);
        GenericDAO.addAnnotatedClass(Aircraft.class);
        GenericDAO.generateMappings();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/FXMLDocument.fxml"));

        Scene scene = new Scene(root);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        launch(args);
        
        System.exit(0);
    }
}
