package com.example.comicvine.data.model.model_movie_by_id;

import java.util.List;

public class MovieByIdResult {

    private String deck;
    private String description;
    private String name;
    private String site_detail_url;
    private ImageMovieById image;
    private List<MovieCharacters> characters;
    private String release_date;
    private String runtime;

    public MovieByIdResult(String deck, String description, String name, String site_detail_url,
                           ImageMovieById image, List<MovieCharacters> characters,
                           String release_date, String runtime) {
        this.deck = deck;
        this.description = description;
        this.name = name;
        this.site_detail_url = site_detail_url;
        this.image = image;
        this.characters = characters;
        this.release_date = release_date;
        this.runtime = runtime;
    }

    public String getDeck() {
        return deck;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String getSite_detail_url() {
        return site_detail_url;
    }

    public ImageMovieById getImage() {
        return image;
    }

    public List<MovieCharacters> getCharacters() {
        return characters;
    }

    public String getRelease_date() {
        return release_date;
    }

    public String getRuntime() {
        return runtime;
    }
}
