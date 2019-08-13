/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import commons.Common;
import commons.Helper;
import dao.GenericDAO;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import models.User;

/**
 * FXML Controller class
 *
 * @author Falak
 */
public class ResetPasswordController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    Label l1, l2;

    @FXML
    PasswordField pass, conpass;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        l1.setVisible(false);
        l2.setVisible(false);
    }

    public void reset() {
        if (!pass.getText().equals("")) {
            if (!conpass.getText().equals("")) {
                if (pass.getText().equals(conpass.getText())) {
                    List<GenericDAO.Condition> conditions = new ArrayList<>();
                    conditions.add(GenericDAO.makeCondition("user_id", GenericDAO.EQUALS, Common.TEMP_USER));
                    User user = (User) GenericDAO.first(User.class, conditions);
                    user.setPassword(Helper.encryptPassword(conpass.getText()));
                    GenericDAO.save(User.class, user);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Info");
                    alert.setHeaderText("");
                    alert.setContentText("Password has been reset.");

                    alert.showAndWait();
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Dialog");
                    alert.setHeaderText("");
                    alert.setContentText("Both Password should be same");

                    alert.showAndWait();

                }
            } else {
                l2.setVisible(true);
            }
        } else {
            l1.setVisible(true);
        }
    }
}
