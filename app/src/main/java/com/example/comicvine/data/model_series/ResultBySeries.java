package com.example.comicvine.data.model_series;

public class ResultBySeries {

    private String deck;
    private String description;
    private int id;
    private ImageSeries image;
    private String name;
    private Publisher publisher;
    private String count_of_episodes;
    private LastEpisode last_episode;
    private String start_year;

    public ResultBySeries(String deck, String description, int id, ImageSeries image,
                          String name, Publisher publisher, String count_of_episodes,
                          LastEpisode last_episode, String start_year) {
        this.deck = deck;
        this.description = description;
        this.id = id;
        this.image = image;
        this.name = name;
        this.publisher = publisher;
        this.count_of_episodes = count_of_episodes;
        this.last_episode = last_episode;
        this.start_year = start_year;
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

    public ImageSeries getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public String getCount_of_episodes() {
        return count_of_episodes;
    }

    public LastEpisode getLast_episode() {
        return last_episode;
    }

    public String getStart_year() {
        return start_year;
    }
}
