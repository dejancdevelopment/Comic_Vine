package com.example.comicvine.data.model;

public class Volume {



    String api_detail_url;
    int id;
    String name;
    String site_detail_url;

    public Volume(String name) {
        this.name = name;
    }

    public Volume(String api_detail_url, int id, String name, String site_detail_url) {
        this.api_detail_url = api_detail_url;
        this.id = id;
        this.name = name;
        this.site_detail_url = site_detail_url;
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

    public String getSite_detail_url() {
        return site_detail_url;
    }
}
