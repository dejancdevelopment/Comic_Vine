package com.example.comicvine.data.model.model_movie_by_id;

public class ImageMovieById {

   private String medium_url;
    private String screen_large_url;

    public ImageMovieById(String medium_url, String screen_large_url) {
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
