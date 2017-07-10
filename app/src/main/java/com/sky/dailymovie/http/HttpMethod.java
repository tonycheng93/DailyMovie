package com.sky.dailymovie.http;

/**
 * 项目名称：DailyMovie
 * 类描述：
 * 创建人：tonycheng
 * 创建时间：2017/6/9 22:29
 * 邮箱：tonycheng93@outlook.com
 * 修改人：
 * 修改时间：
 * 修改备注：
 */

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.BuildConfig;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 网络请求方法抽象基类，所有的网络请求方法都需要继承自它
 *
 * @param <T> Retrofit对应的Service接口
 */

public abstract class HttpMethod<T> {

    private T mService = null;

    @NonNull
    public abstract String getBaseUrl();//设置基地址，具体实现类可以设置自己的BaseUrl

    @Nullable
    public int getTimeOut() {//设置超时时间，具体实现类可以设置自己的超时时间
        return 10;
    }

    @NonNull
    public abstract Class<T> getServiceClazz();//设置Retrofit需要的Service

    @Nullable
    protected Map<String, String> getHeaders() {//设置请求头
        return null;
    }

    @Nullable
    protected Converter.Factory getConverterFactory() {//默认使用的是GsonConverterFactory，如果你对 Gson 有特殊配置，可以返回带有特殊配置的GsonConverterFactory。create(gson)
        return null;
    }

    @Nullable
    protected OkHttpClient getOkHttpClient() {//设置 OkHttpClient
        return null;
    }

    private boolean printLog() {//是否开启 OkHttp log 打印，默认开启
        return true;
    }

    public HttpMethod() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getBaseUrl())
                .client(getOkHttpClient() == null ? getDefaultClient() : getOkHttpClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(getConverterFactory() == null ? GsonConverterFactory.create() : getConverterFactory())
                .build();
        mService = retrofit.create(getServiceClazz());
    }

    /**
     * 默认 OkHttpClient，可自行配置来替换默认实现
     *
     * @return OkHttpClient 实例
     */
    private OkHttpClient getDefaultClient() {
        final Map<String, String> headers = getHeaders();
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        if (headers != null) {//设置请求头信息
            builder.addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request.Builder requestBuilder = chain.request().newBuilder();
                    for (Object object : headers.entrySet()) {
                        Map.Entry entry = (Map.Entry) object;
                        requestBuilder.addHeader((String) entry.getKey(), (String) entry.getValue());
                    }
                    return chain.proceed(requestBuilder.build());
                }
            });
        }

        builder.connectTimeout(getTimeOut(), TimeUnit.SECONDS);

        if (printLog() || BuildConfig.DEBUG) {//打印 OkHttp 请求信息
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(loggingInterceptor);
        }
        return builder.build();
    }

    public T getService() {
        return mService;
    }
}
