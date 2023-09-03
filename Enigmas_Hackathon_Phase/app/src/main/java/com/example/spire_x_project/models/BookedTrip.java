package com.example.spire_x_project.models;

import java.io.Serializable;
import java.util.Date;

public class BookedTrip implements Serializable {

    // Departure and Arrival Information
    private Date departureDate, arrivalDate;
    private String departurePlace, departureCode, departureStation, departurePlanet;
    private String arrivalPlace, arrivalCode, arrivalStation, arrivalPlanet;

    // Passenger Counts
    private int childCount, adultCount, infantCount;

    // Trip Class (e.g., economy, business)
    private int tripClass;

    // Pricing Factor
    private float priceFactor = 1;

    // Reset the pricing factor to default (1)
    public void resetPriceFactor() {
        priceFactor = 1;
    }

    // Getter and Setter for Pricing Factor
    public float getPriceFactor() {
        return priceFactor;
    }

    public void setPriceFactor(float priceFactor) {
        this.priceFactor = priceFactor;
    }

    // Getter and Setter for Departure Planet
    public String getDeparturePlanet() {
        return departurePlanet;
    }

    public void setDeparturePlanet(String departurePlanet) {
        this.departurePlanet = departurePlanet;
    }

    // Getter and Setter for Arrival Planet
    public String getArrivalPlanet() {
        return arrivalPlanet;
    }

    public void setArrivalPlanet(String arrivalPlanet) {
        this.arrivalPlanet = arrivalPlanet;
    }

    // Getter and Setter for Departure Date
    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date date) {
        this.departureDate = date;
    }

    // Getter and Setter for Arrival Date
    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    // Getter and Setter for Departure Place
    public String getDeparturePlace() {
        return departurePlace;
    }

    public void setDeparturePlace(String departurePlace) {
        this.departurePlace = departurePlace;
    }

    // Getter and Setter for Departure Code
    public String getDepartureCode() {
        return departureCode;
    }

    public void setDepartureCode(String departureCode) {
        this.departureCode = departureCode;
    }

    // Getter and Setter for Departure Station
    public String getDepartureStation() {
        return departureStation;
    }

    public void setDepartureStation(String departureStation) {
        this.departureStation = departureStation;
    }

    // Getter and Setter for Arrival Place
    public String getArrivalPlace() {
        return arrivalPlace;
    }

    public void setArrivalPlace(String arrivalPlace) {
        this.arrivalPlace = arrivalPlace;
    }

    // Getter and Setter for Arrival Code
    public String getArrivalCode() {
        return arrivalCode;
    }

    public void setArrivalCode(String arrivalCode) {
        this.arrivalCode = arrivalCode;
    }

    // Getter and Setter for Arrival Station
    public String getArrivalStation() {
        return arrivalStation;
    }

    public void setArrivalStation(String arrivalStation) {
        this.arrivalStation = arrivalStation;
    }

    // Getter and Setter for Child Count
    public int getChildCount() {
        return childCount;
    }

    public void setChildCount(int childCount) {
        this.childCount = childCount;
    }

    // Getter and Setter for Adult Count
    public int getAdultCount() {
        return adultCount;
    }

    public void setAdultCount(int adultCount) {
        this.adultCount = adultCount;
    }

    // Getter and Setter for Infant Count
    public int getInfantCount() {
        return infantCount;
    }

    public void setInfantCount(int infantCount) {
        this.infantCount = infantCount;
    }

    // Getter and Setter for Trip Class
    public int getTripClass() {
        return tripClass;
    }

    public void setTripClass(int tripClass) {
        this.tripClass = tripClass;
    }
}
