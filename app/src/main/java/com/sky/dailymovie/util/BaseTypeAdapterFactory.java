package com.sky.dailymovie.util;

import com.google.gson.TypeAdapterFactory;

import com.ryanharter.auto.value.gson.GsonTypeAdapterFactory;

/**
 * Created by tonycheng on 2017/5/24.
 */
@GsonTypeAdapterFactory
public abstract class BaseTypeAdapterFactory implements TypeAdapterFactory {

    public static TypeAdapterFactory create() {
        return new AutoValueGson_BaseTypeAdapterFactory();
    }
}
