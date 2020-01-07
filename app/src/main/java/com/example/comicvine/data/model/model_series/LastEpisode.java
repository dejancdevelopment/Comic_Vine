package com.example.comicvine.data.model.model_series;

public class LastEpisode {

    private int id;
    private String name;

    public LastEpisode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
