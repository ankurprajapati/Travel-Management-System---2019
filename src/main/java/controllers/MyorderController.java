/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import commons.Common;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Orders_Packages;
import models.Packages;
import repositories.MyorderRepository;

/**
 * FXML Controller class
 *
 * @author ankur
 */
public class MyorderController implements Initializable {

    @FXML
    private TitledPane titledPaneFlights;
    @FXML
    private TitledPane titledPanePackage;
    @FXML
    private Label lblTotal;
    @FXML
    private TextField txtTotal;
    @FXML
    private TableView tblFlights;
    @FXML
    private TableView tblPackage;
    @FXML
    private TableColumn colFlight;
    @FXML
    private TableColumn colDeparture;
    @FXML
    private TableColumn colArrival;
    @FXML
    private TableColumn colDepartureTime;
    @FXML
    private TableColumn colArrivalTime;
    @FXML
    private TableColumn colTotal;
    @FXML
    private TableColumn colRemove;
    @FXML
    private TableColumn colPackageName;
    @FXML
    private TableColumn colPackageDays;
    @FXML
    private TableColumn colPackageTotal;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try
        {
            bindData();
        }
        catch(Exception ex)
        {
            Logger.getLogger(MyorderController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    public void bindData() throws Exception {
        //To change body of generated methods, choose Tools | Templates.
        try
        {
            double total = 0.0;
            List<Packages> orderPackages = MyorderRepository.getOrderPackages(Common.LOGGED_IN_USERID);
            if(!orderPackages.isEmpty()){
                for(Packages orderPackage : orderPackages){
                    total += orderPackage.getPackagePrice();
                }
                ObservableList<Packages> packageData = FXCollections.observableArrayList(orderPackages);
                colPackageName.setCellValueFactory(new PropertyValueFactory<Orders_Packages, String>("packageName"));
                colPackageDays.setCellValueFactory(new PropertyValueFactory<Orders_Packages, String>("packageDays"));
                colPackageTotal.setCellValueFactory(new PropertyValueFactory<Orders_Packages, String>("packagePrice"));
                
                tblPackage.setItems(packageData);
                tblPackage.getColumns().addAll(colPackageName, colPackageDays, colPackageTotal);
                txtTotal.setText(Double.toString(total));
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
}
