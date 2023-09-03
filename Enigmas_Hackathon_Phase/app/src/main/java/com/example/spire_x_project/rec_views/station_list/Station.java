package com.example.spire_x_project.rec_views.station_list;

public class Station {

    private String stationID;
    private String placeName;
    private String planetName;
    private String code;
    private String stationName;


    public Station(String stationID,String placeName, String planetName, String code, String stationName) {
        this.placeName = placeName;
        this.planetName = planetName;
        this.code = code;
        this.stationName = stationName;
    }

    public String getStationID() {
        return stationID;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getPlanetName() {
        return planetName;
    }

    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }
}
