package com.example.comicvine.data.model.model_series;

public class LastEpisode {

    private String api_detail_url;
    private int id;
    private String name;

    public LastEpisode(String api_detail_url, int id, String name) {
        this.api_detail_url = api_detail_url;
        this.id = id;
        this.name = name;
    }

    public String getApi_detail_url() {
        return api_detail_url;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
