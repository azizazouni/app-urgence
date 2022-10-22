package com.example.urgence;

public class AlertResult {
    private String userRef;
    private String typeAlert;
    private String longg;
    private String latt;

    public String getUserRef() {
        return userRef;
    }

    public void setUserRef(String userRef) {
        this.userRef = userRef;
    }

    public String getTypeAlert() {
        return typeAlert;
    }

    public void setTypeAlert(String typeAlert) {
        this.typeAlert = typeAlert;
    }

    public String getLon() {
        return longg;
    }

    public void setLon(String lon) {
        this.longg = lon;
    }

    public String getLatt() {
        return latt;
    }

    public void setLatt(String latt) {
        this.latt = latt;
    }

    public AlertResult(String userRef, String typeAlert, String lon, String latt) {
        this.userRef = userRef;
        this.typeAlert = typeAlert;
        this.longg = lon;
        this.latt = latt;


    }
}
