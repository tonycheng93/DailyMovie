package com.sky.dailymovie.http;

import com.google.gson.TypeAdapterFactory;

import com.ryanharter.auto.value.gson.GsonTypeAdapterFactory;

/**
 * 项目名称：DailyMovie
 * 类描述：
 * 创建人：tonycheng
 * 创建时间：2017/6/15 16:56
 * 邮箱：tonycheng93@outlook.com
 * 修改人：
 * 修改时间：
 * 修改备注：
 */

@GsonTypeAdapterFactory
public abstract class BaseTypeAdapterFactory implements TypeAdapterFactory {

    public static TypeAdapterFactory create() {
        return new AutoValueGson_BaseTypeAdapterFactory();
    }
}
