package com.example.emmanuelnika.app;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import android.database.SQLException;

/**
 * Created by
 * Okot Emmanuel
 * Masiga David Kelvin
 * Nabwire Barbra Sandra
 * Lema James on 7/27/2017.
 */

/**
 * Helper class that actually creates and manages
 * the provider's underlying data repository.
 */

public class DBHelper extends SQLiteOpenHelper {

    private SQLiteDatabase db;
    public static final String KEY_ROWID = "_id";
    public static final String KEY_GENDER = "gender";
    public static final String KEY_USER = "username";

    DBHelper DB = null;
    private static final String DATABASE_NAME = "app.db";
    private static final int DATABASE_VERSION = 2;
    public static final String DATABASE_TABLE_NAME = "Student";

    private static final String DATABASE_TABLE_CREATE =
            "CREATE TABLE " + DATABASE_TABLE_NAME + "(" +
                    "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "gender TEXT NOT NULL, username TEXT NOT NULL, password TEXT NOT NULL);";

    public DBHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    //    System.out.println("In constructor");
    }

    //Creating tables
    @Override
    public void onCreate(SQLiteDatabase db) {

        try {

            db.execSQL(DATABASE_TABLE_CREATE);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub

        //Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_NAME);

        //Create tables again
        onCreate(db);

    }

    public Cursor rawQuery(String string, String[] strings) {
        // TODO Auto-generated method stub
        return null;

    }

    public void open() {
        getWritableDatabase();

    }

    public Cursor getDetails(String text) throws SQLException {

        Cursor mCursor =
                db.query(true, DATABASE_TABLE_NAME, new String[]{KEY_ROWID, KEY_GENDER,},
                        KEY_USER + "=" + text,
                        null, null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }
}