package com.example.carolinebudwell.myapplication;

import android.app.FragmentManager;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.renderscript.ScriptGroup;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import static com.example.carolinebudwell.myapplication.DatabaseHelper.db;

public class MainActivity extends AppCompatActivity {
    public DatabaseHelper helper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstFragment first = new firstFragment();
        android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
                .replace(R.id.firstLayout, first, first.getTag())
                .commit();


        secondFragment second = new secondFragment();
        manager.beginTransaction()
                .replace(R.id.secondLayout, second, second.getTag())
                .commit();
        helper.getWritableDatabase();
        helper.insertPair(new TranslationPair("hello","hola"));
        helper.insertPair(new TranslationPair("goodbye","adios"));
        helper.insertPair(new TranslationPair("please","por favor"));
        helper.insertPair(new TranslationPair("thank you","gracias"));
        helper.insertPair(new TranslationPair("you're welcome","de nada"));
        helper.insertPair(new TranslationPair("yes","si"));
        helper.insertPair(new TranslationPair("no","no"));
        helper.insertPair(new TranslationPair("I'm sorry","lo siento"));
    }
    public void onButtonClick(View v){
        if(v.getId()== R.id.Bbutton){
            EditText a = (EditText)findViewById(R.id.Input);
            String str = a.getText().toString();
            Intent i = new Intent(MainActivity.this,display.class);
            i.putExtra("Response","Howdy");
            startActivity(i);


        }
    }

    public void addPairs (){
//        helper.insertPair(new TranslationPair("hello","hola"));
//        helper.insertPair(new TranslationPair("goodbye","adios"));
//        helper.insertPair(new TranslationPair("please","por favor"));
//        helper.insertPair(new TranslationPair("thank you","gracias"));
//        helper.insertPair(new TranslationPair("you're welcome","de nada"));
//        helper.insertPair(new TranslationPair("yes","si"));
//        helper.insertPair(new TranslationPair("no","no"));
//        helper.insertPair(new TranslationPair("I'm sorry","lo siento"));



    }
}
