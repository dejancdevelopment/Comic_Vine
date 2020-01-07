package com.example.comicvine.data.model.model_characters;

public class ImagesCharacter {

   private String medium_url;
   private String screen_large_url;
   private String small_url;
   private String original_url;
   private String icon_url;
    private String thumb_url;

    public ImagesCharacter(String medium_url, String screen_large_url, String small_url,
                           String original_url, String icon_url, String thumb_url) {
        this.medium_url = medium_url;
        this.screen_large_url = screen_large_url;
        this.small_url = small_url;
        this.original_url = original_url;
        this.icon_url = icon_url;
        this.thumb_url = thumb_url;
    }

    public String getMedium_url() {
        return medium_url;
    }

    public String getScreen_large_url() {
        return screen_large_url;
    }

    public String getSmall_url() {
        return small_url;
    }

    public String getOriginal_url() {
        return original_url;
    }

    public String getIcon_url() {
        return icon_url;
    }

    public String getThumb_url() {
        return thumb_url;
    }
}
