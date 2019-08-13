/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

//import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author 13ale
 */
public class DashboardController implements Initializable {

    @FXML
    private MenuItem menuitem11;

    @FXML
    private MenuItem menuitem12;

    @FXML
    private MenuItem menuitem21;

    @FXML
    private MenuItem menuitem22;

    @FXML
    private MenuItem menuitem23;

    @FXML
    private MenuItem menuitem24;

    @FXML
    private MenuItem menuitem25;

    @FXML
    private MenuItem menuitem31;

    @FXML
    private MenuItem menuitem32;

    @FXML
    private ImageView imageview1;

    @FXML
    private ImageView imageview2;

    @FXML
    private ImageView imageview3;

    @FXML
    private ImageView imageview4;

    @FXML
    private ImageView imageview5;

    @FXML
    private ImageView imageview6;

    @FXML
    private void handleButtonAction(ActionEvent event) {

        System.exit(0);
    }

    @FXML
    private void myCartAction(ActionEvent evt) throws IOException {
        try {

            Parent root1 = FXMLLoader.load(getClass().getResource("/fxml/Cart.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void flightSearch() {
        try {

            Parent root1 = FXMLLoader.load(getClass().getResource("/fxml/FlightSearch.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void myOrdersAction(ActionEvent evt) throws IOException {
        try {

            Parent root1 = FXMLLoader.load(getClass().getResource("/fxml/MYORDER.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void surveyAction(ActionEvent evt) throws IOException {
        try {

            Parent root1 = FXMLLoader.load(getClass().getResource("/fxml/Survey.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void packageBooking() {
        try {

            Parent root1 = FXMLLoader.load(getClass().getResource("/fxml/PackageBooking.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void aboutUsAction(ActionEvent evt) throws IOException {
        try {

            Parent root1 = FXMLLoader.load(getClass().getResource("/fxml/Aboutus.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void faqAction(ActionEvent evt) throws IOException {
        try {

            Parent root1 = FXMLLoader.load(getClass().getResource("/fxml/WorldTravelNews.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        imageview1.setImage(new Image(getClass().getResource("/images/test.png").toString()));
        imageview1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {

                    Parent root1 = FXMLLoader.load(getClass().getResource("/fxml/PackageBooking.fxml"));
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root1));
                    stage.show();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        imageview2.setImage(new Image(getClass().getResource("/images/test.png").toString()));
        imageview2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {

                    Parent root1 = FXMLLoader.load(getClass().getResource("/fxml/PackageBooking.fxml"));
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root1));
                    stage.show();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        imageview3.setImage(new Image(getClass().getResource("/images/test.png").toString()));
        imageview3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {

                    Parent root1 = FXMLLoader.load(getClass().getResource("/fxml/PackageBooking.fxml"));
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root1));
                    stage.show();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        imageview4.setImage(new Image(getClass().getResource("/images/test.png").toString()));
        imageview4.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {

                    Parent root1 = FXMLLoader.load(getClass().getResource("/fxml/PackageBooking.fxml"));
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root1));
                    stage.show();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        imageview5.setImage(new Image(getClass().getResource("/images/test.png").toString()));
        imageview5.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {

                    Parent root1 = FXMLLoader.load(getClass().getResource("/fxml/PackageBooking.fxml"));
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root1));
                    stage.show();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        imageview6.setImage(new Image(getClass().getResource("/images/test.png").toString()));
        imageview6.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {

                    Parent root1 = FXMLLoader.load(getClass().getResource("/fxml/PackageBooking.fxml"));
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root1));
                    stage.show();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
