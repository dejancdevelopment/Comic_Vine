package com.example.comicvine.data.model_series;

public class ImageSeries {

   private String medium_url;
   private String screen_large_url;

    public ImageSeries(String medium_url, String screen_large_url) {
        this.medium_url = medium_url;
        this.screen_large_url = screen_large_url;
    }

    public String getMedium_url() {
        return medium_url;
    }

    public String getLarge_url() {
        return screen_large_url;
    }
}
