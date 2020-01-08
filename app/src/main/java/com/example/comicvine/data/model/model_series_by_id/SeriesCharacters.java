package com.example.comicvine.data.model.model_series_by_id;

public class SeriesCharacters {

   private int id;
    private String name;
    private String site_detail_url;

    public SeriesCharacters(int id, String name, String site_detail_url) {
        this.id = id;
        this.name = name;
        this.site_detail_url = site_detail_url;
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

    public String getSite_detail_url() {
        return site_detail_url;
    }

    public void setSite_detail_url(String site_detail_url) {
        this.site_detail_url = site_detail_url;
    }
}
