package com.example.spire_x_project.models;

public class PersonData {

    // Attributes
    private String name;       // Name of the person
    private String uid;        // Unique identifier for the person
    private String planetName; // Name of the planet associated with the person
    private String title;      // Title of the person

    // Constructor to initialize the attributes
    public PersonData(String title, String name, String uid, String planetName) {
        this.title = title;
        this.name = name;
        this.uid = uid;
        this.planetName = planetName;
    }

    // Getter and Setter for title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Getter and Setter for planet name
    public String getPlanetName() {
        return planetName;
    }

    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for UID
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
