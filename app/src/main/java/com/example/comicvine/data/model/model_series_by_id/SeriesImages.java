package com.example.comicvine.data.model.model_series_by_id;

public class SeriesImages {

    private String medium_url;
    private String screen_large_url;

    public SeriesImages(String medium_url, String screen_large_url) {
        this.medium_url = medium_url;
        this.screen_large_url = screen_large_url;
    }

    public String getMedium_url() {
        return medium_url;
    }

    public String getScreen_large_url() {
        return screen_large_url;
    }
}
