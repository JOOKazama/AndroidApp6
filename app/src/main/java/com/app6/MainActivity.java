package com.app6;
import Movies.MovieSource;
import Operations.Add;
import Operations.Remove;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity
{
    Button add, remove;
    RecyclerView view;
    public static Adapter adapter;

    @Override protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add=findViewById(R.id.add);
        remove=findViewById(R.id.remove);
        view=findViewById(R.id.view);
        setTitle("Main window");

        remove.setOnClickListener(new View.OnClickListener()
        { @Override public void onClick(View v) { startActivity(new Intent(MainActivity.this, Remove.class)); } });

        add.setOnClickListener(new View.OnClickListener()
        { @Override public void onClick(View v) { startActivity(new Intent(MainActivity.this, Add.class)); } });

        RecyclerView recyclerView=findViewById(R.id.view);
        adapter=new Adapter(MovieSource.list());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}