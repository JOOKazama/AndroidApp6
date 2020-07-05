package com.Movies;

public class Movie
{
    private String name;
    private String director;
    private String genre;
    private String year;
    private float rating;

    public Movie(String name, String director, String genre, String year, float rating)
    {
        this.name=name;
        this.director=director;
        this.genre=genre;
        this.year=year;
        this.rating=rating;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name=name; }
    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre=genre; }
    public String getYear() { return year; }
    public void setYear(String year) { this.year=year; }
    public String getDirector() { return director; }
    public void setDirector(String director) { this.director=director; }
    public float getRating() { return rating; }
    public void setRating(int rating) { this.rating=rating; }
}