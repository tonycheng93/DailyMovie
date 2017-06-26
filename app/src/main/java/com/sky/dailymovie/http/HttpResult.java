package com.sky.dailymovie.http;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;

/**
 * 项目名称：DailyMovie
 * 类描述：
 * 创建人：tonycheng
 * 创建时间：2017/6/15 16:42
 * 邮箱：tonycheng93@outlook.com
 * 修改人：
 * 修改时间：
 * 修改备注：
 */

@AutoValue
public abstract class HttpResult<T> {

    public abstract int code();

    public abstract String msg();

    public abstract T data();

    public static <T> Builder<T> builder() {
        return new AutoValue_HttpResult.Builder<>();
    }


    @AutoValue.Builder
    public abstract static class Builder<T> {
        public abstract Builder<T> code(int code);

        public abstract Builder<T> msg(String msg);

        public abstract Builder<T> data(T data);

        public abstract HttpResult<T> build();
    }

    public static <T> TypeAdapter<HttpResult<T>> typeAdapter(Gson gson,
                                                             TypeToken<? extends HttpResult<T>>
                                                                     typeToken) {
        return new AutoValue_HttpResult.GsonTypeAdapter<>(gson, typeToken);
    }
}
