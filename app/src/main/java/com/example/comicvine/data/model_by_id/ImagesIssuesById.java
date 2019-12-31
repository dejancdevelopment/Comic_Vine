package com.example.comicvine.data.model_by_id;

public class ImagesIssuesById {

    String small_url;

    public ImagesIssuesById(String screen_large_url) {
        this.small_url = screen_large_url;
    }

    public String getSmall_url() {
        return small_url;
    }
}
