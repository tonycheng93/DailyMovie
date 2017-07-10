package com.sky.dailymovie.ui.category;

import android.support.annotation.NonNull;

import com.sky.dailymovie.constant.Constants;
import com.sky.dailymovie.data.model.Category;
import com.sky.dailymovie.data.remote.DailyMovieService;
import com.sky.dailymovie.http.HttpMethod;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by tonycheng on 2017/7/10.
 */

public class CategoryHttpMethod extends HttpMethod<DailyMovieService> {

    @NonNull
    @Override
    public String getBaseUrl() {
        return Constants.BASE_URL;
    }

    @NonNull
    @Override
    public Class<DailyMovieService> getServiceClazz() {
        return DailyMovieService.class;
    }

    void getCategories(Consumer<List<Category>> consumer) {
        getService().getCategorise()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(consumer);
    }
}
