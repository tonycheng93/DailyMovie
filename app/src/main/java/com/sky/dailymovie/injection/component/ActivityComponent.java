package com.sky.dailymovie.injection.component;

import com.sky.dailymovie.MainActivity;
import com.sky.dailymovie.injection.PerActivity;
import com.sky.dailymovie.injection.module.ActivityModule;

import dagger.Subcomponent;

/**
 * This component inject dependencies to all Activities across the application
 */
@PerActivity
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);

}
