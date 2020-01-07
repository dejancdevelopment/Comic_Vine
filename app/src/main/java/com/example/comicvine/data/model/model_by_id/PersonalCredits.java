package com.example.comicvine.data.model.model_by_id;

public class PersonalCredits {

    private String api_detail_url;
    private int id;
    private String name;
    private String site_detail_url;
    private String role;

    public PersonalCredits(String api_detail_url, int id, String name, String site_detail_url, String role) {
        this.api_detail_url = api_detail_url;
        this.id = id;
        this.name = name;
        this.site_detail_url = site_detail_url;
        this.role = role;
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

    public String getRole() {
        return role;
    }
}
