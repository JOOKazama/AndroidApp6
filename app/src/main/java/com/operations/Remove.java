package com.operations;
import com.validators.Validator;
import android.widget.Toast;
import com.app6.MainActivity;
import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.movies.MovieSource;
import com.app6.R;

public class Remove extends Activity
{
    Button remove;
    EditText delete;

    @Override protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete);
        delete=findViewById(R.id.delete);
        remove=findViewById(R.id.remove);
        this.setTitle("Remove");

        DisplayMetrics metrics=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        int wp=metrics.widthPixels;
        int hp=metrics.heightPixels;

        getWindow().setLayout((wp), (int)(hp*0.3));

        remove.setOnClickListener(new View.OnClickListener()
        {
            @Override public void onClick(View v)
            {
                Validator.valremove(delete.getText().toString());

                switch(Validator.error)
                {
                    case "Please enter a name!":
                    case "Enter a name with less than 30 characters!":
                    case "No such movie!":
                    Toast.makeText(getApplicationContext(), Validator.error, Toast.LENGTH_SHORT).show();
                    break;

                    case "no":
                    MovieSource.delete(delete.getText().toString());
                    runOnUiThread(new Runnable() { public void run() { MainActivity.adapter.notifyDataSetChanged(); } });
                    Toast.makeText(getApplicationContext(), "Movie successfully removed!", Toast.LENGTH_SHORT).show();
                    break;
                }
            }
        });
    }
}