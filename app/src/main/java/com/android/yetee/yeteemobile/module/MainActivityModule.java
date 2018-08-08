package com.android.yetee.yeteemobile.module;


import com.android.yetee.yeteemobile.activity.MainActivity;
import com.android.yetee.yeteemobile.contract.MainContract;
import com.android.yetee.yeteemobile.presenter.MainPresenterImpl;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class MainActivityModule {

    @Binds
    public abstract MainContract.View view(MainActivity mainActivity);

    @Provides
    static MainContract.Presenter provideMainPresenter(MainContract.View view) {
        return new MainPresenterImpl(view);
    }
}
