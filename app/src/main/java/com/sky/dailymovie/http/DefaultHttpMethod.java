package com.sky.dailymovie.http;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.sky.dailymovie.constant.Constants;
import com.sky.dailymovie.data.model.Category;
import com.sky.dailymovie.data.remote.DailyMovieService;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Converter;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by tonycheng on 2017/7/17.
 */

/**
 * 通用网络请求类，若需要对某些请求接口进行特殊化定制，继承自 {@link HttpMethod}
 */
public class DefaultHttpMethod extends HttpMethod<DailyMovieService> {

    private DefaultHttpMethod() {
    }

    private static final class Singleton {
        private static DefaultHttpMethod sInstance = new DefaultHttpMethod();
    }

    public static DefaultHttpMethod getInstance() {
        return Singleton.sInstance;
    }

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

    @Nullable
    @Override
    protected Converter.Factory getConverterFactory() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapterFactory(BaseTypeAdapterFactory.create())
                .create();
        return GsonConverterFactory.create(gson);
    }

    /**
     * 获取分类列表
     */
    public void getCategories(Observer<List<Category>> observer) {
        getService().getCategorise()
                .observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
