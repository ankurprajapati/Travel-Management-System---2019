/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author ankur
 */
public class AboutusController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    ImageView alexImage, ankurImage, gargiImage, falakImage;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // adding images to ImageView using fxID 
        //Images are stored in image package
        alexImage.setImage(new Image(getClass().getResourceAsStream("/images/alex.JPG")));
        ankurImage.setImage(new Image(getClass().getResourceAsStream("/images/Ankur.png")));
        ankurImage.setFitWidth(230);
        ankurImage.setFitHeight(200);
        gargiImage.setImage(new Image(getClass().getResourceAsStream("/images/Gargi.PNG")));
        falakImage.setImage(new Image(getClass().getResourceAsStream("/images/falak_1.PNG")));
    }    
    
}
