package com.Validators;
import com.Movies.MovieSource;

public class Validator
{
    private String error="";

    public void ValidatorRemove(String name, MovieSource movie_source)
    {
        if(name.equals("")) error="Please enter a name!";
        else if(name.length()>30) error="Enter a name with less than 30 characters!";
        else if(movie_source.Exists(name)) error="No such movie!";
        else error="no";
    }

    public void ValidatorAdd(String name, String director, String genre, String year, MovieSource movie_source)
    {
        if(name.equals("") || director.equals("") || genre.equals("") || year.equals("")) error="Please enter in all of the spaces!";
        else if(name.length()>30 || director.length()>30 || genre.length()>30 || year.length()>30) error="Enter values with less than 30 characters!";
        else if(!movie_source.Exists(name)) error="Such movie already exists in the list!";
        else error="no";
    }

    public String getError() { return error; }
    public void setError(String error) { this.error=error; }
}