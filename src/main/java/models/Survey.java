/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import alexevan.annotations.MapToColumn;
import alexevan.annotations.MapToTable;
import alexevan.annotations.PrimaryKey;
import java.io.Serializable;

/**
 *
 * @author Alex Christian
 */
@MapToTable("Survey")
public class Survey implements Serializable{
    @PrimaryKey("survey_id")
    @MapToColumn("survey_id")
    private String surveyID;
    @MapToColumn("client_user_id")
    private String userID;
    @MapToColumn("strongly_disagree")
    private boolean stronglyDisagree;
    @MapToColumn("disagree")
    private boolean disagree;
    @MapToColumn("neutral")
    private boolean neutral;
    @MapToColumn("agree")
    private boolean agree;
    @MapToColumn("strongly_agree")
    private boolean stronglyAgree;

    public Survey() {
    }
    public Survey(String surveyID,String userID,int total){
    this.surveyID = surveyID;
    this.userID=userID;
    if(total<=50 && total>0){
        this.agree=true;
        this.disagree=false;
        this.neutral=false;
        this.stronglyAgree=false;
        this.stronglyDisagree=false;
    }
    else if(total==0 ){
        this.agree=false;
        this.disagree=false;
        this.neutral=true;
        this.stronglyAgree=false;
        this.stronglyDisagree=false;
    }
    else if( total>50  ){
        this.agree=false;
        this.disagree=false;
        this.neutral=false;
        this.stronglyAgree=true;
        this.stronglyDisagree=false;
    }
    else if(total>=-50 && total<0){
        this.agree=false;
        this.disagree=true;
        this.neutral=false;
        this.stronglyAgree=false;
        this.stronglyDisagree=false;
    }
    else if(total<-50 ){
        this.agree=false;
        this.disagree=false;
        this.neutral=false;
        this.stronglyAgree=false;
        this.stronglyDisagree=true;
    }
    
    
    }
    
    public Survey(String surveyID, String userID, boolean stronglyDisagree, boolean disagree, boolean neutral, boolean agree, boolean stronglyAgree) {
        this.surveyID = surveyID;
        this.userID = userID;
        this.stronglyDisagree = stronglyDisagree;
        this.disagree = disagree;
        this.neutral = neutral;
        this.agree = agree;
        this.stronglyAgree = stronglyAgree;
    }

    public String getSurveyID() {
        return surveyID;
    }

    public void setSurveyID(String surveyID) {
        this.surveyID = surveyID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public boolean isStronglyDisagree() {
        return stronglyDisagree;
    }

    public void setStronglyDisagree(boolean stronglyDisagree) {
        this.stronglyDisagree = stronglyDisagree;
    }

    public boolean isDisagree() {
        return disagree;
    }

    public void setDisagree(boolean disagree) {
        this.disagree = disagree;
    }

    public boolean isNeutral() {
        return neutral;
    }

    public void setNeutral(boolean neutral) {
        this.neutral = neutral;
    }

    public boolean isAgree() {
        return agree;
    }

    public void setAgree(boolean agree) {
        this.agree = agree;
    }

    public boolean isStronglyAgree() {
        return stronglyAgree;
    }

    public void setStronglyAgree(boolean stronglyAgree) {
        this.stronglyAgree = stronglyAgree;
    }

    @Override
    public String toString() {
        return "Survey{" + "surveyID=" + surveyID + 
                ", userID=" + userID + 
                ", stronglyDisagree=" + stronglyDisagree + 
                ", disagree=" + disagree + 
                ", neutral=" + neutral + 
                ", agree=" + agree + 
                ", stronglyAgree=" + stronglyAgree + '}';
    }
    
}
