package com.app6;
import com.movies.Movie;
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

    public Adapter(ArrayList<Movie>movies){ this.movies=movies; }

    @NonNull @Override public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        Context context=parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);
        View contactView=inflater.inflate(R.layout.showmovie, parent, false);
        return new ViewHolder((contactView));
    }

    @Override public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        final Movie m=movies.get(position);
        holder.setName("Name: "+m.getName());
        holder.setDirector("Director: "+m.getDirector());
        holder.setGenre("Genre: "+m.getGenre());
        holder.setYear("Year: "+m.getYear());
        holder.setRating(m.getRating());
        holder.setIndex("Index: "+holder.getAdapterPosition());
    }

    @Override public int getItemCount() { return movies.size(); }
}