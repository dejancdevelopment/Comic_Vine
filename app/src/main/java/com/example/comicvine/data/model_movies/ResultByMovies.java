package com.example.comicvine.data.model_movies;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ResultByMovies {

    private String deck;
    private String description;
    private int id;
    private ImagesMovies image;
    private String name;
    private String budget;
    private String release_date;
    private String runtime;
    private ArrayList<Studios> studios;
    private ArrayList<Writers> writers;

    public ResultByMovies(String deck, String description, int id, ImagesMovies image,
                          String name, String budget, String release_date, String runtime,
                          ArrayList<Studios> studios, ArrayList<Writers> writers) {
        this.deck = deck;
        this.description = description;
        this.id = id;
        this.image = image;
        this.name = name;
        this.budget = budget;
        this.release_date = release_date;
        this.runtime = runtime;
        this.studios = studios;
        this.writers = writers;
    }

    public String getDeck() {
        return deck;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public ImagesMovies getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getBudget() {
        return budget;
    }

    public String getRelease_date() {
        return release_date;
    }

    public String getRuntime() {
        return runtime;
    }

    public ArrayList<Studios> getStudios() {
        return studios;
    }

    public ArrayList<Writers> getWriters() {
        return writers;
    }
}
