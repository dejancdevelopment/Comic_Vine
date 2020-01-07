package com.example.comicvine.data.model.model_series;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseBySeries {

    @SerializedName("results")
    List<ResultBySeries> resultList;

    public ResponseBySeries(List<ResultBySeries> resultList) {
        this.resultList = resultList;
    }

    public List<ResultBySeries> getResultList() {
        return resultList;
    }
}
