package com.Movies;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class MovieSource implements Serializable
{
    ArrayList<Movie>movies=new ArrayList<>();

    public void Delete(String name)
    {
        Iterator<Movie>iterator=movies.iterator();
        while(iterator.hasNext())
        {
            Movie movie=iterator.next();
            if(movie.getName().equals(name)) { iterator.remove(); }
        }
    }

    public boolean Exists(String name)
    {
        int count=0;
        for(Movie movie:movies)
        { if(!movie.getName().equals(name)) count++; }
        return count==movies.size();
    }

    public void Add(Movie movie) { movies.add(movie); }

    public ArrayList<Movie>getMovies() { return movies; }
    public void setMovies(ArrayList<Movie>movies) { this.movies=movies; }
}