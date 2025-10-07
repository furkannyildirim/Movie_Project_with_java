package com.example.movieproject.dtos;

public class MovieDTO {
    private long id;
    private String title;
    private String director;
    private int year;

    public MovieDTO(long id, String title, String director, int year) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.year = year;
    }
    public MovieDTO() {}

    public MovieDTO(String title, String director, int year) {
        this.title = title;
        this.director = director;
        this.year = year;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
