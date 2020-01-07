package com.example.comicvine.data.model.model_story_by_id;

import com.google.gson.annotations.SerializedName;

public class ResponseStoryById {

    @SerializedName("results")
    private
    ResultsStoryById resultsStoryById;

    public ResponseStoryById(ResultsStoryById resultsStoryById) {
        this.resultsStoryById = resultsStoryById;
    }

    public ResultsStoryById getResultsStoryById() {
        return resultsStoryById;
    }
}
