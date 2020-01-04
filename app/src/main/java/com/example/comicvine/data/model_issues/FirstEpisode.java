package com.example.comicvine.data.model_issues;

public class FirstEpisode {

    private String api_detail_url;
    private int id;
    private String name;
    private String episode_number;

    public FirstEpisode(String api_detail_url) {
        this.api_detail_url = api_detail_url;
    }

    public String getApi_detail_url() {
        return api_detail_url;
    }

    public void setApi_detail_url(String api_detail_url) {
        this.api_detail_url = api_detail_url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEpisode_number() {
        return episode_number;
    }

    public void setEpisode_number(String episode_number) {
        this.episode_number = episode_number;
    }
}
