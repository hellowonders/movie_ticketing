package com.prateek.movie_booking.model;

import java.util.List;

public class BookingRequest {

    private int numberOfTickets;
    private String theatreName;
    private String showTime;
    private List<String> preferredSeats;

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    public List<String> getPreferredSeats() {
        return preferredSeats;
    }

    public void setPreferredSeats(List<String> preferredSeats) {
        this.preferredSeats = preferredSeats;
    }
}