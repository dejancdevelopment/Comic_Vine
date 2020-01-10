package com.example.comicvine.data.model.model_episodes;

import com.google.gson.annotations.SerializedName;

public class EpisodesResponse {

    @SerializedName("results")
    private EpisodesResult episodesResult;

    public EpisodesResponse(EpisodesResult episodesResultList) {
        this.episodesResult = episodesResultList;
    }

    public EpisodesResult getEpisodesResult() {
        return episodesResult;
    }
}
