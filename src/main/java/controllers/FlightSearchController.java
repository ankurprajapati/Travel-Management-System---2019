/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import models.Flight;
import models.Flight_Search_Model;
import repositories.FlightRepository;

/**
 * FXML Controller class
 *
 * @author Falak
 */
public class FlightSearchController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private ComboBox departureCombo, arrivalCombo, travellers;

    @FXML
    private DatePicker dDatePicker, aDatePicker;

    @FXML
    private RadioButton economyClass, businessClass, firstClass;

    @FXML
    private CheckBox isRoundTrip;

    @FXML
    private TableColumn colFlightNumber, colDeparture, colDDate, colArrival, colArrivalDate, colTravellers, colPrice, colAddtoPrice;

    @FXML
    private TableView tblFlights;

    @FXML
    public void searchFlights() {
        String className = "";
        if (economyClass.isSelected()) {
            className = "economy";
        } else if (businessClass.isSelected()) {
            className = "business";
        } else {
            className = "first";
        }
        System.out.println(isRoundTrip.isSelected());
        List<Flight> flights = FlightRepository.getFlights(departureCombo.getValue().toString(), arrivalCombo.getValue().toString(), Date.from(dDatePicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()), Date.from(aDatePicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()), isRoundTrip.isSelected(), Integer.parseInt(travellers.getValue().toString()), className);
        //List<Flight> flights = FlightRepository.getFlights(Date.from(dDatePicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()), Date.from(aDatePicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        List<Flight_Search_Model> fsm = new ArrayList<>();
        for (final Flight flight : flights) {
            double price = 0;
            if (className.equals("economy")) {
                price = flight.getEconomyPrice();
            } else if (className.equals("business")) {
                price = flight.getBusinessClassPrice();
            } else {
                price = flight.getFirstClassPrice();
            }
            Flight_Search_Model fm = new Flight_Search_Model(flight.getFlightNumber(), flight.getDepartureIATACode(), flight.getArrivalIATACode(), flight.getDepartureDate(), flight.getArrivalDate(), Integer.parseInt(travellers.getValue().toString()), price, new Button("Add To Cart"));
            fm.getBook().setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (FlightRepository.addToCart(flight)) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Added to cart");
                        alert.setHeaderText(null);
                        alert.setContentText("This Flight is added to your cart");
                        alert.showAndWait();
                    } else {
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Error");
                        alert.setHeaderText(null);
                        alert.setContentText("Flight not available now");
                        alert.showAndWait();
                    }
                }
            });
            System.out.println(fm);
            fsm.add(fm);

        }
        ObservableList<Flight_Search_Model> flightData = FXCollections.observableArrayList(fsm);
        colFlightNumber.setCellValueFactory(new PropertyValueFactory<Flight_Search_Model, String>("flightNumber"));
        colDeparture.setCellValueFactory(new PropertyValueFactory<Flight_Search_Model, String>("departure"));
        colArrival.setCellValueFactory(new PropertyValueFactory<Flight_Search_Model, String>("arrival"));
        colDDate.setCellValueFactory(new PropertyValueFactory<Flight_Search_Model, String>("departureDate"));
        colArrivalDate.setCellValueFactory(new PropertyValueFactory<Flight_Search_Model, String>("arrivalDate"));
        colTravellers.setCellValueFactory(new PropertyValueFactory<Flight_Search_Model, String>("travellers"));
        colPrice.setCellValueFactory(new PropertyValueFactory<Flight_Search_Model, String>("price"));
        colAddtoPrice.setCellValueFactory(new PropertyValueFactory<Flight_Search_Model, String>("book"));
        tblFlights.getColumns().clear();
        tblFlights.setItems(flightData);
        tblFlights.getColumns().addAll(colFlightNumber, colDeparture, colArrival, colDDate, colArrivalDate, colTravellers, colPrice, colAddtoPrice);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        aDatePicker.setValue(LocalDate.now());
        dDatePicker.setValue(LocalDate.now());
        isRoundTrip.setSelected(false);
        
        ToggleGroup t=new ToggleGroup();
        economyClass.setToggleGroup(t);
         businessClass.setToggleGroup(t);
         firstClass.setToggleGroup(t);
         
    }

}
