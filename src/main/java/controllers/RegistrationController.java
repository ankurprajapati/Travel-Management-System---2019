/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import commons.Helper;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import repositories.UserRepository;

/**
 * FXML Controller class
 *
 * @author 13ale
 */
public class RegistrationController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField fname, lname, email, phone, password, confirmpassword;
    @FXML
    private DatePicker datepicker;
    @FXML
    private Hyperlink hyperlink;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        datepicker.setValue(LocalDate.now());
    }

    @FXML
    public void openLoginPage() {
        try {
            Parent root1 = FXMLLoader.load(getClass().getResource("/fxml/FXMLDocument.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
            ((Stage) hyperlink.getScene().getWindow()).close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void registerUser() {
        String vercode = Helper.generateVerificationCode();
        if (fname.getText().equals("") || lname.getText().equals("") || email.getText().equals("") || phone.getText().equals("") || password.getText().equals("")) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Details Missing");
            alert.setContentText("All details are required");
            alert.showAndWait();
        } else if (!(email.getText().matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$"))) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Details Inappropriate");
            alert.setContentText("Email is not valid");
            alert.showAndWait();
        } else if (!(phone.getText().matches("^\\s?((\\+[1-9]{1,4}[ \\-]*)|(\\([0-9]{2,3}\\)[ \\-]*)|([0-9]{2,4})[ \\-]*)*?[0-9]{3,4}?[ \\-]*[0-9]{3,4}?\\s?"))) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Details Inappropriate");
            alert.setContentText("Phone Number is not valid");
            alert.showAndWait();
        } else if (password.getText().length() < 8) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Details Inappropriate");
            alert.setContentText("Password Length Should Be Greater Than 8");
            alert.showAndWait();
        } else if (!password.getText().equals(confirmpassword.getText())) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Password Doesnt Match");
            alert.setContentText("Please Check The Passwords They Do not Match");
            alert.showAndWait();
        } else {
            if (UserRepository.registerOrUpdateUser(fname.getText(), lname.getText(), Date.from(datepicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()), email.getText(), phone.getText(), Helper.encryptPassword(password.getText()), vercode)) {
                Helper.sendVerificationEmail(email.getText(), vercode);
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Registered Successfully");
                alert.setContentText("You are registered successfully, a verification mail has been sent to your email.");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("User Exists");
                alert.setContentText("User Already Exists Please Login..");
                alert.showAndWait();
            }
        }
    }

}
