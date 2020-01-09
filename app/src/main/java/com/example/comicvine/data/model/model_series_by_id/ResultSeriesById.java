package com.example.comicvine.data.model.model_series_by_id;

import java.util.List;

public class ResultSeriesById {

    private List<SeriesCharacters> characters;
    private int count_of_episodes;
    private String description;
    private List<SerieEpisodes> episodes;
    private LastEpisodeById last_episode;
    private int id;
    private SeriesImages image;
    private String name;
    private PublisherEpisode publisher;
    private String site_detail_url;
    private String start_year;

    public ResultSeriesById(List<SeriesCharacters> characters, int count_of_episodes,
                            String description, List<SerieEpisodes> episodes,
                            LastEpisodeById last_episode, int id, SeriesImages image, String name,
                            PublisherEpisode publisher, String site_detail_url, String start_year) {
        this.characters = characters;
        this.count_of_episodes = count_of_episodes;
        this.description = description;
        this.episodes = episodes;
        this.last_episode = last_episode;
        this.id = id;
        this.image = image;
        this.name = name;
        this.publisher = publisher;
        this.site_detail_url = site_detail_url;
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

    public LastEpisodeById getLast_episode() {
        return last_episode;
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

    public PublisherEpisode getPublisher() {
        return publisher;
    }

    public String getSite_detail_url() {
        return site_detail_url;
    }

    public String getStart_year() {
        return start_year;
    }
}
