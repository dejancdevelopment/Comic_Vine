package com.example.comicvine.data.model.model_story_by_id;

public class IssuesByStory {

    private int id;
    private String name;

    public IssuesByStory(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
