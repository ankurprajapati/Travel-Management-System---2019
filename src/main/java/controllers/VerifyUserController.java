/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.GenericDAO;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.User;

/**
 * FXML Controller class
 *
 * @author Falak
 */
public class VerifyUserController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    @FXML
    TextField vercode;

    @FXML
    public void verify() {
        try {
            List<GenericDAO.Condition> conditions = new ArrayList<>();
            conditions.add(GenericDAO.makeCondition("user_id", GenericDAO.EQUALS, commons.Common.LOGGED_IN_USERID));
            User user = (User) GenericDAO.first(User.class, conditions);
            if (vercode.getText().equals(user.getVercode())) {
                
                user.setIsVerified(true);
                GenericDAO.save(User.class, user);
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Thank you for verifying yourself.");
                alert.showAndWait();
                

                Parent root1 = FXMLLoader.load(getClass().getResource("/fxml/Dashboard.fxml"));
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();
                ((Stage) vercode.getScene().getWindow()).close();
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("null");
                alert.setContentText("Wrong Verification code . Please try again");

                alert.showAndWait();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
