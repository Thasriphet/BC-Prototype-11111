package com.example.wattana.bc_prototype_1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Wattana on 16/11/2558.
 */

public class Birddatabase extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "kkubirds.db";

    // Table Name
    private static final String TABLE_BIRD_info = "BirdInfomation";



    public Birddatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_BIRD_info +
                "(BirdID INTEGER PRIMARY KEY AUTOINCREMENT," +
                " Name TEXT(100)," +
                " Description TEXT(100),"+
                " Location TEXT(100),"+
                " Path TEXT(100));");

        Log.d("CREATE TABLE", "Create Table Successfully.");

    }

    public long InsertData(String strBirdID, String strName, String strDescription, String strLocation, String strPath) {
        // TODO Auto-generated method stub

        try {
            SQLiteDatabase db;
            db = this.getWritableDatabase(); // Write Data



            ContentValues Val = new ContentValues();
            Val.put("BirdID", strBirdID);
            Val.put("Name", strName);
            Val.put("Description", strDescription);
            Val.put("Location", strLocation);
            Val.put("Path", strPath);

            long rows = db.insert(TABLE_BIRD_info, null, Val);

            db.close();
            return rows; // return rows inserted.

        } catch (Exception e) {
            return -1;
        }

    }

    // Select All Data
    public String[][] SelectAllData() {
        // TODO Auto-generated method stub

        try {
            String arrData[][] = null;
            SQLiteDatabase db;
            db = this.getReadableDatabase(); // Read Data

            String strSQL = "SELECT  * FROM " + TABLE_BIRD_info;
            Cursor cursor = db.rawQuery(strSQL, null);



            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    arrData = new String[cursor.getCount()][cursor.getColumnCount()];
                    /***
                     *  [x][0] = GalleryID
                     *  [x][1] = Name
                     *  [x][2] = Path
                     */
                    int i = 0;
                    do {
                        arrData[i][0] = cursor.getString(0);
                        arrData[i][1] = cursor.getString(1);
                        arrData[i][2] = cursor.getString(2);
                        arrData[i][3] = cursor.getString(3);
                        arrData[i][4] = cursor.getString(4);
                        Log.i("TAG",arrData[i][2]);

                        //Log.e("TAG", arrData[i][1]);
                        i++;
                    } while (cursor.moveToNext());

                }
            }
            cursor.close();


            return arrData;

        } catch (Exception e) {
            return null;
        }
    }

    // Select All Data บึงสีฐาน
    public String[][] SelectSithanData() {
        // TODO Auto-generated method stub
         //String Sithan = "บ่อน้ำประมง ";
        try {
            String arrData[][] = null;
            SQLiteDatabase db;
            db = this.getReadableDatabase(); // Read Data

            String strSQL = "SELECT  * FROM " + TABLE_BIRD_info + " WHERE Location = 'บึงสีฐาน ';";
            //String strSQL = "SELECT  * FROM " + TABLE_BIRD + " WHERE Location = 'บ่อน้ำประมง ';";
           //String strSQL = "SELECT  * FROM " + TABLE_BIRD + " WHERE Location = 'ทุ่งหญ้าเลี้ยงสัตว์คณะเกษตรศาสตร์ ';";

            Cursor cursor = db.rawQuery(strSQL, null);

            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    arrData = new String[cursor.getCount()][cursor.getColumnCount()];

                    /***
                     *  [x][0] = GalleryID
                     *  [x][1] = Name
                     *  [x][2] = Path
                     */
                    int i = 0;
                    do {
                        arrData[i][0] = cursor.getString(0);
                        arrData[i][1] = cursor.getString(1);
                        arrData[i][2] = cursor.getString(2);
                        arrData[i][3] = cursor.getString(3);
                        arrData[i][4] = cursor.getString(4);
                        i++;
                    } while (cursor.moveToNext());

                }
            }
            cursor.close();
            //Log.d("TAG", arrData);
            return arrData;

        } catch (Exception e) {
            return null;
        }
    } // Select All Data บึงสีฐาน


    // Select All Data บ่อน้ำหมวดประมง
    public String[][] SelectPramongData() {
        // TODO Auto-generated method stub
        //String Sithan = "บ่อน้ำประมง ";
        try {
            String arrData[][] = null;
            SQLiteDatabase db;
            db = this.getReadableDatabase(); // Read Data

            //String strSQL = "SELECT  * FROM " + TABLE_BIRD + " WHERE Location = 'บึงสีฐาน ';";
            String strSQL = "SELECT  * FROM " + TABLE_BIRD_info + " WHERE Location = 'บ่อน้ำประมง ';";
            //String strSQL = "SELECT  * FROM " + TABLE_BIRD + " WHERE Location = 'ทุ่งหญ้าเลี้ยงสัตว์คณะเกษตรศาสตร์ ';";

            Cursor cursor = db.rawQuery(strSQL, null);

            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    arrData = new String[cursor.getCount()][cursor.getColumnCount()];

                    /***
                     *  [x][0] = GalleryID
                     *  [x][1] = Name
                     *  [x][2] = Path
                     */
                    int i = 0;
                    do {
                        arrData[i][0] = cursor.getString(0);
                        arrData[i][1] = cursor.getString(1);
                        arrData[i][2] = cursor.getString(2);
                        arrData[i][3] = cursor.getString(3);
                        arrData[i][4] = cursor.getString(4);
                        i++;
                    } while (cursor.moveToNext());

                }
            }
            cursor.close();
            //Log.d("TAG", arrData);
            return arrData;

        } catch (Exception e) {
            return null;
        }
    } // Select All Data บ่อน้ำหมวดประมง

    // Select All Data แปลงเกษตร
    public String[][] SelectPlangKasetData() {
        // TODO Auto-generated method stub
        //String Sithan = "บ่อน้ำประมง ";
        try {
            String arrData[][] = null;
            SQLiteDatabase db;
            db = this.getReadableDatabase(); // Read Data

            //String strSQL = "SELECT  * FROM " + TABLE_BIRD + " WHERE Location = 'บึงสีฐาน ';";
            //String strSQL = "SELECT  * FROM " + TABLE_BIRD + " WHERE Location = 'บ่อน้ำประมง ';";
            String strSQL = "SELECT  * FROM " + TABLE_BIRD_info + " WHERE Location = 'ทุ่งหญ้าเลี้ยงสัตว์คณะเกษตรศาสตร์ ';";

            Cursor cursor = db.rawQuery(strSQL, null);

            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    arrData = new String[cursor.getCount()][cursor.getColumnCount()];

                    /***
                     *  [x][0] = GalleryID
                     *  [x][1] = Name
                     *  [x][2] = Path
                     */
                    int i = 0;
                    do {
                        arrData[i][0] = cursor.getString(0);
                        arrData[i][1] = cursor.getString(1);
                        arrData[i][2] = cursor.getString(2);
                        arrData[i][3] = cursor.getString(3);
                        arrData[i][4] = cursor.getString(4);
                        i++;
                    } while (cursor.moveToNext());

                }
            }
            cursor.close();
            //Log.d("TAG", arrData);
            return arrData;

        } catch (Exception e) {
            return null;
        }
    } // Select All Data แปลงเกษตร



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BIRD_info);

        // Re Create on method  onCreate
        onCreate(db);

    }
}
