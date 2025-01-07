package com.prateek.movie_booking.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookingResponse {

    private int numberOfTickets;
    private String showTime;
    private double discountPercentage;

    public BookingResponse() {
    }

    public BookingResponse(int numberOfTickets, String showTime, double discountPercentage) {
        this.numberOfTickets = numberOfTickets;
        this.showTime = showTime;
        this.discountPercentage = discountPercentage;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }
}
