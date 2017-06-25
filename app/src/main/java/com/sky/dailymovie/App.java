package com.sky.dailymovie;

import android.app.Application;
import android.content.Context;

import com.crashlytics.android.Crashlytics;

import io.fabric.sdk.android.Fabric;
import timber.log.Timber;

/**
 * 项目名称：DailyMovie
 * 类描述：
 * 创建人：tonycheng
 * 创建时间：2017/5/23 21:43
 * 邮箱：tonycheng93@outlook.com
 * 修改人：
 * 修改时间：
 * 修改备注：
 */

public class App extends Application {

    private static class SingletonHolder {
        private static final App INSTANCE = new App();
    }

    public static App getInstance() {
        return SingletonHolder.INSTANCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        long startTime = System.currentTimeMillis();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
        Fabric.with(this, new Crashlytics());

        long endTime = System.currentTimeMillis();
        Timber.d("init Application cost: ", (endTime - startTime) + " ms.");
    }

    public Context getContext() {
        return getApplicationContext();
    }
}
