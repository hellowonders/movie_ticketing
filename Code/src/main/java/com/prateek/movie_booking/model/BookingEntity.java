package com.prateek.movie_booking.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class BookingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String theatreName;
    private String showTime;
    private List<String> preferredSeats;

    private final double ticketPrice = 100.0;
    private int numberOfTickets;
    private double totalCost;
    private double discountPercentage;

    public BookingEntity() {}

    public BookingEntity(String theatreName, String showTime, List<String> preferredSeats, int numberOfTickets, double totalCost, double discountPercentage) {
        this.theatreName = theatreName;
        this.showTime = showTime;
        this.preferredSeats = preferredSeats;
        this.numberOfTickets = numberOfTickets;
        this.totalCost = totalCost;
        this.discountPercentage = discountPercentage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public double getTicketPrice() {
        return ticketPrice; // Always returns the fixed value of 100.0
    }
}
