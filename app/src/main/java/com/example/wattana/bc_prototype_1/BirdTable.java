package com.example.wattana.bc_prototype_1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Wattana on 11/11/2558.
 */
public class BirdTable {


    private MySQLiteOpenHelper objMySQLiteOpenHelper;
    private SQLiteDatabase writeSQLiteDatabase , readSQLiteDatabase;

    public static final String BIRD_TABLE = "BirdTable";
    public static final String COLUMN_ID_BIRD = "_id";
    public static final String COLUMN_BIRD_NAME = "BirdName";
    public static final String COLUMN_DESC = "Desc";
    public static final String COLUMN_LOCALTION = "Localtion";
    public static final String COLUMN_SOURCE = "source";


    public BirdTable(Context context){
        objMySQLiteOpenHelper = new MySQLiteOpenHelper(context);
        writeSQLiteDatabase = objMySQLiteOpenHelper.getWritableDatabase();
        readSQLiteDatabase = objMySQLiteOpenHelper.getReadableDatabase();

    }//constructor

    public long addnewBird(String strBirdName, String strDesc, String strLocation, String strSource){
        ContentValues  objContentValues = new ContentValues();
        objContentValues.put(COLUMN_BIRD_NAME,strBirdName);
        objContentValues.put(COLUMN_DESC,strDesc);
        objContentValues.put(COLUMN_LOCALTION,strLocation);
        objContentValues.put(COLUMN_SOURCE,strSource);

        return readSQLiteDatabase.insert(BIRD_TABLE,null,objContentValues);
    }

    public String[] readAllBird(int intcolumn){
        String[] strReadAll = null;
        Cursor objCursor = readSQLiteDatabase.query(BIRD_TABLE,
                new String[]{COLUMN_BIRD_NAME,COLUMN_DESC,COLUMN_LOCALTION,COLUMN_SOURCE},
               null,null,null,null,null );

        if (objCursor != null){
            objCursor.moveToNext();
            strReadAll = new String[objCursor.getCount()];
            for (int i =0; i <= objCursor.getCount();i++){
                switch (intcolumn){
                    case 1:
                        strReadAll[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_BIRD_NAME));
                        break;
                }
                objCursor.moveToNext();
            }
        }
        return strReadAll;
    }

}
