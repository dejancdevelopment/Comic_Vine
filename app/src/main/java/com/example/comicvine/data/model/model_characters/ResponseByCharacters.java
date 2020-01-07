package com.example.comicvine.data.model.model_characters;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseByCharacters {

    @SerializedName("results")
    List<ResultsByCharacters> resultList;

    public ResponseByCharacters(List<ResultsByCharacters> resultList) {
        this.resultList = resultList;
    }

    public List<ResultsByCharacters> getResultList() {
        return resultList;
    }
}
