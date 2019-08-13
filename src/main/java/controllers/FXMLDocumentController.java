/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import commons.Helper;
import dao.GenericDAO;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.User;

/**
 *
 * @author Falak
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label l1, l2;

    @FXML
    private TextField username, password;

    @FXML
    private void login() {
        if (!username.getText().equals("")) {
            l1.setVisible(false);
            
            
            if (!password.getText().equals("")) {
                l2.setVisible(false);
                try {
                    List<GenericDAO.Condition> conditions = new ArrayList<>();
                    conditions.add(GenericDAO.makeCondition("user_id", GenericDAO.EQUALS, username.getText()));
                    User user = (User) GenericDAO.first(User.class, conditions);
                    if (user.getPassword().equals(Helper.encryptPassword(password.getText()))) {
                        
                        commons.Common.LOGGED_IN_USERID = user.getUserId();
                        if (!user.isIsVerified()) {
                            Parent root1 = FXMLLoader.load(getClass().getResource("/fxml/VerifyUser.fxml"));
                            Stage stage = new Stage();
                            stage.setScene(new Scene(root1));
                            stage.show();
                            ((Stage) username.getScene().getWindow()).close();
                        } else {
                            Parent root1 = FXMLLoader.load(getClass().getResource("/fxml/Dashboard.fxml"));
                            Stage stage = new Stage();
                            stage.setScene(new Scene(root1));
                            stage.show();
                            ((Stage) username.getScene().getWindow()).close();
                        }
                    } else {
                        Alert alert = new Alert(AlertType.ERROR);
                        alert.setTitle("Error Dialog");
                        alert.setHeaderText(null);
                        alert.setContentText("Wrong username or password , please try again");
                        alert.showAndWait();
                    }
                } catch (Exception ex) {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Dialog");
                    alert.setHeaderText(null);
                    alert.setContentText("User does not exist");
                    alert.showAndWait();
                    ex.printStackTrace();
                }
            } else {
                l2.setVisible(true);
            }

        } else {

            l1.setVisible(true);
        }
    }

    @FXML
    private void register() {
        try {
            Parent root1 = FXMLLoader.load(getClass().getResource("/fxml/Registration.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
            ((Stage) username.getScene().getWindow()).close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        l1.setVisible(false);
        l2.setVisible(false);
    }

    @FXML
    private void exit() {
        Platform.exit();
    }
    @FXML
    private void forgotpassclick() {
    try {
            Parent root1 = FXMLLoader.load(getClass().getResource("/fxml/ForgotPassword.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
            ((Stage) username.getScene().getWindow()).close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
