package com.example.spire_x_project.rec_views.package_list;

import android.widget.TextView;

import java.io.Serializable;

public class Package implements Serializable {
    String title,departureTime,departureDate,departureZone,departurePlanet,duration,pioletMode;

    String backDepartureTime,backDepartureDate,backDepartureZone,backDeparturePlanet,backDuration;
    String arrivalTime,arrivalDate,arrivalZone,arrivalPlanet;

    String backArrivalTime,backArivalDate,backArrivalZone,backArrivalPlanet;

    String cultureDescription;
    String vehicleName,vehicleDescription;
    String vehicleImageIrl;

    String dust,wind,temp;

    String specialActivityTitle,specialActivityDescription;
    String price,tag;
    boolean selectCheckBox;

    //for one way trip
    public Package(String title, String departureTime, String departureDate, String departureZone, String departurePlanet, String duration, String pioletMode, String arrivalTime, String arrivalDate, String arrivalZone, String arrivalPlanet, String price, String tag, boolean selectCheckBox) {
        this.title = title;
        this.departureTime = departureTime;
        this.departureDate = departureDate;
        this.departureZone = departureZone;
        this.departurePlanet = departurePlanet;
        this.duration = duration;
        this.pioletMode = pioletMode;
        this.arrivalTime = arrivalTime;
        this.arrivalDate = arrivalDate;
        this.arrivalZone = arrivalZone;
        this.arrivalPlanet = arrivalPlanet;
        this.price = price;
        this.tag = tag;
        this.selectCheckBox = selectCheckBox;
    }

    //for round trip


    public Package(String title, String departureTime, String departureDate, String departureZone, String departurePlanet, String duration, String pioletMode, String backDepartureTime, String backDepartureDate, String backDepartureZone, String backDeparturePlanet, String backDuration, String arrivalTime, String arrivalDate, String arrivalZone, String arrivalPlanet, String backArrivalTime, String backArivalDate, String backArrivalZone, String backArrivalPlanet, String cultureDescription, String vehicleName, String vehicleDescription, String vehicleImageIrl, String dust, String wind, String temp, String specialActivityTitle, String specialActivityDescription, String price, String tag, boolean selectCheckBox) {
        this.title = title;
        this.departureTime = departureTime;
        this.departureDate = departureDate;
        this.departureZone = departureZone;
        this.departurePlanet = departurePlanet;
        this.duration = duration;
        this.pioletMode = pioletMode;
        this.backDepartureTime = backDepartureTime;
        this.backDepartureDate = backDepartureDate;
        this.backDepartureZone = backDepartureZone;
        this.backDeparturePlanet = backDeparturePlanet;
        this.backDuration = backDuration;
        this.arrivalTime = arrivalTime;
        this.arrivalDate = arrivalDate;
        this.arrivalZone = arrivalZone;
        this.arrivalPlanet = arrivalPlanet;
        this.backArrivalTime = backArrivalTime;
        this.backArivalDate = backArivalDate;
        this.backArrivalZone = backArrivalZone;
        this.backArrivalPlanet = backArrivalPlanet;
        this.cultureDescription = cultureDescription;
        this.vehicleName = vehicleName;
        this.vehicleDescription = vehicleDescription;
        this.vehicleImageIrl = vehicleImageIrl;
        this.dust = dust;
        this.wind = wind;
        this.temp = temp;
        this.specialActivityTitle = specialActivityTitle;
        this.specialActivityDescription = specialActivityDescription;
        this.price = price;
        this.tag = tag;
        this.selectCheckBox = selectCheckBox;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getDepartureZone() {
        return departureZone;
    }

    public void setDepartureZone(String departureZone) {
        this.departureZone = departureZone;
    }

    public String getDeparturePlanet() {
        return departurePlanet;
    }

    public void setDeparturePlanet(String departurePlanet) {
        this.departurePlanet = departurePlanet;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getPioletMode() {
        return pioletMode;
    }

    public void setPioletMode(String pioletMode) {
        this.pioletMode = pioletMode;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getArrivalZone() {
        return arrivalZone;
    }

    public void setArrivalZone(String arrivalZone) {
        this.arrivalZone = arrivalZone;
    }

    public String getArrivalPlanet() {
        return arrivalPlanet;
    }

    public void setArrivalPlanet(String arrivalPlanet) {
        this.arrivalPlanet = arrivalPlanet;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public boolean isSelectCheckBox() {
        return selectCheckBox;
    }

    public void setSelectCheckBox(boolean selectCheckBox) {
        this.selectCheckBox = selectCheckBox;
    }

    public String getBackDepartureTime() {
        return backDepartureTime;
    }

    public void setBackDepartureTime(String backDepartureTime) {
        this.backDepartureTime = backDepartureTime;
    }

    public String getBackDepartureDate() {
        return backDepartureDate;
    }

    public void setBackDepartureDate(String backDepartureDate) {
        this.backDepartureDate = backDepartureDate;
    }

    public String getBackDepartureZone() {
        return backDepartureZone;
    }

    public void setBackDepartureZone(String backDepartureZone) {
        this.backDepartureZone = backDepartureZone;
    }

    public String getBackDeparturePlanet() {
        return backDeparturePlanet;
    }

    public void setBackDeparturePlanet(String backDeparturePlanet) {
        this.backDeparturePlanet = backDeparturePlanet;
    }

    public String getBackDuration() {
        return backDuration;
    }

    public void setBackDuration(String backDuration) {
        this.backDuration = backDuration;
    }

    public String getBackArrivalTime() {
        return backArrivalTime;
    }

    public void setBackArrivalTime(String backArrivalTime) {
        this.backArrivalTime = backArrivalTime;
    }

    public String getBackArivalDate() {
        return backArivalDate;
    }

    public void setBackArivalDate(String backArivalDate) {
        this.backArivalDate = backArivalDate;
    }

    public String getBackArrivalZone() {
        return backArrivalZone;
    }

    public void setBackArrivalZone(String backArrivalZone) {
        this.backArrivalZone = backArrivalZone;
    }

    public String getBackArrivalPlanet() {
        return backArrivalPlanet;
    }

    public void setBackArrivalPlanet(String backArrivalPlanet) {
        this.backArrivalPlanet = backArrivalPlanet;
    }

    public String getCultureDescription() {
        return cultureDescription;
    }

    public void setCultureDescription(String cultureDescription) {
        this.cultureDescription = cultureDescription;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getVehicleDescription() {
        return vehicleDescription;
    }

    public void setVehicleDescription(String vehicleDescription) {
        this.vehicleDescription = vehicleDescription;
    }

    public String getVehicleImageIrl() {
        return vehicleImageIrl;
    }

    public void setVehicleImageIrl(String vehicleImageIrl) {
        this.vehicleImageIrl = vehicleImageIrl;
    }

    public String getDust() {
        return dust;
    }

    public void setDust(String dust) {
        this.dust = dust;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getSpecialActivityTitle() {
        return specialActivityTitle;
    }

    public void setSpecialActivityTitle(String specialActivityTitle) {
        this.specialActivityTitle = specialActivityTitle;
    }

    public String getSpecialActivityDescription() {
        return specialActivityDescription;
    }

    public void setSpecialActivityDescription(String specialActivityDescription) {
        this.specialActivityDescription = specialActivityDescription;
    }
}
