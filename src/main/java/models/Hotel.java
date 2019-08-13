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
@MapToTable("Hotel")
public class Hotel implements Serializable{
    @PrimaryKey("hotel_id")
    @MapToColumn("hotel_id")
    private String hotelId;
    @MapToColumn("hotel_name")
    private String hotelName;
    @MapToColumn("hotel_rating")
    private String hotelRating;
    @MapToColumn("hotel_address")
    private String hotelAddress;
    @MapToColumn("isRoomAvailable")
    private boolean isRoomAvailable;
    @MapToColumn("single_bed_room")
    private int singleBedRoom;
    @MapToColumn("double_bed_room")
    private int doubleBedRoom;
    @MapToColumn("deluxe_room")
    private int deluxRoom;
    @MapToColumn("suite")
    private int suite;
    @MapToColumn("isWifiEnabled")
    private boolean isWifiEnabled;
    @MapToColumn("isAirConditioned")
    private boolean isAirConditioned;
    @MapToColumn("hasRestaurant")
    private boolean hasRestaurant;
    @MapToColumn("hasSwimingPool")
    private boolean hasSwimingPool;

    public Hotel() {
    }
    
    public Hotel(String hotelId, String hotelName, String hotelRating, String hotelAddress, boolean isRoomAvailable, int singleBedRoom, int doubleBedRoom, int deluxRoom, int suite, boolean isWifiEnabled, boolean isAirConditioned, boolean hasRestaurant, boolean hasSwimingPool) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.hotelRating = hotelRating;
        this.hotelAddress = hotelAddress;
        this.isRoomAvailable = isRoomAvailable;
        this.singleBedRoom = singleBedRoom;
        this.doubleBedRoom = doubleBedRoom;
        this.deluxRoom = deluxRoom;
        this.suite = suite;
        this.isWifiEnabled = isWifiEnabled;
        this.isAirConditioned = isAirConditioned;
        this.hasRestaurant = hasRestaurant;
        this.hasSwimingPool = hasSwimingPool;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelRating() {
        return hotelRating;
    }

    public void setHotelRating(String hotelRating) {
        this.hotelRating = hotelRating;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public boolean isIsRoomAvailable() {
        return isRoomAvailable;
    }

    public void setIsRoomAvailable(boolean isRoomAvailable) {
        this.isRoomAvailable = isRoomAvailable;
    }

    public int getSingleBedRoom() {
        return singleBedRoom;
    }

    public void setSingleBedRoom(int singleBedRoom) {
        this.singleBedRoom = singleBedRoom;
    }

    public int getDoubleBedRoom() {
        return doubleBedRoom;
    }

    public void setDoubleBedRoom(int doubleBedRoom) {
        this.doubleBedRoom = doubleBedRoom;
    }

    public int getDeluxRoom() {
        return deluxRoom;
    }

    public void setDeluxRoom(int deluxRoom) {
        this.deluxRoom = deluxRoom;
    }

    public int getSuite() {
        return suite;
    }

    public void setSuite(int suite) {
        this.suite = suite;
    }

    public boolean isIsWifiEnabled() {
        return isWifiEnabled;
    }

    public void setIsWifiEnabled(boolean isWifiEnabled) {
        this.isWifiEnabled = isWifiEnabled;
    }

    public boolean isIsAirConditioned() {
        return isAirConditioned;
    }

    public void setIsAirConditioned(boolean isAirConditioned) {
        this.isAirConditioned = isAirConditioned;
    }

    public boolean isHasRestaurant() {
        return hasRestaurant;
    }

    public void setHasRestaurant(boolean hasRestaurant) {
        this.hasRestaurant = hasRestaurant;
    }

    public boolean isHasSwimingPool() {
        return hasSwimingPool;
    }

    public void setHasSwimingPool(boolean hasSwimingPool) {
        this.hasSwimingPool = hasSwimingPool;
    }

    @Override
    public String toString() {
        return "Hotel{" + "hotelId=" + hotelId + ", hotelName=" + hotelName +
                ", hotelRating=" + hotelRating + ", hotelAddress=" + hotelAddress +
                ", isRoomAvailable=" + isRoomAvailable + 
                ", singleBedRoom=" + singleBedRoom + 
                ", doubleBedRoom=" + doubleBedRoom + 
                ", deluxRoom=" + deluxRoom + 
                ", suite=" + suite + 
                ", isWifiEnabled=" + isWifiEnabled + 
                ", isAirConditioned=" + isAirConditioned + 
                ", hasRestaurant=" + hasRestaurant + 
                ", hasSwimingPool=" + hasSwimingPool + '}';
    }
}
