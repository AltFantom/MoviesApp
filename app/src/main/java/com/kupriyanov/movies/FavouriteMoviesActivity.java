package com.kupriyanov.movies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.util.List;

public class FavouriteMoviesActivity extends AppCompatActivity {

    private RecyclerView recyclerViewFavouriteMovies;
    private MovieAdapter movieAdapter;
    FavouriteMoviesViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite_movies);
        initViews();
        viewModel = new ViewModelProvider(this).get(FavouriteMoviesViewModel.class);
        movieAdapter = new MovieAdapter();
        recyclerViewFavouriteMovies.setLayoutManager(new GridLayoutManager(
                this,
                2
        ));
        recyclerViewFavouriteMovies.setAdapter(movieAdapter);

        movieAdapter.setOnClickMovieListener(new MovieAdapter.OnMovieClickListener() {
            @Override
            public void onMovieClick(Movie movie) {
                Intent intent = MovieDetailActivity.newIntent(
                        FavouriteMoviesActivity.this,
                        movie
                );
                startActivity(intent);
            }
        });

        viewModel.getMovies().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> movies) {
                movieAdapter.setMovies(movies);
            }
        });
    }

    public static Intent newIntent(Context context){
        return  new Intent(context, FavouriteMoviesActivity.class);
    }

    private void initViews() {
        recyclerViewFavouriteMovies = findViewById(R.id.recyclerViewFavouriteMovies);
    }
}