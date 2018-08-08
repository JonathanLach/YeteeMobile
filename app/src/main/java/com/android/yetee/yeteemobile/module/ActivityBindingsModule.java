package com.android.yetee.yeteemobile.module;

import com.android.yetee.yeteemobile.activity.EventMapActivity;
import com.android.yetee.yeteemobile.activity.LoginActivity;
import com.android.yetee.yeteemobile.activity.MainActivity;
import com.android.yetee.yeteemobile.annotation.ActivityScope;

import dagger.Module;
import dagger.android.AndroidInjectionModule;
import dagger.android.ContributesAndroidInjector;

@Module(includes = AndroidInjectionModule.class)
public abstract class ActivityBindingsModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = LoginActivityModule.class)
    abstract LoginActivity loginActivityInjector();

    @ActivityScope
    @ContributesAndroidInjector(modules = EventMapActivityModule.class)
    abstract EventMapActivity eventMapActivityInjector();
}