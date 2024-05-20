package com.example.todohidromiel.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "recipe_db";
    private static final int DATABASE_VERSION = 1;

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Test best data
    String createTableQuery = "CREATE TABLE recipe (" +
            "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "ingredient_name TEXT, " +
            "amount REAL, " +
            "measure TEXT)";


    @Override
    public void onCreate(SQLiteDatabase db) {
        // Table
        String createTableQuery = "CREATE TABLE recipes (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "water REAL, " +
                "honey REAL, " +
                "yeast REAL)";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE " + DATABASE_NAME);
        onCreate(sqLiteDatabase);
    }
}
