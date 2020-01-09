package com.example.comicvine.data.model.model_episodes;

public class EpisodesResult {

    private String description;
    private EpisodeImages image;
    private int episode_number;
    private String name;

    public EpisodesResult(String description, EpisodeImages image, int episode_number, String name) {
        this.description = description;
        this.image = image;
        this.episode_number = episode_number;
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public EpisodeImages getImage() {
        return image;
    }

    public int getEpisode_number() {
        return episode_number;
    }

    public String getName() {
        return name;
    }
}
