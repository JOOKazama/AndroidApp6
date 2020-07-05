package com._Main;
import com.Movies.MovieSource;
import com._Operations.Add;
import com._Operations.Remove;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.RecyclerViewLogic.Adapter;
import com.RecyclerViewLogic.R;

public class MainActivity extends AppCompatActivity
{
    Button button_add, button_remove;
    RecyclerView recycler_view;
    public static Adapter adapter;
    public static MovieSource movie_source=new MovieSource();

    @Override protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_add=findViewById(R.id.button_add);
        button_remove=findViewById(R.id.button_remove);
        recycler_view=findViewById(R.id.recycler_view);
        setTitle("Main window");

        RecyclerView recycler_view=findViewById(R.id.recycler_view);
        adapter=new Adapter(movie_source.getMovies());
        recycler_view.setAdapter(adapter);
        recycler_view.setLayoutManager(new LinearLayoutManager(this));

        final Intent intent_add=new Intent(MainActivity.this, Add.class);
        final Intent intent_remove=new Intent(MainActivity.this, Remove.class);

        button_add.setOnClickListener(new View.OnClickListener() { @Override public void onClick(View v) { startActivity(intent_add); } });
        button_remove.setOnClickListener(new View.OnClickListener() { @Override public void onClick(View v) { startActivity(intent_remove); } });
    }
}