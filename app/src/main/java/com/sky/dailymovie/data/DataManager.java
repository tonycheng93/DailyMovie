package com.sky.dailymovie.data;

import com.sky.dailymovie.data.local.PreferencesHelper;
import com.sky.dailymovie.data.model.Category;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * 项目名称：DailyMovie
 * 类描述：
 * 创建人：tonycheng
 * 创建时间：2017/5/23 23:49
 * 邮箱：tonycheng93@outlook.com
 * 修改人：
 * 修改时间：
 * 修改备注：
 */
@Singleton
public class DataManager {

    private final PreferencesHelper mPreferencesHelper;

    @Inject
    public DataManager(PreferencesHelper preferencesHelper) {
        this.mPreferencesHelper = preferencesHelper;
    }

    /**
     * 从数据库中获取分类列表数据
     */
    public Observable<List<Category>> getCategories() {
        return null;
    }
}
