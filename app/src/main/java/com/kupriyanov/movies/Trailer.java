package com.kupriyanov.movies;

import com.google.gson.annotations.SerializedName;

public class Trailer {

    @SerializedName("url")
    private final String url;
    @SerializedName("name")
    private final String name;

    public Trailer(String url, String name) {
        this.url = url;
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }
}
