package com.prateek.movie_booking.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "theatres")
public class TheatreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String theatreName;
    private String movie;
    private String town;
    private LocalDate showDate;
    private List<String> showTimings;

    public TheatreEntity() {
    }

    public TheatreEntity(Long id, String theatreName, String movie, String town, List<String> showTimings, LocalDate showDate) {
        this.id = id;
        this.theatreName = theatreName;
        this.movie = movie;
        this.town = town;
        this.showTimings = showTimings;
        this.showDate = showDate;
    }

    public LocalDate getShowDate() {
        return showDate;
    }

    public void setShowDate(LocalDate showDate) {
        this.showDate = showDate;
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

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public List<String> getShowTimings() {
        return showTimings;
    }

    public void setShowTimings(List<String> showTimings) {
        this.showTimings = showTimings;
    }
}