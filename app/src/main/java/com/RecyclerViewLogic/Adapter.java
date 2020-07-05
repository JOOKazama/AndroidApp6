package com.RecyclerViewLogic;
import com.Movies.Movie;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<ViewHolder>
{
    private final ArrayList<Movie>movies;

    public Adapter(ArrayList<Movie>movies) { this.movies=movies; }

    @NonNull @Override public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        Context context=parent.getContext();
        LayoutInflater layout_inflater=LayoutInflater.from(context);
        View view=layout_inflater.inflate(R.layout.showmovie, parent, false);
        return new ViewHolder((view));
    }

    @Override public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        final Movie movie=movies.get(position);
        holder.setName("Name: "+movie.getName());
        holder.setDirector("Director: "+movie.getDirector());
        holder.setGenre("Genre: "+movie.getGenre());
        holder.setYear("Year: "+movie.getYear());
        holder.setRating(movie.getRating());
        holder.setIndex("Index: "+holder.getAdapterPosition());
    }

    @Override public int getItemCount() { return movies.size(); }
}