package com.sky.dailymovie.database;

import android.content.ContentValues;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.sky.dailymovie.App;
import com.squareup.sqlbrite.BriteDatabase;
import com.squareup.sqlbrite.SqlBrite;

import rx.schedulers.Schedulers;

/**
 * Created by tonycheng on 2017/6/20.
 */

public class SqlBriteDbManager implements IDbManager {

    private final BriteDatabase mDb;

    private SqlBriteDbManager() {
        SqlBrite sqlBrite = new SqlBrite.Builder().build();
        DbOpenHelper openHelper = new DbOpenHelper(App.getInstance().getContext());
        mDb = sqlBrite.wrapDatabaseHelper(openHelper, Schedulers.io());
    }

    private static class SingletonHolder {
        private static final SqlBriteDbManager INSTANCE = new SqlBriteDbManager();
    }

    public static SqlBriteDbManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    @Override
    public long insert(@NonNull String table, @NonNull ContentValues values) {
        return mDb.insert(table, values);
    }

    @Override
    public int delete(@NonNull String table, @Nullable String whereClause, @Nullable String... whereArgs) {
        return mDb.delete(table, whereClause, whereArgs);
    }

    @Override
    public int update(@NonNull String table, @NonNull ContentValues values, @Nullable String whereClause, @Nullable String... whereArgs) {
        return mDb.update(table, values, whereClause, whereArgs);
    }

    @Override
    public void query(String sql) {

    }
}
