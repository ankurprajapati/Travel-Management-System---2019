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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.User;

/**
 * FXML Controller class
 *
 * @author Falak
 */
public class ForgotPasswordController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        l1.setVisible(false);
        l2.setVisible(false);
    }  
    @FXML
    private Label l1, l2;
    @FXML
    TextField username,code;
    @FXML
    public void sendEmail() {
        if (!username.getText().equals("")) {
            
        String vercode = Helper.generateVerificationCode();
            Helper.sendVerificationEmail(username.getText(), vercode);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("confirmation");
                alert.setContentText("Verification code has been sent.");
                alert.showAndWait();
        List<GenericDAO.Condition> conditions = new ArrayList<>();
            conditions.add(GenericDAO.makeCondition("user_id", GenericDAO.EQUALS, username.getText()));
            User user = (User) GenericDAO.first(User.class, conditions);
            user.setVercode(vercode);
            GenericDAO.save(User.class, user);
            
            
        }
        else{
        l1.setVisible(true);
        }
        
    }
    @FXML
    public void verify() {
        if(!code.getText().equals("")){
        try {
            List<GenericDAO.Condition> conditions = new ArrayList<>();
            conditions.add(GenericDAO.makeCondition("user_id", GenericDAO.EQUALS, username.getText()));
            User user = (User) GenericDAO.first(User.class, conditions);
            if (code.getText().equals(user.getVercode())) {
                
                user.setIsVerified(true);
                GenericDAO.save(User.class, user);
                Common.TEMP_USER=username.getText();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Thank you for verifying yourself.");
                alert.showAndWait();
                

                Parent root1 = FXMLLoader.load(getClass().getResource("/fxml/ResetPassword.fxml"));
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();
                ((Stage) code.getScene().getWindow()).close();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("null");
                alert.setContentText("Wrong Verification code . Please try again");

                alert.showAndWait();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        }
        else{
            l2.setVisible(true);
            }
    }
}
