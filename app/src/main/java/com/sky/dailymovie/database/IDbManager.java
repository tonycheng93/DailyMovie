package com.sky.dailymovie.database;

/**
 * Created by tonycheng on 2017/6/20.
 */

/**
 * 数据库基本操作，增、删、改、查
 */
public interface IDbManager {

    /**
     * 增
     */
    void insert(String sql);

    /**
     * 删
     */
    void delete(String sql);

    /**
     * 改
     */
    void update(String sql);

    /**
     * 查
     */
    void query(String sql);
}
