package com.android.yetee.yeteemobile.module;

import com.android.yetee.yeteemobile.activity.EventMapActivity;
import com.android.yetee.yeteemobile.contract.EventMapContract;
import com.android.yetee.yeteemobile.presenter.EventMapPresenterImpl;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class EventMapActivityModule extends BaseActivityModule {

    @Binds
    public abstract EventMapContract.View view(EventMapActivity eventMapActivity);

    @Provides
    static EventMapContract.Presenter provideEventMapPresenter(EventMapContract.View view) {
        return new EventMapPresenterImpl(view, getManagerComponents().getEventManager());
    }
}
