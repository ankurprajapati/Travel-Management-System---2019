/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.print.Book;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Accordion;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import models.Packages;
import repositories.PackageRepository;

/**
 * FXML Controller class
 *
 * @author 13ale
 */
public class PackageBookingController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private GridPane grid;

    private void loadAccordion() {
        try {
            int i = 1;
            Accordion accordion;
            GridPane pane;
            List<Button> buttons = new ArrayList<>();
            for (final Packages packagez : PackageRepository.getAllPackages()) {
                accordion = new Accordion();
                pane = new GridPane();
                pane.add(new Label("Package Name : "), 0, 0);
                pane.add(new Label(packagez.getPackageName()), 1, 0);
                pane.add(new Label("Package ID : "), 0, 1);
                pane.add(new Label(packagez.getPackageID()), 1, 1);
                pane.add(new Label("Packages Days : "), 0, 2);
                pane.add(new Label(new Integer(packagez.getPackageDays()).toString()), 1, 2);
                pane.add(new Label("Package Price : "), 0, 3);
                pane.add(new Label(new Double(packagez.getPackagePrice()).toString()), 1, 3);
                pane.add(new Label("Packages Available : "), 0, 4);
                pane.add(new Label(new Integer(packagez.getAvailablePackages()).toString()), 1, 4);
                pane.add(new Label("Book Now : "), 0, 5);
                buttons.add(new Button("Book Now"));
                pane.add(buttons.get(i - 1), 1, 5);
                buttons.get(i - 1).setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        if (PackageRepository.addToCart(packagez)) {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Added to cart");
                            alert.setHeaderText(null);
                            alert.setContentText("This package is added to your cart");
                            alert.showAndWait();
                        } else {
                            Alert alert = new Alert(Alert.AlertType.WARNING);
                            alert.setTitle("Error");
                            alert.setHeaderText(null);
                            alert.setContentText("Package not available now");
                            alert.showAndWait();
                        }
                    }
                });
                accordion.getPanes().add(new TitledPane("Package " + i, pane));
                grid.add(accordion, 0, i);
                i++;
            }
        } catch (Exception ex) {
            grid.add(new Label("No Packages Available Right Now.. Please Come Later.."), 6, 0);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadAccordion();
    }

}
