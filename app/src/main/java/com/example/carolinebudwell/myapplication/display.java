package com.example.carolinebudwell.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.*;
import static com.example.carolinebudwell.myapplication.firstFragment.EXTRA_MESSAGE;

/**
 * Created by carolinebudwell on 2/19/18.
 */

public class display extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);




        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            if(bundle.getString(EXTRA_MESSAGE) != null) {
                makeText(getApplicationContext(),
                        "data:" + bundle.getString(EXTRA_MESSAGE),
                        LENGTH_LONG).show();
            }
        }
    }
}
