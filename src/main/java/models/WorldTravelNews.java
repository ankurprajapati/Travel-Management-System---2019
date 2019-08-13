/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import alexevan.annotations.MapToColumn;
import alexevan.annotations.MapToTable;
import alexevan.annotations.PrimaryKey;

/**
 *
 * @author ankur
 */
@MapToTable("WorldTravelNews")
public class WorldTravelNews {
    @PrimaryKey("srNo")
    @MapToColumn("srNo")
    private int srNo;
    @MapToColumn("travelNews")
    private String travelNews;  

    public WorldTravelNews() {
    }
    
    public WorldTravelNews(int srNo, String travelNews) {
        this.srNo = srNo;
        this.travelNews = travelNews;
    }
    
    public int getSrNo() {
        return srNo;
    }

    public void setSrNo(int srNo) {
        this.srNo = srNo;
    }

    public String getTravelNews() {
        return travelNews;
    }

    public void setTravelNews(String travelNews) {
        this.travelNews = travelNews;
    }

    @Override
    public String toString() {
        return "WorldTravelNews{" + "srNo=" + srNo + ", travelNews=" + travelNews + '}';
    } 
}
