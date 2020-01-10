package com.example.comicvine.data.model.model_movie_by_id;

public class MovieCharacters {

   private String name;
    private String id;
    private String site_detail_url;

    public MovieCharacters(String name, String id, String site_detail_url) {
        this.name = name;
        this.id = id;
        this.site_detail_url = site_detail_url;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getSite_detail_url() {
        return site_detail_url;
    }
}
