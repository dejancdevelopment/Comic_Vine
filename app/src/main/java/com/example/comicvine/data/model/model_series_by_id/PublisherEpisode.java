package com.example.comicvine.data.model.model_series_by_id;

public class PublisherEpisode {

    private int id;
    private String name;
    private String episode_number;

    public PublisherEpisode(int id, String name, String episode_number) {
        this.id = id;
        this.name = name;
        this.episode_number = episode_number;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEpisode_number() {
        return episode_number;
    }
}
