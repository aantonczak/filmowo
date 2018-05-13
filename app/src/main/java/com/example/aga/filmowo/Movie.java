package com.example.aga.filmowo;

public class Movie {

    private long id;
    private String name;
    private String description;
    private String date;

    public Movie(long id, String name, String description, String date) {
        this.id = id;
        this.date = date;
        this.name = name;
        this.description = description;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
