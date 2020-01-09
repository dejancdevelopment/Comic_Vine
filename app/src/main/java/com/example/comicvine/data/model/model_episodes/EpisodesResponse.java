package com.example.comicvine.data.model.model_episodes;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EpisodesResponse {

    @SerializedName("results")
    List<EpisodesResult> episodesResultList;

    public EpisodesResponse(List<EpisodesResult> episodesResultList) {
        this.episodesResultList = episodesResultList;
    }

    public List<EpisodesResult> getEpisodesResultList() {
        return episodesResultList;
    }
}
