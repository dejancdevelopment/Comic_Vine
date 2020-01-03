package com.example.comicvine.data.model_characters;

public class ImagesCharacter {

   private String medium_url;
   private String small_url;
   private String original_url;
   private String icon_url;

    public ImagesCharacter(String medium_url, String small_url, String original_url, String icon_url) {
        this.medium_url = medium_url;
        this.small_url = small_url;
        this.original_url = original_url;
        this.icon_url = icon_url;
    }

    public String getMedium_url() {
        return medium_url;
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
}
