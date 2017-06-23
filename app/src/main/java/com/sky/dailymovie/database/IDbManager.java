package com.sky.dailymovie.database;

/**
 * Created by tonycheng on 2017/6/20.
 */

import android.content.ContentValues;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * 数据库基本操作，增、删、改、查
 */
public interface IDbManager {


    long insert(@NonNull String table, @NonNull ContentValues values);

    int delete(@NonNull String table, @Nullable String whereClause, @Nullable String... whereArgs);

    int update(@NonNull String table, @NonNull ContentValues values,
               @Nullable String whereClause, @Nullable String... whereArgs);

    void query(String sql);
}
