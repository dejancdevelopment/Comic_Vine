package com.example.comicvine.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Response {

    @SerializedName("results")
    List<IssuesResults> resultList;

    public Response(ArrayList<IssuesResults> resultList) {
        this.resultList = resultList;
    }

    public List<IssuesResults> getResultList() {
        return resultList;
    }
}
