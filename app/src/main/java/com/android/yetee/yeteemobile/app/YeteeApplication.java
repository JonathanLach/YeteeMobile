package com.android.yetee.yeteemobile.app;

import android.content.Context;

import com.android.yetee.yeteemobile.component.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class YeteeApplication extends DaggerApplication {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getBaseContext();
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder()
                .application(this)
                .build();
    }

    public static Context getYeteeContext() {
        return context;
    }
}