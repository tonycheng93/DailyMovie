package com.sky.dailymovie;

import com.google.common.util.concurrent.FakeTimeLimiter;

import android.app.Application;
import android.content.Context;

import com.crashlytics.android.Crashlytics;
import com.squareup.leakcanary.LeakCanary;

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

    private static final String TAG = "App";

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
        Timber.tag(TAG);
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
        Fabric.with(this, new Crashlytics());

        if (LeakCanary.isInAnalyzerProcess(this)){
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);

        long endTime = System.currentTimeMillis();
        Timber.d("init Application cost: ", (endTime - startTime) + " ms.");
    }

    public Context getContext() {
        return getApplicationContext();
    }
}
