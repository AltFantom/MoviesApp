package com.kupriyanov.movies;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TrailersList {

    @SerializedName("trailers")
    private List<Trailer> trailerList;

    public TrailersList(List<Trailer> trailerList) {
        this.trailerList = trailerList;
    }

    public List<Trailer> getTrailerList() {
        return trailerList;
    }
}
