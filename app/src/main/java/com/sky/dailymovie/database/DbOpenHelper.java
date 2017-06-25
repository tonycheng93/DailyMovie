package com.sky.dailymovie.database;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import timber.log.Timber;

/**
 * Created by tonycheng on 2017/6/21.
 */

public class DbOpenHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "daily_movie.db";
    private static final int DATABASE_VERSION = 1;

    public DbOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.beginTransaction();
        try {
            db.execSQL("");
            db.setTransactionSuccessful();
        } catch (SQLException e) {
            Timber.d(e);
        }
        db.endTransaction();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //do not need now.
    }
}
