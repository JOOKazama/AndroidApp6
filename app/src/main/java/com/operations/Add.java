package com.operations;
import com.validators.Validator;
import android.widget.Toast;
import com.app6.MainActivity;
import com.movies.Movie;
import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import com.movies.MovieSource;
import com.app6.R;

public class Add extends Activity
{
    EditText nameadd, directoradd, genreadd, yearadd;
    RatingBar ratingadd;
    Button addadd;

    @Override protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addnew);
        nameadd=findViewById(R.id.nameadd);
        directoradd=findViewById(R.id.directoradd);
        genreadd=findViewById(R.id.genreadd);
        yearadd=findViewById(R.id.yearadd);
        ratingadd=findViewById(R.id.ratingadd);
        addadd=findViewById(R.id.addadd);
        this.setTitle("Add");

        DisplayMetrics metrics=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        int wp=metrics.widthPixels;
        int hp=metrics.heightPixels;

        getWindow().setLayout((wp), (int)(hp*0.6));

        addadd.setOnClickListener(new View.OnClickListener()
        {
            @Override public void onClick(View v)
            {
                Validator.valadd(nameadd.getText().toString(), directoradd.getText().toString(), genreadd.getText().toString(), yearadd.getText().toString());

                switch (Validator.error)
                {
                    case "Please enter in all of the spaces!":
                    case "Enter values with less than 30 characters!":
                    case "Such movie already exists in the list!":
                    Toast.makeText(getApplicationContext(), Validator.error, Toast.LENGTH_SHORT).show();
                    break;

                    case "no":
                    Movie movie=new Movie
                    (nameadd.getText().toString(), directoradd.getText().toString(), genreadd.getText().toString(), yearadd.getText().toString(), ratingadd.getRating());
                    MovieSource.add(movie);
                    runOnUiThread(new Runnable() { public void run() { MainActivity.adapter.notifyDataSetChanged(); } });
                    Toast.makeText(getApplicationContext(),"Movie successfully added!",Toast.LENGTH_SHORT).show();
                    break;
                }
            }
        });
    }
}