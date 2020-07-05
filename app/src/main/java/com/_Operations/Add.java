package com._Operations;
import com.Validators.Validator;
import android.widget.Toast;
import com._Main.MainActivity;
import com.Movies.Movie;
import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import com.RecyclerViewLogic.R;

public class Add extends Activity
{
    EditText name, director, genre, year;
    RatingBar rating_stars;
    Button button_add;
    Validator validator=new Validator();

    @Override protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add);
        name=findViewById(R.id.name);
        director=findViewById(R.id.director);
        genre=findViewById(R.id.genre);
        year=findViewById(R.id.year);
        rating_stars=findViewById(R.id.rating_stars);
        button_add=findViewById(R.id.button_add);
        this.setTitle("Add");

        DisplayMetrics display_metrics=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(display_metrics);
        int width_pixels=display_metrics.widthPixels;
        int height_pixels=display_metrics.heightPixels;
        getWindow().setLayout((width_pixels), (int)(height_pixels*0.6));

        button_add.setOnClickListener(new View.OnClickListener()
        {
            @Override public void onClick(View v)
            {
                validator.ValidatorAdd(name.getText().toString(), director.getText().toString(), genre.getText().toString(), year.getText().toString(), MainActivity.movie_source);

                switch(validator.getError())
                {
                    case "Please enter in all of the spaces!":
                    case "Enter values with less than 30 characters!":
                    case "Such movie already exists in the list!":
                    Toast.makeText(getApplicationContext(), validator.getError(), Toast.LENGTH_SHORT).show();
                    break;

                    case "no":
                    Movie movie=new Movie
                    (name.getText().toString(), director.getText().toString(), genre.getText().toString(), year.getText().toString(), rating_stars.getRating());
                    MainActivity.movie_source.Add(movie);
                    runOnUiThread(new Runnable() { public void run() { MainActivity.adapter.notifyDataSetChanged(); } });
                    Toast.makeText(getApplicationContext(),"Movie successfully added!", Toast.LENGTH_SHORT).show();
                    finish();
                    break;
                }
            }
        });
    }
}