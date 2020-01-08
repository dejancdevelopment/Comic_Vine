package com.example.comicvine.data.model.model_series_by_id;

import java.util.List;

public class ResultSeriesById {

    private List<SeriesCharacters> characters;
    private int count_of_episodes;
    private String description;
    private List<SerieEpisodes> episodes;
    private int id;
    private SeriesImages image;
    private String name;
    private String start_year;

    public ResultSeriesById(List<SeriesCharacters> characters, int count_of_episodes,
                            String description, List<SerieEpisodes> episodes, int id,
                            SeriesImages image, String name, String start_year) {
        this.characters = characters;
        this.count_of_episodes = count_of_episodes;
        this.description = description;
        this.episodes = episodes;
        this.id = id;
        this.image = image;
        this.name = name;
        this.start_year = start_year;
    }

    public List<SeriesCharacters> getCharacters() {
        return characters;
    }

    public int getCount_of_episodes() {
        return count_of_episodes;
    }

    public String getDescription() {
        return description;
    }

    public List<SerieEpisodes> getEpisodes() {
        return episodes;
    }

    public int getId() {
        return id;
    }

    public SeriesImages getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getStart_year() {
        return start_year;
    }
}
