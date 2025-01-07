package com.prateek.movie_booking.controller;

import com.prateek.movie_booking.model.BookingEntity;
import com.prateek.movie_booking.model.BookingRequest;
import com.prateek.movie_booking.model.BookingResponse;
import com.prateek.movie_booking.model.TheatreInfo;
import com.prateek.movie_booking.service.MovieBookingService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("/api/movies")
public class MovieBookingController {

    private final MovieBookingService movieBookingService;

    public MovieBookingController(MovieBookingService movieBookingService) {
        this.movieBookingService = movieBookingService;
    }

    /**
     * Browses theatres showing the selected movie in the specified town on the given date.
     *
     * @param movie The movie name.
     * @param town The town name.
     * @param date The date (format: YYYY-MM-DD).
     * @return List of {@link TheatreInfo} with matching theatres.
     */
    @GetMapping("/browse")
    public List<TheatreInfo> browseTheatres(
            @RequestParam String movie,
            @RequestParam String town,
            @RequestParam LocalDate date) {
        return movieBookingService.browseTheatres(movie, town, date);
    }

    /**
     * Calculates booking price with any applicable discounts.
     *
     * @param numberOfTickets The number of tickets.
     * @param showTime The showtime.
     * @return {@link BookingResponse} with the booking details.
     */
    @GetMapping("/booking-offers")
    public BookingResponse bookingOffers(
            @RequestParam int numberOfTickets,
            @RequestParam String showTime) {
        return movieBookingService.bookingOffers(numberOfTickets, showTime);
    }

    @PostMapping("/book")
    public BookingEntity bookTickets(@RequestBody BookingRequest bookingRequest) {
        return movieBookingService.bookTickets(
                bookingRequest.getNumberOfTickets(),
                bookingRequest.getTheatreName(),
                bookingRequest.getShowTime(),
                bookingRequest.getPreferredSeats()
        );
    }
}
