package com.sky.dailymovie.injection.component;

import android.app.Application;
import android.content.Context;

import com.sky.dailymovie.injection.ApplicationContext;
import com.sky.dailymovie.injection.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    @ApplicationContext
    Context context();

    Application application();
}
