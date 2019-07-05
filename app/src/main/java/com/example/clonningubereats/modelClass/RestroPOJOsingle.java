package com.example.clonningubereats.modelClass;

public class RestroPOJOsingle {

    private String id, thumImage, title, description, timmings, ratings;

    public RestroPOJOsingle(String id, String thumImage, String title, String description, String timmings, String ratings) {
        this.id = id;
        this.thumImage = thumImage;
        this.title = title;
        this.description = description;
        this.timmings = timmings;
        this.ratings = ratings;
    }

    public String getId() {
        return id;
    }

    public String getThumImage() {
        return thumImage;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getTimmings() {
        return timmings;
    }

    public String getRatings() {
        return ratings;
    }
}