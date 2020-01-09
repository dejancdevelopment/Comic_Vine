package com.example.comicvine.data.model.model_episodes;

public class EpisodesResult {

    private String description;
    private int id;
    private String name;
    private EpisodeImages image;
    private String site_detail_url;
    private int air_date;
    private String episode_number;

    public EpisodesResult(String description, int id, String name, EpisodeImages image,
                          String site_detail_url, int air_date, String episode_number) {
        this.description = description;
        this.id = id;
        this.name = name;
        this.image = image;
        this.site_detail_url = site_detail_url;
        this.air_date = air_date;
        this.episode_number = episode_number;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public EpisodeImages getImage() {
        return image;
    }

    public String getSite_detail_url() {
        return site_detail_url;
    }

    public int getAir_date() {
        return air_date;
    }

    public String getEpisode_number() {
        return episode_number;
    }
}
