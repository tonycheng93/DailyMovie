package com.sky.dailymovie.database;

/**
 * Created by tonycheng on 2017/6/20.
 */

public class DbFactory {

    public static IDbManager getDbManager() {
        return SqlBriteDbManager.getInstance();
    }
}
