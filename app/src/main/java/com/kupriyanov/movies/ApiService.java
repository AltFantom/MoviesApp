package com.kupriyanov.movies;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("movie?token=F47PHVG-CMV43MT-P6ET91H-6R2YB3Q&field=rating.kp&search=6-10&sortField=votes.kp&sortType=-1&limit=30")
    Single<MovieResponse> loadMovies(@Query("page") int page);

    @GET("movie?token=F47PHVG-CMV43MT-P6ET91H-6R2YB3Q&field=id")
    Single<TrailerResponse> loadTrailers(@Query("search") int id);
}
