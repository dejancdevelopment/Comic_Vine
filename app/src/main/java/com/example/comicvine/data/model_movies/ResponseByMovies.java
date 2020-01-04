package com.example.comicvine.data.model_movies;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseByMovies {

    @SerializedName("results")
    public List<ResultByMovies> movieList;

    public ResponseByMovies(List<ResultByMovies> movieList) {
        this.movieList = movieList;
    }

    public List<ResultByMovies> getMovieList() {
        return movieList;
    }
}
