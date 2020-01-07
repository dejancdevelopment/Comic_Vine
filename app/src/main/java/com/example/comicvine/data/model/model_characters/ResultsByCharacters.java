package com.example.comicvine.data.model.model_characters;

public class ResultsByCharacters {

   private String deck;
    private String description;
    private int id;
    private ImagesCharacter image;
    private String name;
    private String real_name;
    private Publisher publisher;


    public ResultsByCharacters(String deck, String description,
                               int id, ImagesCharacter image, String name,
                               String real_name, Publisher publisher) {
        this.deck = deck;
        this.description = description;
        this.id = id;
        this.image = image;
        this.name = name;
        this.real_name = real_name;
        this.publisher = publisher;
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

    public ImagesCharacter getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getReal_name() {
        return real_name;
    }

    public Publisher getPublisher() {
        return publisher;
    }
}
