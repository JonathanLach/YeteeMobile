package com.android.yetee.yeteemobile.module;


import com.android.yetee.yeteemobile.annotation.FragmentScope;
import com.android.yetee.yeteemobile.fragment.EventDetailsFragment;
import com.android.yetee.yeteemobile.fragment.EventsListFragment;

import dagger.Module;
import dagger.android.AndroidInjectionModule;
import dagger.android.ContributesAndroidInjector;

@Module(includes = AndroidInjectionModule.class)
public abstract class FragmentBindingsModule {
    @FragmentScope
    @ContributesAndroidInjector(modules = EventsListActivityModule.class)
    abstract EventsListFragment eventsListFragmentInjector();

    @FragmentScope
    @ContributesAndroidInjector(modules = EventDetailsFragmentModule.class)
    abstract EventDetailsFragment eventDetailsInjector();
}