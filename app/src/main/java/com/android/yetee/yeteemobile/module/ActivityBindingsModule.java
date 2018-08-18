package com.android.yetee.yeteemobile.module;

import com.android.yetee.yeteemobile.activity.EventMapActivity;
import com.android.yetee.yeteemobile.activity.EventSubscribtionsActivity;
import com.android.yetee.yeteemobile.activity.EventsListActivity;
import com.android.yetee.yeteemobile.activity.LoginActivity;
import com.android.yetee.yeteemobile.activity.PointsOfInterestActivity;
import com.android.yetee.yeteemobile.activity.ProfileActivity;
import com.android.yetee.yeteemobile.activity.RegisterActivity;
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

    @ActivityScope
    @ContributesAndroidInjector(modules = EventsListActivityModule.class)
    abstract EventsListActivity eventsListActivityInjector();

    @ActivityScope
    @ContributesAndroidInjector(modules = RegisterActivityModule.class)
    abstract RegisterActivity registerActivityInjector();

    @ActivityScope
    @ContributesAndroidInjector(modules = EventSubscribtionActivityModule.class)
    abstract EventSubscribtionsActivity eventSubscribtionsActivityInjector();

    @ActivityScope
    @ContributesAndroidInjector(modules = ProfileActivityModule.class)
    abstract ProfileActivity profileActivityInjector();

    @ActivityScope
    @ContributesAndroidInjector(modules = PointsOfInterestActivityModule.class)
    abstract PointsOfInterestActivity pointsOfInterestActivityInjector();
}