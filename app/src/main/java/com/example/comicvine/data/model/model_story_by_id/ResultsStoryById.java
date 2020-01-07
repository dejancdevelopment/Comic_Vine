package com.example.comicvine.data.model.model_story_by_id;

import java.util.List;

public class ResultsStoryById {

    private ImageStory image;
    private String name;
    private String deck;
    private String description;
    private List<IssuesByStory> issues;

    public ResultsStoryById(ImageStory image, String name, String deck, String description, List<IssuesByStory> issues) {
        this.image = image;
        this.name = name;
        this.deck = deck;
        this.description = description;
        this.issues = issues;
    }

    public ImageStory getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getDeck() {
        return deck;
    }

    public String getDescription() {
        return description;
    }

    public List<IssuesByStory> getIssues() {
        return issues;
    }
}
