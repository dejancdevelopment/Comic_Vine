package com.example.comicvine.data.model.model_by_id;

import com.google.gson.annotations.SerializedName;

public class ResponseById {

    @SerializedName("results")
    ResultsById resultList;

    public ResponseById(ResultsById resultList) {
        this.resultList = resultList;
    }

    public ResultsById getResultList() {
        return resultList;
    }
}
