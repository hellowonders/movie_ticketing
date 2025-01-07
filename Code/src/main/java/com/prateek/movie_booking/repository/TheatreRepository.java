package com.prateek.movie_booking.repository;

import com.prateek.movie_booking.model.TheatreEntity;
import com.prateek.movie_booking.model.TheatreInfo;
import jakarta.annotation.PostConstruct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public interface TheatreRepository extends JpaRepository<TheatreEntity, Long> {
    // Find theatres by movie, town, and show date
    List<TheatreEntity> findByMovieAndTownAndShowDate(String movie, String town, LocalDate showDate);
}