package com.kupriyanov.movies;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

public interface ApiService {

    @GET("movie?token=F47PHVG-CMV43MT-P6ET91H-6R2YB3Q&field=rating.kp&search=7-10&sortField=votes.kp&sortType=-1&limit=5")
    Single<MovieResponse> loadMovies();
}
