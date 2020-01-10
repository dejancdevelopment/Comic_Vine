package com.example.comicvine.data.model.model_movie_by_id;

import com.google.gson.annotations.SerializedName;

public class MovieByIdResponse {

    @SerializedName("results")
    private MovieByIdResult movieByIdResult;

    public MovieByIdResponse(MovieByIdResult movieByIdResult) {
        this.movieByIdResult = movieByIdResult;
    }

    public MovieByIdResult getMovieByIdResult() {
        return movieByIdResult;
    }
}
