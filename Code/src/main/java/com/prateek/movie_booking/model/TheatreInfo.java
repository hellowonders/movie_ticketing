package com.prateek.movie_booking.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TheatreInfo {

    private String theatreName;
    private List<String> showTimings;

    public TheatreInfo() {
        this.showTimings = new ArrayList<>();
    }

    public TheatreInfo(String theatreName, List<String> showTimings) {
        this.theatreName = theatreName;
        this.showTimings = showTimings != null ? showTimings : new ArrayList<>();
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public List<String> getShowTimings() {
        return showTimings;
    }

    public void setShowTimings(List<String> showTimings) {
        this.showTimings = showTimings;
    }
}