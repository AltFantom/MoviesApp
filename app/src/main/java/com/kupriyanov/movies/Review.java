package com.kupriyanov.movies;

import com.google.gson.annotations.SerializedName;

public class Review {

    @SerializedName("type")
    private String type;
    @SerializedName("review")
    private String reviewText;
    @SerializedName("author")
    private String authorNickname;

    public Review(String type, String reviewText, String authorNickname) {
        this.type = type;
        this.reviewText = reviewText;
        this.authorNickname = authorNickname;
    }

    public String getType() {
        return type;
    }

    public String getReviewText() {
        return reviewText;
    }

    public String getAuthorNickname() {
        return authorNickname;
    }
}
