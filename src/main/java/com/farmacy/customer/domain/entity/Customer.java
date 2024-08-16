package com.farmacy.customer.domain.entity;

import java.sql.Date;

public class Customer {
    private String idCustomer;
    private String nameCustomer;
    private String lastNameCustomer;
    private String codeCityCustomer;
    private String emailCustomer;
    private Date brrDate;
    private double latitude;
    private double longitude;

    public Customer(String idCustomer, String nameCustomer, String lastNameCustomer, String codeCityCustomer, String emailCustomer, Date brrDate, double latitude, double longitude) {
        this.idCustomer = idCustomer;
        this.nameCustomer = nameCustomer;
        this.lastNameCustomer = lastNameCustomer;
        this.codeCityCustomer = codeCityCustomer;
        this.emailCustomer = emailCustomer;
        this.brrDate = brrDate;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getLastNameCustomer() {
        return lastNameCustomer;
    }

    public void setLastNameCustomer(String lastNameCustomer) {
        this.lastNameCustomer = lastNameCustomer;
    }

    public String getCodeCityCustomer() {
        return codeCityCustomer;
    }

    public void setCodeCityCustomer(String codeCityCustomer) {
        this.codeCityCustomer = codeCityCustomer;
    }

    public String getEmailCustomer() {
        return emailCustomer;
    }

    public void setEmailCustomer(String emailCustomer) {
        this.emailCustomer = emailCustomer;
    }

    public Date getBrrDate() {
        return brrDate;
    }

    public void setBrrDate(Date brrDate) {
        this.brrDate = brrDate;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    
}
