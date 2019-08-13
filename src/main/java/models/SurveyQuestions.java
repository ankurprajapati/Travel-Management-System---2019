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
@MapToTable("SurveyQuestion")
public class SurveyQuestions implements Serializable{
    @PrimaryKey("question_id")
    @MapToColumn("question_id")
    private String questionId;
    @MapToColumn("question")
    private String question;

    public SurveyQuestions() {
    }
    
    public SurveyQuestions(String questionId, String question) {
        this.questionId = questionId;
        this.question = question;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "SurveyQuestions{" + "questionId=" + questionId + ", question=" + question + '}';
    }
}
