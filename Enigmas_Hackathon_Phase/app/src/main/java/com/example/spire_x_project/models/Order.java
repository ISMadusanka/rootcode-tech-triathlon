package com.example.spire_x_project.models;

import com.example.spire_x_project.rec_views.package_list.Package;

import java.util.ArrayList;

public class Order {

    // Attributes
    private String personUID; // Unique identifier of the person placing the order
    private BookedTrip bookedTrip; // Information about the booked trip
    private Package selectedPackage; // Selected package for the order
    private ArrayList<PersonData> passengerDetails; // Details of passengers associated with the order

    // Getter and Setter for passenger details
    public ArrayList<PersonData> getPassengerDetails() {
        return passengerDetails;
    }

    public void setPassengerDetails(ArrayList<PersonData> passengerDetails) {
        this.passengerDetails = passengerDetails;
    }

    // Getter and Setter for selected package
    public Package getSelectedPackage() {
        return selectedPackage;
    }

    public void setSelectedPackage(Package selectedPackage) {
        this.selectedPackage = selectedPackage;
    }

    // Getter and Setter for person UID
    public String getPersonUID() {
        return personUID;
    }

    public void setPersonUID(String personUID) {
        this.personUID = personUID;
    }

    // Getter and Setter for booked trip
    public BookedTrip getBookedTrip() {
        return bookedTrip;
    }

    public void setBookedTrip(BookedTrip bookedTrip) {
        this.bookedTrip = bookedTrip;
    }
}
