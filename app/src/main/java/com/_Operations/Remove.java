package com._Operations;
import com.Validators.Validator;
import android.widget.Toast;
import com._Main.MainActivity;
import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.RecyclerViewLogic.R;

public class Remove extends Activity
{
    Button button_remove;
    EditText name;
    Validator validator=new Validator();

    @Override protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete);
        name=findViewById(R.id.name);
        button_remove=findViewById(R.id.button_remove);
        this.setTitle("Remove");

        DisplayMetrics display_metrics=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(display_metrics);
        int width_pixels=display_metrics.widthPixels;
        int height_pixels=display_metrics.heightPixels;
        getWindow().setLayout((width_pixels), (int)(height_pixels*0.3));

        button_remove.setOnClickListener(new View.OnClickListener()
        {
            @Override public void onClick(View v)
            {
                validator.ValidatorRemove(name.getText().toString(), MainActivity.movie_source);

                switch(validator.getError())
                {
                    case "Please enter a name!":
                    case "Enter a name with less than 30 characters!":
                    case "No such movie!":
                    Toast.makeText(getApplicationContext(), validator.getError(), Toast.LENGTH_SHORT).show();
                    break;

                    case "no":
                        MainActivity.movie_source.Delete(name.getText().toString());
                    runOnUiThread(new Runnable() { public void run() { MainActivity.adapter.notifyDataSetChanged(); } });
                    Toast.makeText(getApplicationContext(), "Movie successfully removed!", Toast.LENGTH_SHORT).show();
                    finish();
                    break;
                }
            }
        });
    }
}