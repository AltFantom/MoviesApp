package com.kupriyanov.movies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private MainViewModel viewModel;
    private MoviesAdapter moviesAdapter;
    private RecyclerView recyclerView;
    private ProgressBar progressBarLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBarLoading = findViewById(R.id.progressBarLoading);
        recyclerView = findViewById(R.id.recyclerViewMovies);
        moviesAdapter = new MoviesAdapter();
        recyclerView.setAdapter(moviesAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        viewModel.getMovies().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> movies) {
                moviesAdapter.setMovies(movies);
            }
        });
        moviesAdapter.setOnReachEndListener(new MoviesAdapter.OnReachEndListener() {
            @Override
            public void onReachEnd() {
                viewModel.loadMovies();
            }
        });
        viewModel.getIsLoading().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean isLoading) {
                if (isLoading){
                    progressBarLoading.setVisibility(View.VISIBLE);
                } else {
                    progressBarLoading.setVisibility(View.GONE);
                }
            }
        });
    }
}