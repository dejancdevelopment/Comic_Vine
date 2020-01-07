package com.example.comicvine.data.model.model_story_by_id;

public class ImageStory {

    private String icon_url;
    private String medium_url;
    private String screen_large_url;

    public ImageStory(String icon_url, String medium_url, String screen_large_url) {
        this.icon_url = icon_url;
        this.medium_url = medium_url;
        this.screen_large_url = screen_large_url;
    }

    public String getIcon_url() {
        return icon_url;
    }

    public String getMedium_url() {
        return medium_url;
    }

    public String getScreen_large_url() {
        return screen_large_url;
    }
}
