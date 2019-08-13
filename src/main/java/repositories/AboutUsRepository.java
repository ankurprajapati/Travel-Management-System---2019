/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Falak
 */
public class AboutUsRepository {
    
    public static Map<String,Map<String,String>> getInformation(){
    
    Map<String,Map<String,String>> information=new HashMap<>();
    Map<String,String> teamMembers=new HashMap<>();
    
    teamMembers.put("Student ID","N01324334");
    teamMembers.put("College","Humber College-North Campus");
    teamMembers.put("Email ID","n01324334@humbermail.ca");
    teamMembers.put("Image","FalakPandya.jpeg");
    
    
    information.put("Falak Pandya",teamMembers);
    
    teamMembers=new HashMap<>();
    teamMembers.put("Student ID","N01317100");
    teamMembers.put("College","Humber College-North Campus");
    teamMembers.put("Email ID","n01317100@humbermail.ca");
    teamMembers.put("Image","AlexEvan.jpeg");
    
    
    information.put("Alex Chritian",teamMembers);
    
    teamMembers=new HashMap<>();
    teamMembers.put("Student ID","N01317100");
    teamMembers.put("College","Humber College-North Campus");
    teamMembers.put("Email ID","n01317100@humbermail.ca");
    teamMembers.put("Image","AlexEvan.jpeg");
    
    
    information.put("Alex Chritian",teamMembers);
    
    teamMembers=new HashMap<>();
    teamMembers.put("Student ID","N01317100");
    teamMembers.put("College","Humber College-North Campus");
    teamMembers.put("Email ID","n01317100@humbermail.ca");
    teamMembers.put("Image","AlexEvan.jpeg");
    
    
    information.put("Alex Chritian",teamMembers);
    
    
    return information;
    }
    
}
