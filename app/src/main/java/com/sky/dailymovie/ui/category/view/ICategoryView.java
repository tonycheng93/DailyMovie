package com.sky.dailymovie.ui.category.view;

import com.sky.dailymovie.data.model.Category;
import com.sky.dailymovie.ui.base.MvpView;

import java.util.List;

/**
 * Created by tonycheng on 2017/7/31.
 */

public interface ICategoryView extends MvpView {

    /**
     * 显示分类列表
     *
     * @param categories 分类列表
     */
    void showCategories(List<Category> categories);

    /**
     * 分类列表为空时
     */
    void showCategoriesEmpty();

    /**
     * 获取分类列表失败
     */
    void showError();
}
