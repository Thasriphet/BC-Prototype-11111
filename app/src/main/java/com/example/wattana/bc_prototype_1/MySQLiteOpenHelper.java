package com.example.wattana.bc_prototype_1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Wattana on 11/11/2558.
 */
public class MySQLiteOpenHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "BirdInformation.db";
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_BIRD_TABLE = "create table BirdTable " +
            "(_id integer primary key, BirdName text,Desc text,Localtion text, source text);";
    public  MySQLiteOpenHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);


    }//constuctor

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_BIRD_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
