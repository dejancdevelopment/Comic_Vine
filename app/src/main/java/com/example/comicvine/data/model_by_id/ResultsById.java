package com.example.comicvine.data.model_by_id;

import java.util.ArrayList;

public class ResultsById {

    private ArrayList<CharacterCredits> character_credits;
    private String date_last_updated;
    private String description;
    private int id;
    private ImagesIssuesById image;
    private String issue_number;
    private ArrayList<LocationCredits> location_credits;
    private String name;
    private ArrayList<PersonalCredits> person_credits;
    private ArrayList<TeamCredits> team_credits;
    private VolumeById volume;

    public ResultsById(ArrayList<CharacterCredits> characterList, String date_last_updated,
                       String description, int id, ImagesIssuesById image, String issue_number,
                       ArrayList<LocationCredits> location_credits, String name,
                       ArrayList<PersonalCredits> person_credits,
                       ArrayList<TeamCredits> team_credits, VolumeById volume) {
        this.character_credits = characterList;
        this.date_last_updated = date_last_updated;
        this.description = description;
        this.id = id;
        this.image = image;
        this.issue_number = issue_number;
        this.location_credits = location_credits;
        this.name = name;
        this.person_credits = person_credits;
        this.team_credits = team_credits;
        this.volume = volume;

    }

    public ArrayList<CharacterCredits> getCharacter_credits() {
        return character_credits;
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

    public ImagesIssuesById getImage() {
        return image;
    }

    public String getIssue_number() {
        return issue_number;
    }

    public ArrayList<LocationCredits> getLocation_credits() {
        return location_credits;
    }

    public String getName() {
        return name;
    }

    public ArrayList<PersonalCredits> getPerson_credits() {
        return person_credits;
    }

    public ArrayList<TeamCredits> getTeam_credits() {
        return team_credits;
    }

    public VolumeById getVolume() {
        return volume;
    }
}
