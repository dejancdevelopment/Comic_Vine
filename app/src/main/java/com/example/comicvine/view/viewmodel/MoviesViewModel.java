package com.example.comicvine.view.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.comicvine.data.model.model_movie_by_id.MovieByIdResult;
import com.example.comicvine.data.model.model_movies.ResultByMovies;
import com.example.comicvine.data.repository.MoviesRepo;

import java.util.List;

public class MoviesViewModel extends AndroidViewModel {

    private MoviesRepo moviesRepo;

    public MoviesViewModel(@NonNull Application application) {
        super(application);

        moviesRepo=MoviesRepo.getInstance(application);

    }
    public LiveData<List<ResultByMovies>> getGetAllMovies() {
        return moviesRepo.getAllMovies();
    }

    public LiveData<MovieByIdResult> getGetMovieById(String id) {
        return moviesRepo.getMovieById(id);
    }
}
