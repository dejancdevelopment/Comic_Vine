package com.example.comicvine.data.model.model_episodes;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EpisodesResponse {

    @SerializedName("results")
    private EpisodesResult episodesResultList;

    public EpisodesResponse(EpisodesResult episodesResultList) {
        this.episodesResultList = episodesResultList;
    }

    public EpisodesResult getEpisodesResultList() {
        return episodesResultList;
    }
}
