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
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import models.Survey;
import models.SurveyQuestions;

/**
 * FXML Controller class
 *
 * @author Falak
 */
public class SurveyController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Label q1, q2, q3, q4, q5;

    @FXML
    private RadioButton q1r1, q1r2, q1r3, q1r4, q1r5;

    @FXML
    private RadioButton q2r1, q2r2, q2r3, q2r4, q2r5;
    @FXML
    private RadioButton q3r1, q3r2, q3r3, q3r4, q3r5;
    @FXML
    private RadioButton q4r1, q4r2, q4r3, q4r4, q4r5;
    @FXML
    private RadioButton q5r1, q5r2, q5r3, q5r4, q5r5;

    ToggleGroup group1, group2, group3, group4, group5;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        group1 = new ToggleGroup();
        group2 = new ToggleGroup();
        group3 = new ToggleGroup();
        group4 = new ToggleGroup();
        group5 = new ToggleGroup();
        
        q1r3.setSelected(true);
        q2r3.setSelected(true);
        q3r3.setSelected(true);
        q4r3.setSelected(true);
        q5r3.setSelected(true);
        
        
        RadioButton[] buttons = new RadioButton[]{q1r1, q1r2, q1r3, q1r4, q1r5,
            q2r1, q2r2, q2r3, q2r4, q2r5,
            q3r1, q3r2, q3r3, q3r4, q3r5,
            q4r1, q4r2, q4r3, q4r4, q4r5,
            q5r1, q5r2, q5r3, q5r4, q5r5};
        for (int i = 0; i < buttons.length; i++) {
            if (i < 5) {
                buttons[i].setToggleGroup(group1);
            } else if (i < 10) {
                buttons[i].setToggleGroup(group2);
            } else if (i < 15) {
                buttons[i].setToggleGroup(group3);
            } else if (i < 20) {
                buttons[i].setToggleGroup(group4);
            } else {
                buttons[i].setToggleGroup(group5);
            }
        }
        //Toggle btn = group1.getSelectedToggle();
        //System.out.println(btn.getUserData());

        Label[] labels = new Label[]{q1, q2, q3, q4, q5};
        // TODO

        try {
            List<Object> questions = GenericDAO.objects(SurveyQuestions.class);
            int i = 0;
            for (Object question : questions) {
                SurveyQuestions q = (SurveyQuestions) question;
                labels[i].setText(q.getQuestion());
                if (i == 5) {
                    break;
                }
                i++;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @FXML
    public void submit() {
        int total = 0;

        RadioButton selectedRadioButton1 = (RadioButton) group1.getSelectedToggle();
        String toogleGroupValue1 = selectedRadioButton1.getText();
        RadioButton selectedRadioButton2 = (RadioButton) group2.getSelectedToggle();
        String toogleGroupValue2 = selectedRadioButton2.getText();
        RadioButton selectedRadioButton3 = (RadioButton) group3.getSelectedToggle();
        String toogleGroupValue3 = selectedRadioButton3.getText();
        RadioButton selectedRadioButton4 = (RadioButton) group4.getSelectedToggle();
        String toogleGroupValue4 = selectedRadioButton4.getText();
        RadioButton selectedRadioButton5 = (RadioButton) group5.getSelectedToggle();
        String toogleGroupValue5 = selectedRadioButton5.getText();

        total += getWeight(toogleGroupValue1);
        total += getWeight(toogleGroupValue2);
        total += getWeight(toogleGroupValue3);
        total += getWeight(toogleGroupValue4);
        total += getWeight(toogleGroupValue5);
        total /= 5;

        String surveyID = "SRV" + Helper.generateRandomNumber();
        GenericDAO.save(Survey.class, new Survey(surveyID, Common.LOGGED_IN_USERID, total));
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Thank you for taking this survey.Your feedback is valuable to us.");

        
        alert.showAndWait();
        ((Stage) q1.getScene().getWindow()).close();
    }

    private int getWeight(String d) {
        if (d.equalsIgnoreCase("strongly agree")) {
            return 100;
        }
        if (d.equalsIgnoreCase("agree")) {
            return 50;
        }
        if (d.equalsIgnoreCase("neutral")) {
            return 0;
        }
        if (d.equalsIgnoreCase("disagree")) {
            return -50;
        }
        if (d.equalsIgnoreCase("strongly disagree")) {
            return -100;
        }
        return 0;
    }
    @FXML
    public void close() {
        ((Stage) q1.getScene().getWindow()).close();
    }
}
