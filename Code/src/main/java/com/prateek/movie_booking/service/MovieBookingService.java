package com.prateek.movie_booking.service;

import com.prateek.movie_booking.model.BookingEntity;
import com.prateek.movie_booking.model.BookingResponse;
import com.prateek.movie_booking.model.TheatreEntity;
import com.prateek.movie_booking.model.TheatreInfo;
import com.prateek.movie_booking.repository.BookingRepository;
import com.prateek.movie_booking.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieBookingService {

    @Autowired
    private TheatreRepository theatreRepository;
    @Autowired
    private BookingRepository bookingRepository;

    public List<TheatreInfo> browseTheatres(String movie, String town, LocalDate date) {
        // Fetch theatres from H2 in-memory database
        List<TheatreEntity> entities = theatreRepository.findByMovieAndTownAndShowDate(movie, town, date);
        List<TheatreInfo> result = new ArrayList<>();
        for (TheatreEntity entity : entities) {
            result.add(new TheatreInfo(entity.getTheatreName(), entity.getShowTimings()));
        }
        return result;
    }

    public BookingResponse bookingOffers(int numberOfTickets, String showTime) {
        double ticketPrice = 100.0; // Assume each ticket costs $100
        double discount = 0.0;
        double totalCost = ticketPrice * numberOfTickets;

        if (numberOfTickets >= 3) {
            discount += ticketPrice * 0.5; // 50% discount for the third ticket
        }

        // Apply 20% discount for afternoon shows (12 PM to 4 PM)
        int hour = Integer.parseInt(showTime.split(":")[0]);
        if (hour >= 12 && hour <= 16) {
            discount += totalCost * 0.2; // Additional 20% discount on total cost for afternoon shows
        }

        double discountPercentage = (discount / totalCost) * 100;

        return new BookingResponse(numberOfTickets, showTime, discountPercentage);
    }

    public BookingEntity bookTickets(int numberOfTickets, String theatreName, String showTime, List<String> preferredSeats) {
        double ticketPrice = 100.0; // Assume each ticket costs $100
        double totalCost = ticketPrice * numberOfTickets;

        // Call the bookingOffers method to get the discount
        BookingResponse bookingResponse = bookingOffers(numberOfTickets, showTime);
        double discountPercentage = bookingResponse.getDiscountPercentage();

        // Apply the discount to the total cost
        double discountAmount = (discountPercentage / 100) * totalCost;
        double finalCost = totalCost - discountAmount;

        // Create and save the booking (now with discount applied)
        BookingEntity booking = new BookingEntity(theatreName, showTime, preferredSeats, numberOfTickets, finalCost, discountPercentage);
        return bookingRepository.save(booking); // Save to H2 database
    }
}