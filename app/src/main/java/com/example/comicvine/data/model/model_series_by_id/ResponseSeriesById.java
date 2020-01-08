package com.example.comicvine.data.model.model_series_by_id;

import com.google.gson.annotations.SerializedName;

public class ResponseSeriesById {

    @SerializedName("results")
    private
    ResultSeriesById seriesByIdResult;

    public ResponseSeriesById(ResultSeriesById seriesByIdResult) {
        this.seriesByIdResult = seriesByIdResult;
    }

    public ResultSeriesById getSeriesByIdResult() {
        return seriesByIdResult;
    }
}
