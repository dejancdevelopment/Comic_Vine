package com.example.comicvine.data.model.model_episodes;

public class EpisodeImages {

   private String medium_url;
    private String screen_url;

    public EpisodeImages(String medium_url, String screen_url) {
        this.medium_url = medium_url;
        this.screen_url = screen_url;
    }

    public String getMedium_url() {
        return medium_url;
    }

    public String getScreen_url() {
        return screen_url;
    }
}
