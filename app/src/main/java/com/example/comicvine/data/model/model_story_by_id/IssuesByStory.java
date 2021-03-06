package com.example.comicvine.data.model.model_story_by_id;

public class IssuesByStory {

    private int id;
    private String name;
    private String site_detail_url;

    public IssuesByStory(int id, String name, String site_detail_url) {
        this.id = id;
        this.name = name;
        this.site_detail_url = site_detail_url;
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
