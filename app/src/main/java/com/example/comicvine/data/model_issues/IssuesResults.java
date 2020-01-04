package com.example.comicvine.data.model_issues;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "issues_")
public class IssuesResults {

    @PrimaryKey
    @NonNull
    private int id;

    private String aliases;
    private String api_detail_url;
    private String date_added;
    private String deck;
    private String date_last_updated;
    private String description;
    private ImageIssues image;
    private String name;
    private String site_detail_url;
    private String issue_number;
    private String store_date;
    private Volume volume;

    public IssuesResults(String aliases, String api_detail_url, String date_added,String deck,
                         String date_last_updated, String description, int id,
                         ImageIssues image, String name, String site_detail_url,
                         String issue_number, String store_date,Volume volume) {
        this.aliases = aliases;
        this.api_detail_url = api_detail_url;
        this.date_added = date_added;
        this.deck=deck;
        this.date_last_updated = date_last_updated;
        this.description = description;
        this.id = id;
        this.image = image;
        this.name = name;
        this.site_detail_url = site_detail_url;
        this.issue_number = issue_number;
        this.store_date = store_date;
        this.volume=volume;
    }

    public String getAliases() {
        return aliases;
    }

    public String getApi_detail_url() {
        return api_detail_url;
    }

    public String getDate_added() {
        return date_added;
    }

    public String getDeck() {
        return deck;
    }

    public String getDate_last_updated() {
        return date_last_updated;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public ImageIssues getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getSite_detail_url() {
        return site_detail_url;
    }

    public String getIssue_number() {
        return issue_number;
    }

    public String getStore_date() {
        return store_date;
    }

    public Volume getVolume() {
        return volume;
    }


}




