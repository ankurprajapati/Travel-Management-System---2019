/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author ankur
 */
public class WorldTravelNewsController implements Initializable {

    @FXML
    //FXML Components 
    public TableView tabelview;
    public TableColumn<String,String> travelNews;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try{
            System.out.println(readrss(""));
            System.out.println("Try RSS");
            //travelNews.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue())); 
            travelNews.setCellValueFactory(new PropertyValueFactory<String,String>("cellData"));
            
            //travelNews.setCellValueFactory(value);
            tabelview.setItems(getNews("http://rss.cnn.com/rss/cnn_travel.rss"));
        }
        catch(IOException ex){
            System.out.println("io");
        }
    }

    public static String readrss(String urlAddress){
        try {
            //URL Class From Java.net 
            URL rssUrl = new URL(urlAddress);
            //Read Data using InputStreamReader for Specified rssURL
            BufferedReader in = new BufferedReader(new InputStreamReader(rssUrl.openStream()));
            //To print RSS Feed  
            String sourceCode = "";
            //To read each line of RSS Feed
            String line; 
            
            //Read line from BufferReader Object using readLine Method until its null
            while((line = in.readLine()) != null){
                //Starting from <title> tag
                if(line.contains("<title>")){
                    //get First <title> tag position
                    int firstPos = line.indexOf("<title>");
                    //get feed after <title> tag using substring  
                    String temp = line.substring(firstPos);
                    temp = temp.replace("<title>", "");
                    int lastPos = temp.indexOf("</title>");
                    //get the feed till last </title> tag
                    temp = temp.substring(9,lastPos-3);
                    sourceCode += temp + "\n";
                }
            }
            in.close();
            return sourceCode;
        } catch (MalformedURLException ue) {
            //URL is not good or not reliable URL 
            System.out.println("Malformed URL");
        }
        catch(IOException ioe){
            //If not able to open RSS Feed
            System.out.println("Something went wrong reading the contents");
        }
        return null;
    }

     private ObservableList<String> getNews(String travelrss) throws IOException {
         //Use of ObservableList of type String with object news
        ObservableList<String> news = FXCollections.observableArrayList();
        //call for readrss with url
        String data = readrss(travelrss);
        
        BufferedReader bufReader = new BufferedReader(new StringReader(data));
        String line = null;
        //add line to news ObservableList to print feed 
        for(int i=0;i<30;i++){
            if((line=bufReader.readLine()) != null){
                news.add(line);
            }
        }
        return news;
    }
    
}
