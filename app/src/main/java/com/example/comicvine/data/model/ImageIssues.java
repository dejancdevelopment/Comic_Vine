package com.example.comicvine.data.model;

public class ImageIssues {

    public ImageIssues(String original_url) {
        this.original_url = original_url;
    }

    String medium_url;
    String screen_url;
    String screen_large_url;
    String small_url;
    String thumb_url;
    String original_url;

    public ImageIssues(String medium_url, String screen_url, String screen_large_url, String small_url, String thumb_url, String original_url) {
        this.medium_url = medium_url;
        this.screen_url = screen_url;
        this.screen_large_url = screen_large_url;
        this.small_url = small_url;
        this.thumb_url = thumb_url;
        this.original_url = original_url;
    }

    public String getMedium_url() {
        return medium_url;
    }

    public String getScreen_url() {
        return screen_url;
    }

    public String getScreen_large_url() {
        return screen_large_url;
    }

    public String getSmall_url() {
        return small_url;
    }

    public String getThumb_url() {
        return thumb_url;
    }

    public String getOriginal_url() {
        return original_url;
    }
}
