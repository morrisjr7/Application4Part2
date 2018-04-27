package com.example.carolinebudwell.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "translation.db";
    private static final String TABLE_Name = "translation";
    private static final String COLUMN_ENGLISH = "english";
    private static final String COLUMN_SPANISH = "spanish";
    public static SQLiteDatabase db ;
    private static final String TABLE_CREATE = "CREATE TABLE IF NOT EXISTS translation (english,spanish);";



    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.i("info","started");

    }

    public String searchPass (String englishWord) {
        db = this.getReadableDatabase();
        String query = "select english,spanish from "+ TABLE_Name;
        Log.i("info","here");
        Cursor cursor = db.rawQuery(query, null);
        String a,b;
        b = "not found";
        if(cursor.moveToFirst()){
            do{
                a = cursor.getString(0);
                if(a.equals((englishWord))){
                    b = cursor.getString(1);
                    break;
                }


            }
            while(cursor.moveToNext());{

            }
        }
        Log.i("sql",b);
        return b;
    }

    public void insertPair(TranslationPair Tpair){
        db = this.getWritableDatabase();
        db.execSQL(TABLE_CREATE);
        ContentValues values = new ContentValues();
        values.put(COLUMN_ENGLISH,Tpair.getEnglishWord());
        values.put(COLUMN_SPANISH,Tpair.getSpanishWord());
        db.insert(TABLE_Name,null,values);
        db.close();
        Log.i("info","insert successful");

    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.i("info","Database exists!");

        db.execSQL(TABLE_CREATE);
        this.db = db;

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query = "DROP TABLE IF EXISTS "+ TABLE_Name;
        db.execSQL(query);
        this.onCreate(db);

    }
}
