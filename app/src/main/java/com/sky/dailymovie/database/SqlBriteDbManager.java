package com.sky.dailymovie.database;

/**
 * Created by tonycheng on 2017/6/20.
 */

public class SqlBriteDbManager implements IDbManager {

    private SqlBriteDbManager() {

    }

    private static class SingletonHolder {
        private static final SqlBriteDbManager INSTANCE = new SqlBriteDbManager();
    }

    public static SqlBriteDbManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    @Override
    public void insert(String sql) {

    }

    @Override
    public void delete(String sql) {

    }

    @Override
    public void update(String sql) {

    }

    @Override
    public void query(String sql) {

    }
}
