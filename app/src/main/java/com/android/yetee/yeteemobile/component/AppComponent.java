package com.android.yetee.yeteemobile.component;

import android.app.Application;

import com.android.yetee.yeteemobile.app.YeteeApplication;
import com.android.yetee.yeteemobile.module.ActivityBindingsModule;
import com.android.yetee.yeteemobile.module.AppModule;
import com.android.yetee.yeteemobile.module.FragmentBindingsModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class,
        AppModule.class,
        ActivityBindingsModule.class,
        FragmentBindingsModule.class})
public interface AppComponent extends AndroidInjector<YeteeApplication> {
    @Override
    void inject(YeteeApplication instance);

    @Component.Builder
    interface Builder {
        @BindsInstance
        AppComponent.Builder application(Application application);
        AppComponent build();
    }
}