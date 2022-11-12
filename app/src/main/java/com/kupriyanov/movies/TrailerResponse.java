package com.kupriyanov.movies;

import com.google.gson.annotations.SerializedName;

public class TrailerResponse {

    @SerializedName("videos")
    private TrailersList trailers;

    public TrailerResponse(TrailersList trailers) {
        this.trailers = trailers;
    }

    public TrailersList getTrailers() {
        return trailers;
    }
}
