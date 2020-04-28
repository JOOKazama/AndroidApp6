package com.app6;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder
{
    private final TextView name, director, genre, year,  index;
    private final RatingBar rating;

    public TextView getName() { return name; }
    public void setName(String name) { this.name.setText(name); }
    public TextView getDirector() { return director; }
    public void setDirector(String director) { this.director.setText(director); }
    public TextView getGenre() { return genre; }
    public void setGenre(String genre) { this.genre.setText(genre); }
    public TextView getYear() { return year; }
    public void setYear(String year) { this.year.setText(year); }
    public RatingBar getRating() { return rating; }
    public void setRating(float rating) { this.rating.setRating(rating); }
    public TextView getIndex() { return index; }
    public void setIndex(String index) { this.index.setText(index); }

    public ViewHolder(@NonNull View itemView)
    {
        super(itemView);
        name=itemView.findViewById(R.id.name);
        director=itemView.findViewById(R.id.director);
        genre=itemView.findViewById(R.id.genre);
        year=itemView.findViewById(R.id.year);
        index=itemView.findViewById(R.id.index);
        rating=itemView.findViewById(R.id.rating);
    }
}