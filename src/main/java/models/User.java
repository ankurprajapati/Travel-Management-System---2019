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
import java.util.Date;

/**
 *
 * @author Alex Christian
 */
@MapToTable("User")
public class User implements Serializable {

    @PrimaryKey("user_id")
    @MapToColumn("user_id")
    private String userId;
    @MapToColumn("email")
    private String email;
    @MapToColumn("mobile_number")
    private String mobileNumber;
    @MapToColumn("password")
    private String password;
    @MapToColumn("family_name")
    private String familyName;
    @MapToColumn("given_name")
    private String givenName;
    @MapToColumn("isAdmin")
    private boolean isAdmin;
    @MapToColumn("isVerified")
    private boolean isVerified;
    @MapToColumn("passport_number")
    private String passportnumber;
    @MapToColumn("passport_expiry_date")
    private Date passportExpiryDate;
    @MapToColumn("passport_start_date")
    private Date passportStartDate;
    @MapToColumn("birth_date")
    private Date birthDate;
    @MapToColumn("address")
    private String address;
    @MapToColumn("verify_code")
    private String vercode;

    public User() {
    }

    public User(String userId, String email, String mobileNumber, String password, String familyName, String givenName, boolean isAdmin, String vercode) {
        this.userId = userId;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.password = password;
        this.familyName = familyName;
        this.givenName = givenName;
        this.isAdmin = isAdmin;
        this.vercode = vercode;
    }

    public User(String userId, String email, String mobileNumber, String password, String familyName, String givenName, boolean isAdmin, String vercode, String address, String passportNo, Date passportExpDate) {
        this.userId = userId;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.password = password;
        this.familyName = familyName;
        this.givenName = givenName;
        this.isAdmin = isAdmin;
        this.vercode = vercode;
        this.address = address;
        this.passportnumber = passportNo;
        this.passportExpiryDate = passportExpDate;
        this.isVerified = true;
    }

    public String getVercode() {
        return vercode;
    }
    public void setVercode(String v) {
        this.vercode=v;
    }

    public String getPassportnumber() {
        return passportnumber;
    }

    public void setPassportnumber(String passportnumber) {
        this.passportnumber = passportnumber;
    }

    public Date getPassportExpiryDate() {
        return passportExpiryDate;
    }

    public void setPassportExpiryDate(Date passportExpiryDate) {
        this.passportExpiryDate = passportExpiryDate;
    }

    public Date getPassportStartDate() {
        return passportStartDate;
    }

    public void setPassportStartDate(Date passportStartDate) {
        this.passportStartDate = passportStartDate;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isIsVerified() {
        return isVerified;
    }

    public void setIsVerified(boolean isVerified) {
        this.isVerified = isVerified;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public boolean isIsAgent() {
        return isAdmin;
    }

    public void setIsAgent(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    
    
    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", email=" + email
                + ", mobileNumber=" + mobileNumber + ", password=" + password
                + ", familyName=" + familyName + ", givenName=" + givenName
                + ", isAdmin=" + isAdmin + ", isVerified=" + isVerified
                + ", passportnumber=" + passportnumber
                + ", passportExpiryDate=" + passportExpiryDate
                + ", passportStartDate=" + passportStartDate
                + ", birthDate=" + birthDate
                + ", address=" + address + '}';
    }

    @Override
    public boolean equals(Object other) {
        try {
            return this.userId == ((User) other).userId;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
